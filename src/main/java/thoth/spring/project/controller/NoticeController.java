package thoth.spring.project.controller;

import org.springframework.web.bind.annotation.*;
import thoth.spring.project.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import thoth.spring.project.vo.Notice;

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

    @GetMapping("/notice/ntview")
    public ModelAndView view(String bdno, ModelAndView mv) {
        mv.setViewName("notice/ntview.tiles");
        mv.addObject("bd", nsrv.readOneBoard(bdno));
        return mv;
    }

    @GetMapping("/notice/ntwrite")
    public String write() {
        return "notice/ntwrite.tiles";
    }

    @PostMapping("/notice/ntwrite")
    public String writeok(Notice bd) {
        String returnPage = "redirect:/notice/ntlist";
        if (nsrv.newBoard(bd))
            System.out.println("입력완료!");
        return returnPage;
    }

    @GetMapping("/notice/ntupdate")
    public ModelAndView update(@RequestParam("bdno") String bd , ModelAndView mv) {
        mv.setViewName("notice/ntupdate.tiles");
        mv.addObject("bd", nsrv.readOneBoard(bd));
        return mv;
    }

}

