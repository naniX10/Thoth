package thoth.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import thoth.spring.project.service.LProductService;
import thoth.spring.project.service.MProductService;
import thoth.spring.project.utils.ImgUploadUtil;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

@Controller
public class MProductController {

    @Autowired
    private MProductService pmsrv;
    @Autowired
    private ImgUploadUtil imgUtil;

    @GetMapping("/product/mplist")
    public ModelAndView mplist(ModelAndView mv, String cp) {
        if(cp==null) cp="1";
        mv.setViewName("product/mplist.tiles");
        mv.addObject("pds",pmsrv.mreadProduct(cp));   // 상품 조회
        mv.addObject("pcnt",pmsrv.mcountProduct());   // 상품 전체 수 구하기
        return mv;
    }

    @GetMapping("/product/mfind")
    public ModelAndView mfind(ModelAndView mv, String cp, String findtype, String findkey){
        mv.setViewName("product/mplist.tiles");
        mv.addObject("pds",pmsrv.mreadProduct(cp,findtype,findkey));  // 검색
        mv.addObject("pcnt",pmsrv.mcountProduct(findtype,findkey));   // 검색된 상품 수 구하기

        return mv;
    }

    @GetMapping("/product/mpwrite")
    public String mpwrite() {return "product/mpwrite.tiles";}

    @PostMapping("/product/mpwrite")
    public String mpwriteok(Product p, BookImage b, MultipartFile[] img){

        String returnPage = "redirect:/product/mplist";

        if(pmsrv.mnewProduct(p,b,img))
            System.out.println("상품 등록이 완료되었습니다.");

        return returnPage;
    }

    @GetMapping("/product/mpviewchild")
    public ModelAndView mpview(String tnum, ModelAndView mv) {

        mv.setViewName("product/mpview.tiles");
        mv.addObject("p", pmsrv.mreadOneProduct(tnum));   // tnum 상품 정보 조회
        mv.addObject("b",pmsrv.mreadOneImage(tnum)); // 이미지 조회
        return mv;
    }

    @GetMapping("/product/mpremove")
    public String mpremove(String tnum){
        Product p = pmsrv.mremoveProduct(tnum); // 상품 삭제
        BookImage b = pmsrv.mremoveImage(tnum); // 상품 이미지 삭제
        imgUtil.removeImage(b);

        return "redirect:/product/mplist";
    }

    @GetMapping("/product/mpupdate")
    public ModelAndView mpupdate(ModelAndView mv, String tnum)
    {
        mv.setViewName("product/mpupdate.tiles");
        mv.addObject("p",pmsrv.mreadOneProduct(tnum));
        mv.addObject("b",pmsrv.mreadOneImage(tnum));
        return mv;
    }

    @PostMapping("/product/mpupdate")
    public String mpupdateok(Product p,BookImage b, MultipartFile[] img){
        pmsrv.mmodifyProduct(p);
        if(b.getTodie()!=""){
            pmsrv.mmodifyImage(b,img);
        }
        return "redirect:/product/mplist";
    }

}
