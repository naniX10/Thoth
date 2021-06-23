package thoth.spring.project.dao;

import thoth.spring.project.vo.BookImage;
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
    int insertProduct(Product p, BookImage b);
    
    // 상품 삭제 - view에서
    void deleteProduct(String tnum);

    // 상품 상세조회 - 이미지
    BookImage selectOneImage(String tnum);

    // 상품 삭제 - 이미지
    void deleteImage(String tnum);

    // 상품 수정
    int updateProduct(Product p);

    // 상품 수정 - 이미지
    int updateImage(BookImage b);

    // 파일 이름 읽어오기 (상품 수정에 사용)
    String readFnames(String tnum);

    // 파일 크기 읽어오기 (상품 수정에 사용)
    String readFsizes(String tnum);

    //상품 선택 삭제 - list에서
}
