<%@ page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="main">
    <div>
        <i class="fas fa-comments fa-2x"> 자유 게시판 </i>
        <hr>
    </div><!-- 페이지 타이틀 -->

    <div>

        <div>
            <table>

                <tr>
                    <th>
                        <h2>${bd.title}</h2>
                    </th>
                </tr>

                <tr>
                    <td>${bd.userid}</td>
                    <td class="text-right">${bd.regdate} / ${bd.views}</td>
                </tr>

                <tr>
                    <td>
                        ${fn:replace(bd.contents, newChar, "<br>")}
                    </td>
                </tr>

            </table>
        </div>

        <div>
            <%-- 프론트엔드 분이 선택 or 다른것 사용해도 굳--%>
            <input type="button" value="back" onclick="history.back(-1)">
            <a href="javascript:history.back(-1)">목록으로</a>
        </div>

        <div>
            <a href="/notice/ntupdate?bdno=${bd.bdno}">수정</a>
            <button type="button" class="delete_btn">삭제</button>
        </div>

    </div><!-- 본문글 -->
</div>