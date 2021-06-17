package thoth.spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thoth.spring.project.dao.ProductDAO;
import thoth.spring.project.vo.Product;

import java.util.List;

@Service("psrv")
public class ProductServiceImpl implements ProductService{

    @Autowired private ProductDAO pdao;
    // 상품 조회 기능 구현
    @Override
    public List<Product> readProduct(String cp) {
        int snum = (Integer.parseInt(cp)-1)*10;
        return pdao.selectProduct(snum);
    }

    @Override
    public int countProduct(){
        return pdao.selectCountProduct();
    }

    @Override
    public Product readOneProduct(String tnum) {
        return pdao.selectOneProduct(tnum);
    }




}
