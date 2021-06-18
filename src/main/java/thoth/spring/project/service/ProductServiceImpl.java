package thoth.spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thoth.spring.project.dao.ProductDAO;
import thoth.spring.project.vo.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("psrv")
public class ProductServiceImpl implements ProductService{

    @Autowired private ProductDAO pdao;

    // 상품 조회 - n개의 게시글 출력
    @Override
    public List<Product> readProduct(String cp) {
        int snum = (Integer.parseInt(cp)-1)*10; // 10개 게시물 출력
        return pdao.selectProduct(snum);
    }
    // 상품 조회 - 전체 상품 갯수 구하기
    @Override
    public int countProduct(){
        return pdao.selectCountProduct();
    }

    // 상품 조회 - 검색(내부)
    @Override
    public List<Product> readProduct(String cp, String ftype, String fkey) {
        int snum = 10*(Integer.parseInt(cp)-1); // 10개 게시물 고정
        Map<String, Object> params = new HashMap<>();
        params.put("snum",snum);
        params.put("ftype",ftype);
        params.put("fkey",fkey);
        return pdao.findSelectProduct(params);
    }

    // 상품 조회 - 검색된 상품 수
    @Override
    public int countProduct(String ftype, String fkey) {
        Map<String,Object> params = new HashMap<>();
        params.put("ftype",ftype);
        params.put("fkey",fkey);
        return pdao.selectCountProduct(params);
    }

    // 상품 상세 조회
    @Override
    public Product readOneProduct(String tnum) {
        return pdao.selectOneProduct(tnum);
    }
    
    // 상품 등록
    @Override
    public boolean newProduct(Product p){
        boolean isInserted = false;
        if(pdao.insertProduct(p)>0) isInserted = true;
        return isInserted;
    }




}
