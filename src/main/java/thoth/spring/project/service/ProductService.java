package thoth.spring.project.service;

import thoth.spring.project.vo.Product;

import java.util.List;

public interface ProductService {

    /* 개발 가이드
        1. 상품 조회 - 개발우선순서
        2. 상품 상세조회 - 개발우선순서 2
        3. 상품 등록 - 개발우선순서 3
        4. 상품 삭제 - 개발우선순서 4
        5. 상품 수정 - 시간이 남을 경우 구현할 것
     */
     
    
    // 상품 조회
    // cp : 페이지 네비게이션에 사용
    List<Product> readProduct(String cp);
    // 게시글 수
    int countProduct();

    // 상품 상세조회
    // tnum : 테이블의 데이터 구분에 사용(key값)
    Product readOneProduct(String tnum);

    // 상품 등록
    // 상품 삭제
    // 상품 수정
}
