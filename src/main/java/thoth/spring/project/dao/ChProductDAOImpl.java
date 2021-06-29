package thoth.spring.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

@Repository("pchdao")
public class ChProductDAOImpl implements ChProductDAO{

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
    public List<Product> chselectProduct(int snum) {
        return sqlSession.selectList("chproduct.chselectProduct",snum);
    }

    @Override
    public int chselectCountProduct() {
        return sqlSession.selectOne("chproduct.chcountProduct");
    }

    @Override
    public List<Product> ChfindSelectProduct(Map<String, Object> params) {
        return sqlSession.selectList("chproduct.ChfindSelect",params) ;
    }

    @Override
    public int ChselectCountProduct(Map<String, Object> params) {
        return sqlSession.selectOne("chproduct.ChfindSelectCount",params);
    }

    @Override
    public int chinsertProduct(Product p, BookImage b) {
        int result = sqlSession.insert("chproduct.chinsertProduct",p);
        sqlSession.insert("chproduct.insertImage",b);
        return result;
    }

    @Override
    public Product chselectOneProduct(String tnum) {
        return sqlSession.selectOne("chproduct.chselectOne",tnum);
    }

    @Override
    public BookImage chselectOneImage(String tnum) {
        return  sqlSession.selectOne("chproduct.chselectOneImage",tnum);
    }

    @Override
    public void chdeleteProduct(String tnum) {
        sqlSession.delete("chproduct.chdeleteProduct",tnum);
    }

    @Override
    public void chdeleteImage(String tnum) {
        sqlSession.delete("chproduct.chdeleteImage",tnum);
    }

    @Override
    public int chupdateProduct(Product p) {
        return sqlSession.update("chproduct.chupdateProduct",p);
    }

    @Override
    public int chupdateImage(BookImage b) {
        return sqlSession.update("chproduct.chupdateImage",b);
    }


}
