package thoth.spring.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroController {
//    @GetMapping("/")
//    public String index() { return "index2";};

    @GetMapping("/")
    public String intro() {return "intro.tiles";}

}
