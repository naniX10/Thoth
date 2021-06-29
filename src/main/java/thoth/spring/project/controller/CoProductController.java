package thoth.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import thoth.spring.project.service.BaProductService;
import thoth.spring.project.service.CoProductService;
import thoth.spring.project.utils.ImgUploadUtil;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

@Controller
public class CoProductController {

    @Autowired
    private CoProductService pcosrv;
    @Autowired
    private ImgUploadUtil imgUtil;

    @GetMapping("/product/copchild")
    public ModelAndView copchild(ModelAndView mv, String cp) {
        if(cp==null) cp="1";
        mv.setViewName("product/copchild.tiles");
        mv.addObject("pds",pcosrv.coreadProduct(cp));   // 상품 조회
        mv.addObject("pcnt",pcosrv.cocountProduct());   // 상품 전체 수 구하기
        return mv;
    }

    @GetMapping("/product/cofindchild")
    public ModelAndView cofind(ModelAndView mv, String cp, String findtype, String findkey){
        mv.setViewName("product/copchild.tiles");
        mv.addObject("pds",pcosrv.coreadProduct(cp,findtype,findkey));  // 검색
        mv.addObject("pcnt",pcosrv.cocountProduct(findtype,findkey));   // 검색된 상품 수 구하기

        return mv;
    }

    @GetMapping("/product/copwrite")
    public String copwrite() {return "product/copwrite.tiles";}

    @PostMapping("/product/copwrite")
    public String copwriteok(Product p, BookImage b, MultipartFile[] img){

        String returnPage = "redirect:/product/copchild";

        if(pcosrv.conewProduct(p,b,img))
            System.out.println("상품 등록이 완료되었습니다.");

        return returnPage;
    }

    @GetMapping("/product/copviewchild")
    public ModelAndView copview(String tnum, ModelAndView mv) {

        mv.setViewName("product/copview.tiles");
        mv.addObject("p", pcosrv.coreadOneProduct(tnum));   // tnum 상품 정보 조회
        mv.addObject("b",pcosrv.coreadOneImage(tnum)); // 이미지 조회
        System.out.println(mv);
        return mv;
    }

    @GetMapping("/product/copremove")
    public String copremove(String tnum){
        Product p = pcosrv.coremoveProduct(tnum); // 상품 삭제
        BookImage b = pcosrv.coremoveImage(tnum); // 상품 이미지 삭제
        imgUtil.removeImage(b);

        return "redirect:/product/copchild";
    }

    @GetMapping("/product/cobapupdate")
    public ModelAndView copupdate(ModelAndView mv, String tnum)
    {
        mv.setViewName("product/copupdate.tiles");
        mv.addObject("p",pcosrv.coreadOneProduct(tnum));
        mv.addObject("b",pcosrv.coreadOneImage(tnum));
        return mv;
    }

    @PostMapping("/product/copupdate")
    public String copupdateok(Product p,BookImage b, MultipartFile[] img){
        pcosrv.comodifyProduct(p);
        if(b.getTodie()!=""){
            pcosrv.comodifyImage(b,img);
        }
        return "redirect:/product/copchild";
    }

}
