package thoth.spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import thoth.spring.project.dao.ManagerDAO;
import thoth.spring.project.dao.ProductDAO;
import thoth.spring.project.utils.ImgUploadUtil;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Member;
import thoth.spring.project.vo.Order;
import thoth.spring.project.vo.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("mgsrv")
public class ManagerServiceImpl implements ManagerService{

    @Autowired private ManagerDAO mgdao;

    // 상품 조회 - n개의 게시글 출력
    @Override
    public List<Member> readMmember() {
//        int snum = (Integer.parseInt(cp)-1)*10;
        return mgdao.selectMmember();
    }

    @Override
    public List<Order> readMorder() {
//        int snum = (Integer.parseInt(cp)-1)*10;
        return mgdao.selectMorder();
    }

}
