package thoth.spring.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Order;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

@Repository("odao")
public class OrderDAOImpl implements OrderDAO{

    @Autowired private SqlSession sqlSession;

    // 상품 등록
    @Override
    public int insertOrder(Order o){
            int result = sqlSession.insert("order.insertOrder",o);
        return result;
    }

    @Override
    public Order selectOneOrder(String tnum) {
        return sqlSession.selectOne("order.selectOne",tnum);
    }

    @Override
    public int selectCountOrder() {
        return sqlSession.selectOne("order.countOrder");
    }

}
