package thoth.spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thoth.spring.project.dao.MyinfoDAO;
import thoth.spring.project.dao.MyinfoReplyDAO;
import thoth.spring.project.vo.mReply;

import java.util.List;

@Service("mrsrv")
public class MyinfoReplyServiceImpl implements MyinfoReplyService {


    @Autowired
    private MyinfoReplyDAO mrdao;


    @Override
    public List<mReply> readReply(String mino) {
        return mrdao.selectReply(mino);
    }

    @Override
    public boolean newComment(mReply r) {
        boolean isInserted = false;
        if (mrdao.insertComment(r) > 0 ) isInserted = true;
        return isInserted;
    }

    @Override
    public boolean newReply(mReply r) {
        boolean isInserted = false;
        if (mrdao.insertReply(r) > 0 ) isInserted = true;
        return isInserted;
    }

}
