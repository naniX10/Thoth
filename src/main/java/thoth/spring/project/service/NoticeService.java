package thoth.spring.project.service;

import thoth.spring.project.vo.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> readBoard(String cp);

    Notice readOneBoard(String bdno);

    boolean newBoard(Notice bd);

    boolean updateBoard(Notice bd);

    boolean deleteBoard(Notice bdno);
}
