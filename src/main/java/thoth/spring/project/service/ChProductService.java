package thoth.spring.project.service;

import org.springframework.web.multipart.MultipartFile;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;

public interface ChProductService {
    List<Product> chreadProduct(String cp);
    int chcountProduct();
    List<Product> chreadProduct(String cp, String findtype, String findkey);
    int chcountProduct(String findtype, String findkey);
    boolean chnewProduct(Product p, BookImage b, MultipartFile[] img);
    Product chreadOneProduct(String tnum);
    BookImage chreadOneImage(String tnum);
    Product chremoveProduct(String tnum);
    BookImage chremoveImage(String tnum);
    void chmodifyProduct(Product p);
    void chmodifyImage(BookImage b, MultipartFile[] img);
}
