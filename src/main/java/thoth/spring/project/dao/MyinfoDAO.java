package thoth.spring.project.dao;

import thoth.spring.project.vo.Member;
import thoth.spring.project.vo.Myinfo;

import java.util.List;
import java.util.Map;

public interface MyinfoDAO {

    int insertQna(Myinfo m);
    int updateQna(Myinfo m);
    int deleteQna(String mino);

    List<Myinfo> selectQna(int snum);
    List<Myinfo> findSelectQna(Map<String, Object> param);
    Myinfo selectOneQna(String mino);

    int selectCountQna();
    int selectCountQna(Map<String, Object> param);

    int updatemyinfo(Member member);

    Member selectOneMember(String userid);

    List<Myinfo> selectMyQna(int msnum);


}
