package thoth.spring.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.Notice;

import java.util.List;
import java.util.Map;

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
    public int updateBoard(Notice bd) {
        return sqlSession.update("Notice.updateBoard", bd);
    }

    @Override
    public int deleteBoard(Notice bdno) {
        return sqlSession.delete("Notice.deleteBoard", bdno);
    }

    @Override
    public int viewCountBoard(String bdno) {
        return sqlSession.update("Notice.viewsBoard", bdno);
    }

    @Override
    public Notice nextBoard(String bdno) {
        return sqlSession.selectOne("Notice.nextBoard" , bdno);
    }

    @Override
    public Notice backBoard(String bdno) {
        return sqlSession.selectOne("Notice.backBoard" , bdno);
    }

    @Override
    public int selectCountBoard() {
        return sqlSession.selectOne("Notice.countBoard");}

    @Override
    public List<Notice> findSelectBoard(Map<String, Object> param) {

        return sqlSession.selectList("Notice.findSelect",param);
    }

    @Override
    public int selectCountBoard(Map<String, Object> param) {

        return sqlSession.selectOne("Notice.findSelectCount",param);
    }

    @Override
    public String selectPrvpno(String bdno) {
        return sqlSession.selectOne("Notice.selectPrev",bdno);
    }

    @Override
    public String selectNxtpno(String bdno) {
        return sqlSession.selectOne("Notice.selectNext",bdno);
    }


}
