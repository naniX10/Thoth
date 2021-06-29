package thoth.spring.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

@Repository("pldao")
public class LProductDAOImpl implements LProductDAO{

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
    public List<Product> lselectProduct(int snum) {
        return sqlSession.selectList("lproduct.lselectProduct",snum);
    }

    @Override
    public int lselectCountProduct() {
        return sqlSession.selectOne("lproduct.lcountProduct");
    }

    @Override
    public List<Product> lfindSelectProduct(Map<String, Object> params) {
        return sqlSession.selectList("lproduct.lfindSelect",params) ;
    }

    @Override
    public int lselectCountProduct(Map<String, Object> params) {
        return sqlSession.selectOne("lproduct.lfindSelectCount",params);
    }

    @Override
    public int linsertProduct(Product p, BookImage b) {
        int result = sqlSession.insert("lproduct.linsertProduct",p);
        sqlSession.insert("lproduct.insertImage",b);
        return result;
    }

    @Override
    public Product lselectOneProduct(String tnum) {
        return sqlSession.selectOne("lproduct.lselectOne",tnum);
    }

    @Override
    public BookImage lselectOneImage(String tnum) {
        return  sqlSession.selectOne("lproduct.lselectOneImage",tnum);
    }

    @Override
    public void ldeleteProduct(String tnum) {
        sqlSession.delete("lproduct.ldeleteProduct",tnum);
    }

    @Override
    public void ldeleteImage(String tnum) {
        sqlSession.delete("lproduct.ldeleteImage",tnum);
    }

    @Override
    public int lupdateProduct(Product p) {
        return sqlSession.update("lproduct.lupdateProduct",p);
    }

    @Override
    public int lupdateImage(BookImage b) {
        return sqlSession.update("lproduct.lupdateImage",b);
    }


}
