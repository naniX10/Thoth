package thoth.spring.project.service;

import org.springframework.web.multipart.MultipartFile;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;

public interface CoProductService {
    List<Product> coreadProduct(String cp);
    int cocountProduct();
    List<Product> coreadProduct(String cp, String findtype, String findkey);
    int cocountProduct(String findtype, String findkey);
    boolean conewProduct(Product p, BookImage b, MultipartFile[] img);
    Product coreadOneProduct(String tnum);
    BookImage coreadOneImage(String tnum);
    Product coremoveProduct(String tnum);
    BookImage coremoveImage(String tnum);
    void comodifyProduct(Product p);
    void comodifyImage(BookImage b, MultipartFile[] img);
}
