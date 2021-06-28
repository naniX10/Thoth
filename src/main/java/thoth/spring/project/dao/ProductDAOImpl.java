package thoth.spring.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("pdao")
public class ProductDAOImpl implements ProductDAO{

    @Autowired private SqlSession sqlSession;

    // 상품 조회 - snum부터 n개의 게시물 출력(현재는 10개로 설정)
    @Override
    public List<Product> selectProduct(int snum) {
        return sqlSession.selectList("product.selectProduct",snum);
    }

    // 상품 조회 - 전체 상품 수 구하기
    @Override
    public int selectCountProduct() {
        return sqlSession.selectOne("product.countProduct");
    }

    // 상품 조회 - 검색 기능
    @Override
    public List<Product> findSelectProduct(Map<String, Object> param) {
        return sqlSession.selectList("product.findSelect",param);
    }

    // 상품 조회 - 검색된 상품 수
    @Override
    public int selectCountProduct(Map<String, Object> param) {
        return sqlSession.selectOne("product.findSelectCount",param);
    }

    // 상품 상세 조회
    @Override
    public Product selectOneProduct(String tnum) {
        return sqlSession.selectOne("product.selectOne",tnum);
    }

    // 상품 등록
    @Override
    public int insertProduct(Product p, BookImage b){
            int result = sqlSession.insert("product.insertProduct",p);
            sqlSession.insert("product.insertImage",b);
        return result;
    }

    @Override
    public void deleteProduct(String tnum) {
        sqlSession.delete("product.deleteProduct",tnum);
    }

    // 상품 상세 조회 - 이미지
    @Override
    public BookImage selectOneImage(String tnum) {
        return  sqlSession.selectOne("product.selectOneImage",tnum);
    }

    // 상품 삭제 - 이미지
    @Override
    public void deleteImage(String tnum) {
        sqlSession.delete("product.deleteImage",tnum);
    }

    // 상품 수정
    @Override
    public int updateProduct(Product p) {
        return sqlSession.update("product.updateProduct",p);
    }

    // 상품 수정 - 이미지
    @Override
    public int updateImage(BookImage b) {
        return sqlSession.update("product.updateImage",b);
    }

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

    // 상품 조회2
    @Override
    public List<Product> selectProduct2(int snum) {
        return sqlSession.selectList("product.selectProduct2",snum);
    }

    // 상품 전체 개수2
    @Override
    public int selectCountProduct2() {
        return sqlSession.selectOne("product.countProduct2");
    }

    /* child */

    @Override
    public List<Product> select2Product(int snum) {
        return sqlSession.selectList("product.select2Product",snum);
    }

    @Override
    public int selectCount2Product() {
        return sqlSession.selectOne("product.count2Product");
    }

    @Override
    public List<Product> findSelect2Product(Map<String, Object> params) {
        return sqlSession.selectList("product.find2Select",params) ;
    }

    @Override
    public int selectCount2Product(Map<String, Object> params) {
        return sqlSession.selectOne("product.findSelect2Count",params);
    }

    @Override
    public Product selectOne2Product(String tnum) {
        return sqlSession.selectOne("product.select2One",tnum);
    }

    @Override
    public BookImage selectOne2Image(String tnum) {
        return  sqlSession.selectOne("product.select2OneImage",tnum);
    }

    @Override
    public int insert2Product(Product p, BookImage b) {
        int result = sqlSession.insert("product.insert2Product",p);
        sqlSession.insert("product.insertImage",b);
        return result;
    }


}
