package thoth.spring.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index/join")
    public String indexJoin() {return "index/join.tiles";}

    @GetMapping("/index/joinok")
    public String indexJoinok() {return "index/joinok.tiles";}

    @GetMapping("/index/login")
    public String indexLogin() {return "index/login.tiles";}

    @GetMapping("/index/loginok")
    public String indexLoginok() {return "index/loginok.tiles";}

    @GetMapping("/index/loginout")
    public String indexLoginout() {return "index/loginout.tiles";}

}
