package thoth.spring.project.service;

import org.springframework.web.multipart.MultipartFile;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;

public interface BaProductService {
    List<Product> bareadProduct(String cp);
    int bacountProduct();
    List<Product> bareadProduct(String cp, String findtype, String findkey);
    int bacountProduct(String findtype, String findkey);
    boolean banewProduct(Product p, BookImage b, MultipartFile[] img);
    Product bareadOneProduct(String tnum);
    BookImage bareadOneImage(String tnum);
    Product baremoveProduct(String tnum);
    BookImage baremoveImage(String tnum);
    void bamodifyProduct(Product p);
    void bamodifyImage(BookImage b, MultipartFile[] img);
}
