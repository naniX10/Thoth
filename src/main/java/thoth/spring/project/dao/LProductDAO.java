package thoth.spring.project.dao;

import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

public interface LProductDAO {

    // 파일 이름 읽어오기 (상품 수정에 사용)
    String readFnames(String tnum);

    // 파일 크기 읽어오기 (상품 수정에 사용)
    String readFsizes(String tnum);

    /* ch */
    List<Product> lselectProduct(int snum);
    int lselectCountProduct();
    List<Product> lfindSelectProduct(Map<String, Object> params);
    int lselectCountProduct(Map<String, Object> params);
    int linsertProduct(Product p, BookImage b);
    Product lselectOneProduct(String tnum);
    BookImage lselectOneImage(String tnum);

    void ldeleteProduct(String tnum);
    void ldeleteImage(String tnum);

    int lupdateProduct(Product p);
    int lupdateImage(BookImage b);
}
