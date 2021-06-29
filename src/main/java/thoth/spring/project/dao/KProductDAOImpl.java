package thoth.spring.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

@Repository("pkdao")
public class KProductDAOImpl implements KProductDAO{

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
    public List<Product> kselectProduct(int snum) {
        return sqlSession.selectList("kproduct.kselectProduct",snum);
    }

    @Override
    public int kselectCountProduct() {
        return sqlSession.selectOne("kproduct.kcountProduct");
    }

    @Override
    public List<Product> kfindSelectProduct(Map<String, Object> params) {
        return sqlSession.selectList("kproduct.kfindSelect",params) ;
    }

    @Override
    public int kselectCountProduct(Map<String, Object> params) {
        return sqlSession.selectOne("kproduct.kfindSelectCount",params);
    }

    @Override
    public int kinsertProduct(Product p, BookImage b) {
        int result = sqlSession.insert("kproduct.kinsertProduct",p);
        sqlSession.insert("kproduct.insertImage",b);
        return result;
    }

    @Override
    public Product kselectOneProduct(String tnum) {
        return sqlSession.selectOne("kproduct.kselectOne",tnum);
    }

    @Override
    public BookImage kselectOneImage(String tnum) {
        return  sqlSession.selectOne("kproduct.kselectOneImage",tnum);
    }

    @Override
    public void kdeleteProduct(String tnum) {
        sqlSession.delete("kproduct.kdeleteProduct",tnum);
    }

    @Override
    public void kdeleteImage(String tnum) {
        sqlSession.delete("kproduct.kdeleteImage",tnum);
    }

    @Override
    public int kupdateProduct(Product p) {
        return sqlSession.update("kproduct.kupdateProduct",p);
    }

    @Override
    public int kupdateImage(BookImage b) {
        return sqlSession.update("kproduct.kupdateImage",b);
    }


}
