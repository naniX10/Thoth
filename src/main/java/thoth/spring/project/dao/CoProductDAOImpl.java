package thoth.spring.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

@Repository("pcodao")
public class CoProductDAOImpl implements CoProductDAO{

    @Autowired private SqlSession sqlSession;

    // 파일 이름 읽어오기
    @Override
    public String readFnames(String tnum) {
        return sqlSession.selectOne("product.readFnames",tnum);
    }

    // 파일 크기 읽어오기
    @Override
    public String readFsizes(String tnum) {
        return sqlSession.selectOne("product.readFsizes",tnum);
    }

    /* ch */

    @Override
    public List<Product> coselectProduct(int snum) {
        return sqlSession.selectList("coproduct.coselectProduct",snum);
    }

    @Override
    public int coselectCountProduct() {
        return sqlSession.selectOne("coproduct.cocountProduct");
    }

    @Override
    public List<Product> cofindSelectProduct(Map<String, Object> params) {
        return sqlSession.selectList("coproduct.cofindSelect",params) ;
    }

    @Override
    public int coselectCountProduct(Map<String, Object> params) {
        return sqlSession.selectOne("coproduct.cofindSelectCount",params);
    }

    @Override
    public int coinsertProduct(Product p, BookImage b) {
        int result = sqlSession.insert("coproduct.coinsertProduct",p);
        sqlSession.insert("coproduct.insertImage",b);
        return result;
    }

    @Override
    public Product coselectOneProduct(String tnum) {
        return sqlSession.selectOne("coproduct.coselectOne",tnum);
    }

    @Override
    public BookImage coselectOneImage(String tnum) {
        return  sqlSession.selectOne("coproduct.coselectOneImage",tnum);
    }

    @Override
    public void codeleteProduct(String tnum) {
        sqlSession.delete("coproduct.codeleteProduct",tnum);
    }

    @Override
    public void codeleteImage(String tnum) {
        sqlSession.delete("coproduct.codeleteImage",tnum);
    }

    @Override
    public int coupdateProduct(Product p) {
        return sqlSession.update("coproduct.coupdateProduct",p);
    }

    @Override
    public int coupdateImage(BookImage b) {
        return sqlSession.update("coproduct.coupdateImage",b);
    }


}
