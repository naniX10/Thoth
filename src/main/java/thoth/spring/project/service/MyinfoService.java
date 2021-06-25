package thoth.spring.project.service;

import thoth.spring.project.vo.Myinfo;

import java.util.List;

public interface MyinfoService {

    boolean newQna(Myinfo m);
    int removeQna(String mino);

    List<Myinfo> readQna(String cp);
    List<Myinfo> readQna(String cp, String ftype, String fkey);
    Myinfo readOneQna(String mino);

    int countQna();
    int countQna(String ftype, String fkey);


}
