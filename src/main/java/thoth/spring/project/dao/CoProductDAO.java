package thoth.spring.project.dao;

import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

public interface CoProductDAO {

    // 파일 이름 읽어오기 (상품 수정에 사용)
    String readFnames(String tnum);

    // 파일 크기 읽어오기 (상품 수정에 사용)
    String readFsizes(String tnum);

    /* ch */
    List<Product> coselectProduct(int snum);
    int coselectCountProduct();
    List<Product> cofindSelectProduct(Map<String, Object> params);
    int coselectCountProduct(Map<String, Object> params);
    int coinsertProduct(Product p, BookImage b);
    Product coselectOneProduct(String tnum);
    BookImage coselectOneImage(String tnum);

    void codeleteProduct(String tnum);
    void codeleteImage(String tnum);

    int coupdateProduct(Product p);
    int coupdateImage(BookImage b);
}
