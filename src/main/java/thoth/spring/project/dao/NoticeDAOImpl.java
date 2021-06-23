package thoth.spring.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.Notice;

import java.util.List;

@Repository("ndao")
public class NoticeDAOImpl implements NoticeDAO{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<Notice> selectBoard(int snum) {
        return sqlSession.selectList("Notice.selectBoard", snum);
    }

    @Override
    public Notice selectOneBoard(String bdno) {
        return sqlSession.selectOne("Notice.selectOne", bdno);
    }

    @Override
    public int insertBoard(Notice bd) {
        return sqlSession.insert("Notice.insertBoard", bd);
    }

    @Override
    public int updateBoard(String bd) {
        return sqlSession.insert("Notice.updateBoard", bd);
    }

}
