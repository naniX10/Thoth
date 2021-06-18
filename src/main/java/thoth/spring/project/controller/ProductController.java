package thoth.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import thoth.spring.project.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService psrv;

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
        mv.addObject("pcnt",psrv.countProduct(findtype,findkey));

        return mv;
    }

    @GetMapping("/product/pview")
    public String pview() {return "product/pview.tiles";}

    @GetMapping("/product/pwrite")
    public String pwrite() {return "product/pwrite.tiles";}

}
