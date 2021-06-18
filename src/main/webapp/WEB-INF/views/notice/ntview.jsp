<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%-- 줄바꿈 기호를 변수로 생성 : br태그 변환 필요! --%>
<c:set var="newChar" value="
" scope="application" />

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

            <c:if test="${not empty UID}">
                <li><button type="button" id="nUpdate" style="float: left">수정하기</button></li>
            </c:if>

            <c:if test="${not empty UID}">
                <li><button type="button" id="nDelete" style="float: left">삭제하기</button></li>
            </c:if>

        </div>

    </div><!-- 본문글 -->

</div>