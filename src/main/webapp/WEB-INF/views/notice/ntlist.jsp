<%@ page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:parseNumber var="cp" value="${param.cp}" />
<fmt:parseNumber var="sp" value="${(cp - 1) / 10}" integerOnly="true" />
<fmt:parseNumber var="sp" value="${sp * 10 + 1}" />
<fmt:parseNumber var="ep" value="${sp + 9}" />

<%-- 총게시물 수를 페이지당 게시물수로 나눔 : 총 페이지수 --%>
<fmt:parseNumber var="tp" value="${bdcnt / 10}" integerOnly="true" />
<c:if test="${(bdcnt % 10) > 0}">
    <fmt:parseNumber var="tp" value="${tp + 1}" />
</c:if>

<%-- 글번호 --%>
<fmt:parseNumber var="snum" value="${bdcnt - (cp - 1) * 10}" />

<div id = "main">

    <div>
        <ul>
            <li>공지사항</li>
        </ul>
    </div>

    <table>

        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회</th>
            </tr>
        </thead>

        <c:forEach var = "bd" items = "${bds}">
            <tr>
                <td>${snum}</td>
                <td><a href="/notice/ntview?bdno=${bd.bdno}">${bd.title}</a></td>
                <td>${bd.userid}</td>
                <td>${fn:substring(bd.regdate,0,10)}</td>
                <td>${bd.views}</td>
                <c:set var="snum" value="${snum - 1}" />
            </tr>
        </c:forEach>

    </table>

</div>