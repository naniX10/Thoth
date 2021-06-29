package thoth.spring.project.service;

import org.springframework.web.multipart.MultipartFile;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;

public interface LProductService {
    List<Product> lreadProduct(String cp);
    int lcountProduct();
    List<Product> lreadProduct(String cp, String findtype, String findkey);
    int lcountProduct(String findtype, String findkey);
    boolean lnewProduct(Product p, BookImage b, MultipartFile[] img);
    Product lreadOneProduct(String tnum);
    BookImage lreadOneImage(String tnum);
    Product lremoveProduct(String tnum);
    BookImage lremoveImage(String tnum);
    void lmodifyProduct(Product p);
    void lmodifyImage(BookImage b, MultipartFile[] img);
}
