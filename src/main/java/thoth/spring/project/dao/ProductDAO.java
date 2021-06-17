package thoth.spring.project.dao;

import thoth.spring.project.vo.Product;

import java.util.List;

public interface ProductDAO {
    
    /* 개발 가이드
        1. 상품 조회 - 개발우선순서
        2. 상품 상세조회 - 개발우선순서 2
        3. 상품 등록 - 개발우선순서 3
        4. 상품 삭제 - 개발우선순서 4
        5. 상품 수정 - 시간이 남을 경우 구현할 것
     */

    // 상품 조회
    // snum은 paging 구현을 위해 사용
    // limit snum, 10이면 snum부터 10개 출력
    List<Product> selectProduct(int snum);

    // 상품 상세조회
    // tnum의 값을 상세조회
    Product selectOneProduct(String tnum);

    int selectCountProduct();
}
