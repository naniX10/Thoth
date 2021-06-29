package thoth.spring.project.service;

import org.springframework.web.multipart.MultipartFile;
import thoth.spring.project.vo.Order;

import java.util.List;

public interface OrderService {

    // 상품 등록
    boolean newOrder(Order o);

    // 특정 상품 조회
    Order readOneOrder(String tnum);


    int countOrder();
}
