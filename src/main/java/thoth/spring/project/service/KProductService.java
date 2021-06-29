package thoth.spring.project.service;

import org.springframework.web.multipart.MultipartFile;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;

public interface KProductService {
    List<Product> kreadProduct(String cp);
    int kcountProduct();
    List<Product> kreadProduct(String cp, String findtype, String findkey);
    int kcountProduct(String findtype, String findkey);
    boolean knewProduct(Product p, BookImage b, MultipartFile[] img);
    Product kreadOneProduct(String tnum);
    BookImage kreadOneImage(String tnum);
    Product kremoveProduct(String tnum);
    BookImage kremoveImage(String tnum);
    void kmodifyProduct(Product p);
    void kmodifyImage(BookImage b, MultipartFile[] img);
}
