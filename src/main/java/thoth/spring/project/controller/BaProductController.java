package thoth.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import thoth.spring.project.service.BaProductService;
import thoth.spring.project.service.ChProductService;
import thoth.spring.project.utils.ImgUploadUtil;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

@Controller
public class BaProductController {

    @Autowired
    private BaProductService pbasrv;
    @Autowired
    private ImgUploadUtil imgUtil;

    @GetMapping("/product/bapchild")
    public ModelAndView bapchild(ModelAndView mv, String cp) {
        if(cp==null) cp="1";
        mv.setViewName("product/bapchild.tiles");
        mv.addObject("pds",pbasrv.bareadProduct(cp));   // 상품 조회
        mv.addObject("pcnt",pbasrv.bacountProduct());   // 상품 전체 수 구하기
        return mv;
    }

    @GetMapping("/product/bafindchild")
    public ModelAndView bafind(ModelAndView mv, String cp, String findtype, String findkey){
        mv.setViewName("product/bapchild.tiles");
        mv.addObject("pds",pbasrv.bareadProduct(cp,findtype,findkey));  // 검색
        mv.addObject("pcnt",pbasrv.bacountProduct(findtype,findkey));   // 검색된 상품 수 구하기

        return mv;
    }

    @GetMapping("/product/bapwrite")
    public String bapwrite() {return "product/bapwrite.tiles";}

    @PostMapping("/product/bapwrite")
    public String bapwriteok(Product p, BookImage b, MultipartFile[] img){

        String returnPage = "redirect:/product/bapchild";

        if(pbasrv.banewProduct(p,b,img))
            System.out.println("상품 등록이 완료되었습니다.");

        return returnPage;
    }

    @GetMapping("/product/bapviewchild")
    public ModelAndView bapview(String tnum, ModelAndView mv) {

        mv.setViewName("product/bapview.tiles");
        mv.addObject("p", pbasrv.bareadOneProduct(tnum));   // tnum 상품 정보 조회
        mv.addObject("b",pbasrv.bareadOneImage(tnum)); // 이미지 조회
        return mv;
    }

    @GetMapping("/product/bapremove")
    public String bapremove(String tnum){
        Product p = pbasrv.baremoveProduct(tnum); // 상품 삭제
        BookImage b = pbasrv.baremoveImage(tnum); // 상품 이미지 삭제
        imgUtil.removeImage(b);

        return "redirect:/product/bapchild";
    }

    @GetMapping("/product/bapupdate")
    public ModelAndView bapupdate(ModelAndView mv, String tnum)
    {
        mv.setViewName("product/bapupdate.tiles");
        mv.addObject("p",pbasrv.bareadOneProduct(tnum));
        mv.addObject("b",pbasrv.bareadOneImage(tnum));
        return mv;
    }

    @PostMapping("/product/bapupdate")
    public String bapupdateok(Product p,BookImage b, MultipartFile[] img){
        pbasrv.bamodifyProduct(p);
        if(b.getTodie()!=""){
            pbasrv.bamodifyImage(b,img);
        }
        return "redirect:/product/bapchild";
    }

}
