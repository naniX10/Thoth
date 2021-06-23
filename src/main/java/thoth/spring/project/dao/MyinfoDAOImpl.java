package thoth.spring.project.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import thoth.spring.project.vo.Myinfo;

import java.util.List;
import java.util.Map;

@Repository("mdao")
public class MyinfoDAOImpl implements MyinfoDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public int insertQna(Myinfo m) {
        return sqlSession.insert("insertQna", m);
    }


    @Override
    public int deleteQna(String mino) {
        return sqlSession.delete("myinfo.deleteQna", mino);
    }

    @Override
    public List<Myinfo> selectQna(int snum) {
        return sqlSession.selectList("myinfo.selectQna", snum);
    }

    @Override
    public List<Myinfo> findSelectQna(Map<String, Object> param) {
        return sqlSession.selectList("myinfo.findSelect", param);
    }

    @Override
    public Myinfo selectOneQna(String mino) {
        return sqlSession.selectOne("myinfo.selectOne", mino);
    }

    @Override
    public int selectCountQna() {
        return sqlSession.selectOne("myinfo.countQna");
    }

    @Override
    public int selectCountQna(Map<String, Object> param) {
        return sqlSession.selectOne("myinfo.findSelectCount", param);
    }


    /*@Override
    public int selectMyinfo(String mino) {
        return sqlSession.selectOne("myinfo.selectMyinfo", mino);
    }

    @Override
    public int updateMyinfo() {
        return 0;
    }

    @Override
    public int deleteMyinfo() {
        return 0;
    }*/
}
