package thoth.spring.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/product/plist")
    public String plist() {return "product/plist.tiles";}

    @GetMapping("/product/pview")
    public String pview() {return "product/pview.tiles";}

    @GetMapping("/product/pwrite")
    public String pwrite() {return "product/pwrite.tiles";}

}
