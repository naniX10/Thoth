package thoth.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import thoth.spring.project.service.ChProductService;
import thoth.spring.project.utils.ImgUploadUtil;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

@Controller
public class ChProductController {

    @Autowired
    private ChProductService pchsrv;
    @Autowired
    private ImgUploadUtil imgUtil;

    @GetMapping("/product/chpchild")
    public ModelAndView chpchild(ModelAndView mv, String cp) {
        if(cp==null) cp="1";
        mv.setViewName("product/chpchild.tiles");
        mv.addObject("pds",pchsrv.chreadProduct(cp));   // 상품 조회
        mv.addObject("pcnt",pchsrv.chcountProduct());   // 상품 전체 수 구하기
        return mv;
    }

    @GetMapping("/product/chfindchild")
    public ModelAndView chfind(ModelAndView mv, String cp, String findtype, String findkey){
        mv.setViewName("product/chpchild.tiles");
        mv.addObject("pds",pchsrv.chreadProduct(cp,findtype,findkey));  // 검색
        mv.addObject("pcnt",pchsrv.chcountProduct(findtype,findkey));   // 검색된 상품 수 구하기

        return mv;
    }

    @GetMapping("/product/chpwrite")
    public String chpwrite() {return "product/chpwrite.tiles";}

    @PostMapping("/product/chpwrite")
    public String chpwriteok(Product p, BookImage b, MultipartFile[] img){

        String returnPage = "redirect:/product/chpchild";

        if(pchsrv.chnewProduct(p,b,img))
            System.out.println("상품 등록이 완료되었습니다.");

        return returnPage;
    }

    @GetMapping("/product/chpviewchild")
    public ModelAndView chpview(String tnum, ModelAndView mv) {

        mv.setViewName("product/chpview.tiles");
        mv.addObject("p", pchsrv.chreadOneProduct(tnum));   // tnum 상품 정보 조회
        mv.addObject("b",pchsrv.chreadOneImage(tnum)); // 이미지 조회
        return mv;
    }

    @GetMapping("/product/chpremove")
    public String chpremove(String tnum){
        Product p = pchsrv.chremoveProduct(tnum); // 상품 삭제
        BookImage b = pchsrv.chremoveImage(tnum); // 상품 이미지 삭제
        imgUtil.removeImage(b);

        return "redirect:/product/chpchild";
    }

    @GetMapping("/product/chpupdate")
    public ModelAndView chpupdate(ModelAndView mv, String tnum)
    {
        mv.setViewName("product/chpupdate.tiles");
        mv.addObject("p",pchsrv.chreadOneProduct(tnum));
        mv.addObject("b",pchsrv.chreadOneImage(tnum));
        return mv;
    }

    @PostMapping("/product/chpupdate")
    public String chpupdateok(Product p,BookImage b, MultipartFile[] img){
        pchsrv.chmodifyProduct(p);
        if(b.getTodie()!=""){
            pchsrv.chmodifyImage(b,img);
        }
        return "redirect:/product/chpchild";
    }

}
