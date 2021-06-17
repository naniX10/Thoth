package thoth.spring.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.Product;

import java.util.List;

@Repository("pdao")
public class ProductDAOImpl implements ProductDAO{

    @Autowired private SqlSession sqlSession;

    // 상품 조회
    // snum은 페이징에 사용 limit snum 10
    @Override
    public List<Product> selectProduct(int snum) {

        return sqlSession.selectList("product.selectProduct",snum);
    }

    // 전체 페이지 수 구하기
    @Override
    public int selectCountProduct() {
        return sqlSession.selectOne("product.countProduct");
    }

    // 상품 상세 조회
    // tnum의 상품 조회
    @Override
    public Product selectOneProduct(String tnum) {

        return sqlSession.selectOne("product.selectOne",tnum);
    }



}
