package thoth.spring.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

@Repository("pbadao")
public class BaProductDAOImpl implements BaProductDAO{

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
    public List<Product> baselectProduct(int snum) {
        return sqlSession.selectList("baproduct.baselectProduct",snum);
    }

    @Override
    public int baselectCountProduct() {
        return sqlSession.selectOne("baproduct.bacountProduct");
    }

    @Override
    public List<Product> bafindSelectProduct(Map<String, Object> params) {
        return sqlSession.selectList("baproduct.bafindSelect",params) ;
    }

    @Override
    public int baselectCountProduct(Map<String, Object> params) {
        return sqlSession.selectOne("baproduct.bafindSelectCount",params);
    }

    @Override
    public int bainsertProduct(Product p, BookImage b) {
        int result = sqlSession.insert("baproduct.bainsertProduct",p);
        sqlSession.insert("baproduct.insertImage",b);
        return result;
    }

    @Override
    public Product baselectOneProduct(String tnum) {
        return sqlSession.selectOne("baproduct.baselectOne",tnum);
    }

    @Override
    public BookImage baselectOneImage(String tnum) {
        return  sqlSession.selectOne("baproduct.baselectOneImage",tnum);
    }

    @Override
    public void badeleteProduct(String tnum) {
        sqlSession.delete("baproduct.badeleteProduct",tnum);
    }

    @Override
    public void badeleteImage(String tnum) {
        sqlSession.delete("baproduct.badeleImage",tnum);
    }

    @Override
    public int baupdateProduct(Product p) {
        return sqlSession.update("baproduct.baupdateProduct",p);
    }

    @Override
    public int baupdateImage(BookImage b) {
        return sqlSession.update("baproduct.baupdateImage",b);
    }


}
