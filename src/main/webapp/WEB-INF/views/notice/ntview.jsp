<%@ page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel = "stylesheet" href = "/css/notice.css">

<div id="main">
    <form name = "viewfrm" id = "viewfrm">
        <input type="hidden" name="bdno" value="${bd.bdno}">
        <div>
            <i class="fas fa-comments fa-2x"> 자유 게시판 </i>
            <hr>
        </div><!-- 페이지 타이틀 -->

        <div style = "float : right">
            <a href="/notice/ntupdate?bdno=${bd.bdno}">수정</a>
            <button type="button" id="delete_btn">삭제</button>
        </div>

        <div>

            <div>
                <table style = "margin : 0px auto">

                    <tr>
                        <th style = "padding-left: 380px">
                            <h2 style="width : 300px">${bd.title}</h2>
                        </th>
                    </tr>

                    <tr>
                        <td style = "float : left"> 작성자 : ${bd.userid}</td>
                        <td class="text-right">작성일 : ${bd.regdate} / 조회수 : ${bd.views}</td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            ${fn:replace(bd.contents, newChar, "<br>")}
                        </td>
                    </tr>

                </table>
            </div>

            <div>
                <a href="/notice/ntlist" class="nav-link">목록으로</a>
            </div>

            <div>

                <c:if test="${nbd.bdno > 0}">
                    <li><a href = "/notice/ntview?bdno=${nbd.bdno}">다음글</a></li>
                </c:if>

                <c:if test="${bbd.bdno > 0}">
                    <li><a href = "/notice/ntview?bdno=${bbd.bdno}">이전글</a></li>
                </c:if>

            </div>

        </div><!-- 본문글 -->
    </form>
</div>