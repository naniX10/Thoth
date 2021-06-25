package thoth.spring.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.mReply;

import java.util.List;

@Repository("mrdao")
public class MyinfoReplyDAOImpl implements MyinfoReplyDAO{

    @Autowired
    private SqlSession sqlSession;


    @Override
    public List<mReply> selectReply(String mino) {
        return sqlSession.selectList("mireply.selectReply", mino);
    }

    @Override
    public int insertComment(mReply r) {
        r.setMino(selectLastRno());

        return sqlSession.insert("mireply.insertComment", r);
    }

    @Override
    public int insertReply(mReply r) {
        return sqlSession.insert("mireply.insertComment", r);
    }

    // 댓글 테이블에서 최근 댓글번호를 알아냄
    private String selectLastRno() {
        return sqlSession.selectOne("mireply.selectLastRno");
    }

}
