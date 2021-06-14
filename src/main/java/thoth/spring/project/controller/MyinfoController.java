package thoth.spring.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyinfoController {

    @GetMapping("/myinfo/mlist")
    public String plist() {return "myinfo/mlist.tiles";}

    @GetMapping("/myinfo/mreply")
    public String preply() {return "myinfo/mreply.tiles";}

    @GetMapping("/myinfo/mview")
    public String pview() {return "myinfo/mview.tiles";}

    @GetMapping("/myinfo/mwrite")
    public String pwrite() {return "myinfo/mwrite.tiles";}

}
