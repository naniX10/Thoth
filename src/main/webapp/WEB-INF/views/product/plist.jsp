<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="main">
    <div id="wrap">
    <!-- 좌측 영역 -->
    <div class="lside">
        <p>카테고리별</p>
        <ul>
            <li>종합</li>
            <li>소설</li>
            <li>에세이</li>
            <li>시</li>
            <li>인문</li>
            <li>정치사회</li>
            <li>경제경영</li>
            <li>건강</li>
            <li>교양과학</li>
            <li>외국어</li>
            <li>예술</li>
            <li>취미/스포츠</li>
            <li>TOEIC/TOEFL</li>
            <li>종교</li>
            <li>만화</li>
            <li>요리/와인</li>
            <li>역사/문화</li>
            <li>자기계발</li>
            <li>여행</li>
            <li>기술/컴퓨터</li>
        </ul>
        <p>아동코너</p>
        <ul>
            <li>유아</li>
            <li>어린이</li>
            <li>청소년</li>
            <li>아동만화</li>
        </ul>
    </div><!-- lside -->

    <!-- 중앙 영역 -->
    <div class="cside">
        <table class="table table-striped text-center table-hover">
            <thead style="background: #dff0d8">
            <tr>
<%--                <th>기호</th>--%>
                <th>제목</th>
                <th>작가</th>
                <th>출판사</th>
                <th>이미지</th>
                <th>정가</th>
                <th>판매가</th>
                <th>양</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="p" items="${pds}">
                <tr>
<%--                    <td>${p.tnum}</td>--%>
                    <td>${p.title}</td>
                    <td>${p.author}</td>
                    <td>${p.publish}</td>
                    <td><img src="${p.image}" alt="도서이미지" width="100px"></img></td>
                    <td>${p.origin_price}</td>
                    <td>${p.sale_price}</td>
                    <td>${p.amount}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div><!-- cside -->

    <!-- 우측 영역 -->
    <div class="rside">
        <p>우측 영역</p>
    </div><!-- rside -->

    </div><!--wrap-->
</div>
