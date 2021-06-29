package thoth.spring.project.dao;


import thoth.spring.project.vo.Order;

public interface OrderDAO {

    // 상품 등록
    int insertOrder(Order O);

    // 특정 상품 조회
    Order selectOneOrder(String tnum);
}
