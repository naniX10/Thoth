package thoth.spring.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thoth.spring.project.dao.MyinfoDAO;
import thoth.spring.project.vo.Myinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("msrv")
public class MyinfoServiceImpl implements MyinfoService {

    @Autowired
    private MyinfoDAO mdao;

    @Override
    public boolean newQna(Myinfo m) {
        boolean isInserted = false;
        if (mdao.insertQna(m) > 0) isInserted = true;
        return isInserted;
    }


    @Override
    public int removeQna(String mino) {


        return mdao.deleteQna(mino);
    }

    @Override
    public List<Myinfo> readQna(String cp) {
        int snum = (Integer.parseInt(cp) - 1) * 20;
        return mdao.selectQna(snum);
    }

    @Override
    public List<Myinfo> readQna(String cp, String ftype, String fkey) {
        int snum = (20 * (Integer.parseInt(cp)-1));

        Map<String, Object> params = new HashMap<>();
        params.put("snum", snum);
        params.put("ftype", ftype);
        params.put("fkey", fkey);

        return mdao.findSelectQna(params);
    }

    @Override
    public Myinfo readOneQna(String mino) {
        return mdao.selectOneQna(mino);
    }

    @Override
    public int countQna() {
        return mdao.selectCountQna();
    }

    @Override
    public int countQna(String ftype, String fkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("ftype", ftype);
        params.put("fkey", fkey);

        return mdao.selectCountQna(params);
    }
}
