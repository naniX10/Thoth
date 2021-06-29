package thoth.spring.project.service;

import org.springframework.web.multipart.MultipartFile;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Member;
import thoth.spring.project.vo.Order;
import thoth.spring.project.vo.Product;

import java.util.List;

public interface ManagerService {
    
    // 조회
    List<Member> readMmember();
    List<Order> readMorder();

    


}
