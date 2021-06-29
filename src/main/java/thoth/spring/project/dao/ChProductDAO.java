package thoth.spring.project.dao;

import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

public interface ChProductDAO {

    // 파일 이름 읽어오기 (상품 수정에 사용)
    String readFnames(String tnum);

    // 파일 크기 읽어오기 (상품 수정에 사용)
    String readFsizes(String tnum);

    /* ch */
    List<Product> chselectProduct(int snum);
    int chselectCountProduct();
    List<Product> ChfindSelectProduct(Map<String, Object> params);
    int ChselectCountProduct(Map<String, Object> params);
    int chinsertProduct(Product p, BookImage b);
    Product chselectOneProduct(String tnum);
    BookImage chselectOneImage(String tnum);

    void chdeleteProduct(String tnum);
    void chdeleteImage(String tnum);

    int chupdateProduct(Product p);
    int chupdateImage(BookImage b);
}
