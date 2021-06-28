package thoth.spring.project.dao;

import thoth.spring.project.vo.Notice;

import java.util.List;

public interface NoticeDAO {

    List<Notice> selectBoard(int snum);

    Notice selectOneBoard(String bdno);

    int insertBoard(Notice bd);

    int updateBoard(Notice bd);

    int deleteBoard(Notice bdno);

    int viewCountBoard(String bdno);

    Notice nextBoard(String bdno);

    Notice backBoard(String bdno);
}
