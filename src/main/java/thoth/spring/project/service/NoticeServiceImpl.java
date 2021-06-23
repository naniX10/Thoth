package thoth.spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thoth.spring.project.dao.NoticeDAO;
import thoth.spring.project.vo.Notice;

import java.util.List;

@Service("nsrv")
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private NoticeDAO ndao;

    @Override
    public List<Notice> readBoard(String cp) {
        int snum = (Integer.parseInt(cp) - 1) * 10;
        return ndao.selectBoard(snum);
    }

    @Override
    public Notice readOneBoard(String bdno) {
        return ndao.selectOneBoard(bdno);
    }

    @Override
    public boolean newBoard(Notice bd) {
        boolean isInserted = false;
        if (ndao.insertBoard(bd) > 0) isInserted = true;
        return isInserted;
    }

    @Override
    public int updateBoard(String bd) {
         return ndao.updateBoard(bd);
    }

}
