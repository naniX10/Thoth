package thoth.spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thoth.spring.project.dao.NoticeDAO;
import thoth.spring.project.vo.Notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public boolean updateBoard(Notice bd) {
        boolean isUpdateed = false;
        if (ndao.updateBoard(bd) > 0) isUpdateed = true;
        return isUpdateed;
    }

    @Override
    public boolean deleteBoard(Notice bdno) {
        boolean isDeleteed = false;
        if (ndao.deleteBoard(bdno) > 0) isDeleteed = true;
        return isDeleteed;
    }

    @Override
    public boolean viewCountBoard(String bdno) {
        boolean isUpdated = false;
        if (ndao.viewCountBoard(bdno) > 0) isUpdated = true;
        return isUpdated;
    }

    @Override
    public Notice nextBoard(String bdno) {
        return ndao.nextBoard(bdno);
    }

    @Override
    public Notice backBoard(String bdno) {
        return ndao.backBoard(bdno);
    }

    @Override
    public int countBoard() {
        return ndao.selectCountBoard();
    }

    @Override
    public List<Notice> readBoard(String cp, String ftype, String fkey) {
        int snum = 30*(Integer.parseInt(cp)-1);
        Map<String, Object> params = new HashMap<>();
        params.put("snum",snum);
        params.put("ftype",ftype);
        params.put("fkey",fkey);
        return ndao.findSelectBoard(params);
    }

    @Override
    public int countBoard(String ftype, String fkey) {
        Map<String,Object> params = new HashMap<>();
        params.put("ftype", ftype);
        params.put("fkey", fkey);
        return ndao.selectCountBoard(params);
    }

    @Override
    public String readPrevpno(String bdno) {
        return ndao.selectPrvpno(bdno);
    }

    @Override
    public String readNxtpno(String bdno) {
        return ndao.selectNxtpno(bdno);
    }
}
