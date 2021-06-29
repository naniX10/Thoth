package thoth.spring.project.dao;

import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

public interface BaProductDAO {

    // 파일 이름 읽어오기 (상품 수정에 사용)
    String readFnames(String tnum);

    // 파일 크기 읽어오기 (상품 수정에 사용)
    String readFsizes(String tnum);

    /* ch */
    List<Product> baselectProduct(int snum);
    int baselectCountProduct();
    List<Product> bafindSelectProduct(Map<String, Object> params);
    int baselectCountProduct(Map<String, Object> params);
    int bainsertProduct(Product p, BookImage b);
    Product baselectOneProduct(String tnum);
    BookImage baselectOneImage(String tnum);

    void badeleteProduct(String tnum);
    void badeleteImage(String tnum);

    int baupdateProduct(Product p);
    int baupdateImage(BookImage b);
}
