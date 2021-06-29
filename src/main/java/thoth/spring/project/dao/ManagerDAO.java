package thoth.spring.project.dao;

import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Member;
import thoth.spring.project.vo.Order;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

public interface ManagerDAO {


    // 상품 조회 - snum부터 n개의 게시물 출력(현재는 20개로 설정)
    List<Member> selectMmember();
    List<Order> selectMorder();



}
