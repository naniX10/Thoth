package thoth.spring.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.BookImage;
import thoth.spring.project.vo.Member;
import thoth.spring.project.vo.Order;
import thoth.spring.project.vo.Product;

import java.util.List;
import java.util.Map;

@Repository("mgdao")
public class ManagerDAOImpl implements ManagerDAO{

    @Autowired private SqlSession sqlSession;

    // 상품 조회 - snum부터 n개의 게시물 출력(현재는 10개로 설정)
    @Override
    public List<Member> selectMmember() {
        return sqlSession.selectList("manager.selectMmember");
    }
    public List<Order> selectMorder() {
        return sqlSession.selectList("manager.selectMorder");
    }



}
