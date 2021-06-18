package thoth.spring.project.controller;

import thoth.spring.project.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService nsrv;

    @GetMapping("/notice/ntlist")
    public ModelAndView ntlist(ModelAndView mv, String cp) {
        if (cp == null) cp = "1";
        mv.setViewName("notice/ntlist.tiles");
        mv.addObject("bds", nsrv.readBoard(cp));

        return mv;
    }

}
