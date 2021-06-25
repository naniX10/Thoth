package thoth.spring.project.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import thoth.spring.project.service.MyinfoReplyService;
import thoth.spring.project.service.MyinfoService;
import thoth.spring.project.vo.Myinfo;
import thoth.spring.project.vo.mReply;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyinfoController {

    private MyinfoService msrv;
    private MyinfoReplyService mrsrv;

    @Autowired
    public MyinfoController(MyinfoService msrv, MyinfoReplyService mrsrv) {
        this.msrv = msrv;
        this.mrsrv = mrsrv;
    }



    @GetMapping("/myinfo/mlist")
    public ModelAndView mlist(ModelAndView mv, String cp) {

        if (cp == null) cp = "1";
        mv.setViewName("myinfo/mlist.tiles");
        mv.addObject("mis",msrv.readQna(cp));
        mv.addObject("micnt",msrv.countQna());

        return mv;

    }



    @GetMapping("/myinfo/mreply")
    public ModelAndView view(String mino, ModelAndView mv) {

        mv.setViewName("myinfo/mreply.tiles");
        mv.addObject("mi", msrv.readOneQna(mino));
        mv.addObject("rps", mrsrv.readReply(mino));

        return mv;
    }

    @GetMapping("/myinfo/mwrite")
    public String mwrite() {
        return "myinfo/mwrite.tiles";
    }

    @PostMapping("/myinfo/mwrite")
    public String writeok(Myinfo mi) {
        String returnPage = "redirect:/myinfo/mlist";

        if (msrv.newQna(mi))
            System.out.println("작성 완료!");

        return returnPage;
    }

    // 게시판 검색 기능
    @GetMapping("/myinfo/find")
    public ModelAndView find(ModelAndView mv, String cp,
                             String findtype, String findkey) {

        mv.setViewName("myinfo/mlist.tiles");
        mv.addObject("mis",
                msrv.readQna(cp, findtype, findkey));
        mv.addObject("micnt",
                msrv.countQna(findtype, findkey));

        return mv;
    }

    // 댓글 쓰기
    @PostMapping("/reply/write")
    public String replyok(mReply r) {

        String returnPage = "redirect:/myinfo/mlist?mino="+r.getMino();

        mrsrv.newComment(r);

        return returnPage;
    }

    // 댓글 쓰기
    @PostMapping("/rreply/write")
    public String rreplyok(mReply r) {
        String returnPage = "redirect:/myinfo/mlist?mino="+r.getMino();

        mrsrv.newReply(r);

        return returnPage;
    }


    // QnA 글 삭제
    @GetMapping("/myinfo/qnarmv")
    public String mirmv(String mino) {

        int m = msrv.removeQna(mino);

        return "redirect:/myinfo/mlist";

    }


    // 내정보 등등
    @GetMapping("/myinfo/mview")
    public String mview() {
        return "myinfo/mview.tiles";
    }



}

