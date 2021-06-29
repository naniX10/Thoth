package thoth.spring.project.service;

import org.springframework.web.multipart.MultipartFile;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;

public interface MProductService {
    List<Product> mreadProduct(String cp);
    int mcountProduct();
    List<Product> mreadProduct(String cp, String findtype, String findkey);
    int mcountProduct(String findtype, String findkey);
    boolean mnewProduct(Product p, BookImage b, MultipartFile[] img);
    Product mreadOneProduct(String tnum);
    BookImage mreadOneImage(String tnum);
    Product mremoveProduct(String tnum);
    BookImage mremoveImage(String tnum);
    void mmodifyProduct(Product p);
    void mmodifyImage(BookImage b, MultipartFile[] img);
}
