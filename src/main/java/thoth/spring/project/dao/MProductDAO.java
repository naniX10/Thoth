package thoth.spring.project.dao;

import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

public interface MProductDAO {

    // 파일 이름 읽어오기 (상품 수정에 사용)
    String readFnames(String tnum);

    // 파일 크기 읽어오기 (상품 수정에 사용)
    String readFsizes(String tnum);

    /* ch */
    List<Product> mselectProduct(int snum);
    int mselectCountProduct();
    List<Product> mfindSelectProduct(Map<String, Object> params);
    int mselectCountProduct(Map<String, Object> params);
    int minsertProduct(Product p, BookImage b);
    Product mselectOneProduct(String tnum);
    BookImage mselectOneImage(String tnum);

    void mdeleteProduct(String tnum);
    void mdeleteImage(String tnum);

    int mupdateProduct(Product p);
    int mupdateImage(BookImage b);
}
