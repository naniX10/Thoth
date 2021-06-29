package thoth.spring.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import thoth.spring.project.service.MemberService;
import thoth.spring.project.service.MyinfoReplyService;
import thoth.spring.project.service.MyinfoService;
import thoth.spring.project.vo.Myinfo;
import thoth.spring.project.vo.mReply;
import thoth.spring.project.vo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyinfoController {

    private MemberService mbsrv;
    private MyinfoService msrv;
    private MyinfoReplyService mrsrv;

    @Autowired
    public MyinfoController(MyinfoService msrv, MyinfoReplyService mrsrv,
                            MemberService mbsrv) {
        this.msrv = msrv;
        this.mrsrv = mrsrv;
        this.mbsrv = mbsrv;
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
    @PostMapping("/reply/mwrite")
    public String replyok(mReply r) {

        String returnPage = "redirect:/myinfo/mreply?mino="+r.getMino();

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

    // QnA 글 수정
    @GetMapping("/myinfo/mupdate")
    public ModelAndView update(ModelAndView mv,String mino) {

        mv.setViewName("myinfo/mupdate.tiles");
        mv.addObject("mi",msrv.readOneQna(mino));

        return mv;
    }

    @PostMapping("/myinfo/mupdate")
    public String updateok(Myinfo m) {

        msrv.modifyQna(m);

        return "redirect:/myinfo/mlist";
    }



    // QnA 글 삭제
    @PostMapping("/myinfo/qnarmv")
    public String mirmv(String mino) {
        String returnPage = "redirect:/myinfo/mlist";
        if (msrv.deleteQna(mino))
            System.out.println("삭제완료!");
        return returnPage;

    }


    // 내정보 등등
    @GetMapping("/myinfo/mview")
    public String mview() {

        return "myinfo/mview.tiles";
    }

    // 내정보 수정?
    @GetMapping("/minfoupdate/mview")
    public ModelAndView miupdate(ModelAndView mv, String userid) {

        mv.setViewName("myinfo/mview.tiles");
        mv.addObject("member", msrv.readOneMem(userid));

        return mv;
    }

    @PostMapping("/minfoupdate/mview")
    public String miupdateok(Member member) {

        msrv.updatemyinfo(member);

        return "redirect:/myinfo/mview?" + member.getUserid();
    }


    // 내가쓴 글 보기?
    @GetMapping("/myinfo/mqnaview")
    public ModelAndView myqnaview(ModelAndView mv, String cp) {

        if (cp == null) cp = "1";
        mv.setViewName("myinfo/mview.tiles");
        mv.addObject("mmis",msrv.readMyQna(cp));
        mv.addObject("mmicnt",msrv.countQna());

        return mv;

    }



}

