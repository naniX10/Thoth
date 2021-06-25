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

<%-- 페이지 링크 : 검색 기능 x --%>
<c:set var="pglink" value="/notice/ntlist?cp=" />

<div id = "main">

    <div>
        <ul>
            <li>공지사항</li>
            <li><button type="button" id="gowrite" style="float: left">작성하기</button></li>
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

    <div>
        <div>
            <ul>
                <%-- '이전'버튼이 작동되어야 할때는 sp가 11보다 클때 --%>
                <li class="page-item <c:if test="${sp lt 11}">disabled</c:if>">
                    <a href="${pglink}${sp-10}" class="page-link">이전</a>
                </li>

                <%-- 반복문을 이용해서 페이지 링크 생성 --%>
                <c:forEach var="i" begin="${sp}" end="${ep}" step="1">
                    <%-- 표시하는 페이지i가 총페이지수보다 작거나 같을 동안만 출력 --%>
                    <c:if test="${i le tp}">
                        <c:if test="${i eq cp}">
                            <li class="page-item active">
                                <a href="${pglink}${i}" class="page-link">${i}</a>
                            </li>
                        </c:if>

                        <c:if test="${i ne cp}">
                            <li class="page-item">
                                <a href="${pglink}${i}" class="page-link">${i}</a>
                            </li>
                        </c:if>
                    </c:if>
                </c:forEach>

                <%-- '다음'버튼이 작동되어야 할때는 ??? --%>
                <li class="page-item <c:if test="${ep gt tp}">disabled</c:if>">
                    <a href="${pglink}${sp+10}" class="page-link">다음</a>
                </li>
            </ul>
        </div>
    </div><!-- 페이지네이션  -->

</div>