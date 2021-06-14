package thoth.spring.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoticeController {

    @GetMapping("/notice/ndelete")
    public String ndelete() {return "notice/ndelete.tiles";}

    @GetMapping("/notice/nlist")
    public String nlist() {return "notice/nlist.tiles";}

    @GetMapping("/notice/nmodify")
    public String nmodify() {return "notice/nmodify.tiles";}

    @GetMapping("/notice/nview")
    public String nview() {return "notice/nview.tiles";}

    @GetMapping("/notice/nwrite")
    public String nwrite() {return "notice/nwrite.tiles";}

}
