package thoth.spring.project.service;


import thoth.spring.project.vo.Member;

import javax.servlet.http.HttpSession;

public interface MemberService {

    String newMember(Member m);
    String findZipcode(String dong);
    String checkUserid(String uid);
    boolean checkLogin(Member m, HttpSession sess);

    int countMember();
}