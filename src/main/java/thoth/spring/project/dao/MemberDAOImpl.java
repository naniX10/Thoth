package thoth.spring.project.dao;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.Member;
import thoth.spring.project.vo.Zipcode;

import java.util.List;

@Repository("mbdao")
public class MemberDAOImpl implements MemberDAO {

    @Autowired private SqlSession sqlSession;

    @Override
    public int insertMember(Member m) {
        return sqlSession.insert("member.insertMember", m);
    }

    @Override
    public List<Zipcode> selectZipcode(String dong) {
        return sqlSession.selectList("member.selectZipcode", dong);
    }

    @Override
    public int selectOneUserid(String uid) {
        return sqlSession.selectOne("member.checkUserid", uid);
    }

    @Override
    public int selectLogin(Member m) {
        return sqlSession.selectOne("member.checkLogin", m);
    }

    @Override
    public int selectCountOrder() {
        return sqlSession.selectOne("member.countMember");
    }
}