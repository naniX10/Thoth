package thoth.spring.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import thoth.spring.project.service.ManagerService;
import thoth.spring.project.service.MemberService;
import thoth.spring.project.service.OrderService;
import thoth.spring.project.service.ProductService;
import thoth.spring.project.utils.ImgUploadUtil;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

@Controller
public class ManagerController {

    @Autowired
    private ManagerService mgsrv;
    @Autowired
    private ProductService psrv;
    @Autowired
    private OrderService osrv;
    @Autowired
    private MemberService mbsrv;

    // 리스트 - 회원 정보 조회
    @GetMapping("/manage/managePage")
    public ModelAndView pmMlist(ModelAndView mv) {
        mv.setViewName("manage/managePage.tiles");
        mv.addObject("mps",mgsrv.readMmember());   // 상품 조회
        mv.addObject("tps", mgsrv.readMorder());   // 상품 조회
        mv.addObject("pcnt",psrv.countProduct());   // 상품 전체 수 구하기
        mv.addObject("mcnt", mbsrv.countMember());   // 회원 전체 수 구하기
        mv.addObject("ocnt",osrv.countOrder());   // 주문 전체 수 구하기
        return mv;
    }




}
