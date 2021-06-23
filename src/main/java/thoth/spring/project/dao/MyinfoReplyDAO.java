package thoth.spring.project.dao;

import thoth.spring.project.vo.mReply;

import java.util.List;

public interface MyinfoReplyDAO {

    List<mReply> selectReply(String mino);

    int insertComment(mReply r);
    int insertReply(mReply r);

}
