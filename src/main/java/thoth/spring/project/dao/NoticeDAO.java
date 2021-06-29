package thoth.spring.project.dao;

import thoth.spring.project.vo.Notice;

import java.util.List;
import java.util.Map;

public interface NoticeDAO {

    List<Notice> selectBoard(int snum);

    Notice selectOneBoard(String bdno);

    int insertBoard(Notice bd);

    int updateBoard(Notice bd);

    int deleteBoard(Notice bdno);

    int viewCountBoard(String bdno);

    Notice nextBoard(String bdno);

    Notice backBoard(String bdno);

    int selectCountBoard();

    List<Notice> findSelectBoard(Map<String, Object> param);
    int selectCountBoard(Map<String, Object> param);

    String selectPrvpno(String bdno);

    String selectNxtpno(String bdno);
}
