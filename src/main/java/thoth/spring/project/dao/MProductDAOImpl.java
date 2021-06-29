package thoth.spring.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

@Repository("pmdao")
public class MProductDAOImpl implements MProductDAO{

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
    public List<Product> mselectProduct(int snum) {
        return sqlSession.selectList("mproduct.mselectProduct",snum);
    }

    @Override
    public int mselectCountProduct() {
        return sqlSession.selectOne("mproduct.mcountProduct");
    }

    @Override
    public List<Product> mfindSelectProduct(Map<String, Object> params) {
        return sqlSession.selectList("mproduct.mfindSelect",params) ;
    }

    @Override
    public int mselectCountProduct(Map<String, Object> params) {
        return sqlSession.selectOne("mproduct.mfindSelectCount",params);
    }

    @Override
    public int minsertProduct(Product p, BookImage b) {
        int result = sqlSession.insert("mproduct.minsertProduct",p);
        sqlSession.insert("mproduct.insertImage",b);
        return result;
    }

    @Override
    public Product mselectOneProduct(String tnum) {
        return sqlSession.selectOne("mproduct.mselectOne",tnum);
    }

    @Override
    public BookImage mselectOneImage(String tnum) {
        return  sqlSession.selectOne("mproduct.mselectOneImage",tnum);
    }

    @Override
    public void mdeleteProduct(String tnum) {
        sqlSession.delete("mproduct.mdeleteProduct",tnum);
    }

    @Override
    public void mdeleteImage(String tnum) {
        sqlSession.delete("mproduct.mdeleteImage",tnum);
    }

    @Override
    public int mupdateProduct(Product p) {
        return sqlSession.update("mproduct.mupdateProduct",p);
    }

    @Override
    public int mupdateImage(BookImage b) {
        return sqlSession.update("mproduct.mupdateImage",b);
    }


}
