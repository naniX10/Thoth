package thoth.spring.project.dao;

import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

public interface KProductDAO {

    // 파일 이름 읽어오기 (상품 수정에 사용)
    String readFnames(String tnum);

    // 파일 크기 읽어오기 (상품 수정에 사용)
    String readFsizes(String tnum);

    /* ch */
    List<Product> kselectProduct(int snum);
    int kselectCountProduct();
    List<Product> kfindSelectProduct(Map<String, Object> params);
    int kselectCountProduct(Map<String, Object> params);
    int kinsertProduct(Product p, BookImage b);
    Product kselectOneProduct(String tnum);
    BookImage kselectOneImage(String tnum);

    void kdeleteProduct(String tnum);
    void kdeleteImage(String tnum);

    int kupdateProduct(Product p);
    int kupdateImage(BookImage b);
}
