package thoth.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import thoth.spring.project.service.ProductService;
import thoth.spring.project.utils.ImgUploadUtil;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.awt.print.Book;

@Controller
public class ProductController {

    @Autowired
    private ProductService psrv;
    @Autowired
    private ImgUploadUtil imgUtil;

    // 리스트 - 상품 조회, 페이징
    @GetMapping("/product/plist")
    public ModelAndView plist(ModelAndView mv, String cp) {
        if(cp==null) cp="1";
        mv.setViewName("product/plist.tiles");
        mv.addObject("pds",psrv.readProduct(cp));   // 상품 조회
        mv.addObject("pcnt",psrv.countProduct());   // 상품 전체 수 구하기
        return mv;
    }
    // 리스트 - 검색
    @GetMapping("/product/find")
    public ModelAndView find(ModelAndView mv, String cp, String findtype, String findkey){
        mv.setViewName("product/plist.tiles");
        mv.addObject("pds",psrv.readProduct(cp,findtype,findkey));  // 검색
        mv.addObject("pcnt",psrv.countProduct(findtype,findkey));   // 검색된 상품 수 구하기

        return mv;
    }

    // 뷰 - 상품 정보 조회
    @GetMapping("/product/pview")
    public ModelAndView pview(String tnum, ModelAndView mv) {

        mv.setViewName("product/pview.tiles");
        mv.addObject("p", psrv.readOneProduct(tnum));   // tnum 상품 정보 조회
        mv.addObject("b",psrv.readOneImage(tnum)); // 이미지 조회
        return mv;
    }
    
    // write - 상품 등록 페이지
    @GetMapping("/product/pwrite")
    public String pwrite() {return "product/pwrite.tiles";}

    // write - 상품 등록 완료
    @PostMapping("/product/pwrite")
    public String pwriteok(Product p, BookImage b, MultipartFile[] img){

        String returnPage = "redirect:/product/plist";

        if(psrv.newProduct(p,b,img))
            System.out.println("상품 등록이 완료되었습니다.");

        return returnPage;
    }
    
    // 상품 삭제 - view에서 삭제
    @GetMapping("/product/premove")
    public String premove(String tnum){
        Product p = psrv.removeProduct(tnum); // 상품 삭제
        BookImage b = psrv.removeImage(tnum); // 상품 이미지 삭제
        imgUtil.removeImage(b);

        return "redirect:/product/plist";
    }

    // 상품 수정
    @GetMapping("/product/pupdate")
    public ModelAndView pupdate(ModelAndView mv, String tnum)
    {
        mv.setViewName("product/pupdate.tiles");
        mv.addObject("p",psrv.readOneProduct(tnum));
        mv.addObject("b",psrv.readOneImage(tnum));
        return mv;
    }

    // 상품 수정 완료
    @PostMapping("/product/pupdate")
    public String pupdateok(Product p,BookImage b, MultipartFile[] img){
        psrv.modifyProduct(p);
        if(b.getTodie()!=""){
            psrv.modifyImage(b,img);
        }
        return "redirect:/product/plist";
    }



}
