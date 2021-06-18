package thoth.spring.project.dao;

import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

public interface ProductDAO {
    
    /* 개발 가이드
        1. 상품 조회 - 개발우선순서
        2. 상품 상세조회 - 개발우선순서 2
        3. 상품 등록 - 개발우선순서 3
        4. 상품 삭제 - 개발우선순서 4
        5. 상품 수정 - 시간이 남을 경우 구현할 것
     */

    // 상품 조회 - snum부터 n개의 게시물 출력(현재는 10개로 설정)
    List<Product> selectProduct(int snum);

    // 상품 조회 - 전체 상품 수 구하기
    int selectCountProduct();

    // 상품 조회 - 검색 기능
    List<Product> findSelectProduct(Map<String,Object> param);

    // 상품 조회 - 검색된 상품 수
    int selectCountProduct(Map<String,Object> params);

    // 상품 상세조회 - tnum의 값 조회
    Product selectOneProduct(String tnum);

    // 상품 등록
    int insertProduct(Product p);


}
