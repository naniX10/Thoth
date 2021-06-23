package thoth.spring.project.service;

import thoth.spring.project.vo.mReply;

import java.util.List;

public interface MyinfoReplyService {

    List<mReply> readReply(String mino);
    boolean newComment(mReply r);
    boolean newReply(mReply r);
}
