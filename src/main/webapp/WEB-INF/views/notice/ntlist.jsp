<%@ page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:parseNumber var="cp" value="${param.cp}" />
<fmt:parseNumber var="sp" value="${(cp - 1) / 10}" integerOnly="true" />
<fmt:parseNumber var="sp" value="${sp * 10 + 1}" />
<fmt:parseNumber var="ep" value="${sp + 9}" />

<%-- 총게시물 수를 페이지당 게시물수로 나눔 : 총 페이지수 --%>
<fmt:parseNumber var="tp" value="${ndcnt / 10}" integerOnly="true" />
<c:if test="${(ndcnt % 10) > 0}">
    <fmt:parseNumber var="tp" value="${tp + 1}" />
</c:if>

<%-- 글번호 --%>
<fmt:parseNumber var="snum" value="${ndcnt - (cp - 1) * 10}" />

<%-- 페이지 링크 : 검색 기능 x --%>
<c:set var="pglink" value="/notice/ntlist?cp=" />

<%-- 페이지 링크2 - 검색 --%>
<c:if test ="${not empty param.findkey}">
    <c:set var="pglink" value="/notice/find?findtype=${param.findtype}&findkey=${param.findkey}&cp="/>
</c:if>

<div id = "main" class="container">

    <div class="row">
        <div class="col">
            <p class="ntlistTitle">공지사항 ${ndcnt}/${tp}</p>
        </div>
    </div>

    <div class="row">
        <div class="col">
            <select name="findtype" id="findtype">
                <option value="title">제목</option>
                <option value="author">작성자</option>
                <option value="titcont">제목+내용</option>
                <option value="contents">내용</option>
            </select>
            <input type="search" name="findkey" id="findkey" placeholder="분야내 검색">
            <button type="button"  class="btn" id="searchNbtn">검색</button>
        </div>
        <div class="col">
            <button type="button" class="btn float-right" id="gowrite" style="">작성하기</button>
        </div>
    </div>

    <div class="row">
    <table class="col ntlistTable" style = "margin : 0px auto">
        <thead>
            <tr class="text-white" style="background-color:#BD83CE">
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>조회</th>
            </tr>
            <tr style="background-color:#F1C6E7">
                <th>-</th>
                <th>중요공지A</th>
                <th>관리자A</th>
                <th>2021-06-27</th>
                <th>32</th>
            </tr>
            <tr style="background-color:#F1C6E7">
                <th>-</th>
                <th>중요공지B</th>
                <th>관리자B</th>
                <th>2021-06-27</th>
                <th>35</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var = "bd" items = "${nds}">
            <tr>
                <td>${bd.bdno}</td><%--${snum}--%>
                <td><a href="/notice/ntview?bdno=${bd.bdno}">${bd.title}</a></td>
                <td>${bd.userid}</td>
                <td>${fn:substring(bd.regdate,0,10)}</td>
                <td>${bd.views}</td>
                <c:set var="snum" value="${snum - 1}" />
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </div>
    <div class="row">
        <div class="col listAPaging" >
        <ul class="pagination justify-content-center">
            <%-- '이전'버튼이 작동되어야 할때는 sp가 11보다 클때 --%>
            <li class="page-item <c:if test="${sp lt 11}">disabled</c:if>">
                <a href="${pglink}${sp-10}" class="page-link pagingStyleA text-dark border-dark">이전</a>
            </li>

                <%-- 반복문을 이용해서 페이지 링크 생성 --%>
                <c:forEach var="i" begin="${sp}" end="${ep}" step="1">
                    <%-- 표시하는 페이지i가 총페이지수보다 작거나 같을 동안만 출력 --%>
                    <c:if test="${i le tp}">
                        <c:if test="${i eq cp}">
                            <li class="page-item active">
                                <a href="${pglink}${i}" class="page-link bg-dark border-dark">${i}</a>
                            </li>
                        </c:if>

                        <c:if test="${i ne cp}">
                            <li class="page-item">
                                <a href="${pglink}${i}" class="page-link text-dark border-dark">${i}</a>
                            </li>
                        </c:if>
                    </c:if>
                </c:forEach>

                <%-- '다음'버튼이 작동되어야 할때는 ??? --%>
                <li class="page-item <c:if test="${ep gt tp}">disabled</c:if>">
                    <a href="${pglink}${sp+10}" class="page-link pagingStyleA text-dark border-dark">다음</a>
                </li>
            </ul>
    </div><!-- 페이지네이션  -->
</div>
</div>