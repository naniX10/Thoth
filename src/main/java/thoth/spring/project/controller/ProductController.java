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


    @GetMapping("/product/plist")
    public ModelAndView plist(ModelAndView mv, String cp) {
        if(cp==null) cp="1";
        mv.setViewName("product/plist.tiles");
        mv.addObject("pds",psrv.readProduct(cp));
        mv.addObject("pcnt",psrv.countProduct());
        return mv;
    }

    @GetMapping("/product/pview")
    public String pview() {return "product/pview.tiles";}

    @GetMapping("/product/pwrite")
    public String pwrite() {return "product/pwrite.tiles";}

}
