<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 페이징관련 변수 -->
<!-- 현재페이지번호 : 전달받은 값-->
<fmt:parseNumber var = "cp" value="${param.cp}"/>
<!-- 시작번호 1, 11, 21, 31 ... -->
<fmt:parseNumber var = "sp" value="${(cp-1)/10}" integerOnly="true"/>
<fmt:parseNumber var = "sp" value="${sp*10+1}"/>
<!-- 끝번호 10, 20, 30, 40 ...-->
<fmt:parseNumber var = "ep" value="${sp+9}"/>
<!-- 총페이지 -->
<fmt:parseNumber var = "tp" value="${pcnt/10}" integerOnly="true"/>
<c:if test="${(pcnt % 10) gt 0}">
    <fmt:parseNumber var = "tp" value="${tp+1}"/>
</c:if>

<%-- 페이지 링크 --%>
<c:set var="pglink" value="/product/plist?cp="/>

<%-- 페이지 링크2 - 검색 --%>
<c:if test ="${not empty param.findkey}">
    <c:set var="pglink" value="/product/find?findtype=${param.findtype}&findkey=${param.findkey}&cp="/>
</c:if>
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
        <!-- 검색바 -->
        <div id="searchArea">
            <select name="findtype" id="findtype">
                <option value="title">제목</option>
                <option value="author">작가</option>
                <option value="titauth">제목+작가</option>
                <option value="publish">출판사</option>
            </select>
            <input type="search" name="findkey" id="findkey" placeholder="분야내 검색">
                <button type="button" id="searchInbtn">
                    <i class="fa fa-search"></i>&nbsp;검색
                </button>
            <p>검색 결과 : ${pcnt} 개의 결과가 검색되었습니다. 총 페이지 수 : ${tp}</p>
        </div> <!-- 검색바 -->

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
<%--                <th>양</th>--%>
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
<%--                    <td>${p.amount}</td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <!-- 페이지 네비게이션 -->
        <div>
            <ul class="pagination justify-content-center">

                <%-- '이전'버튼이 작동되어야 할때는 sp가 11보다 클때 --%>
                <li class="page-item <c:if test="${sp lt 11}">disabled </c:if>"><a href="${pglink}${sp-10}" class="page-link text-dark border-dark">이전</a></li>

                <%-- 반복문을 이용해서 페이지 링크 생성 --%>
                <c:forEach var="i" begin="${sp}" end="${ep}" step="1">
                    <%-- 표시하는 페이지i가 총페이지수보다 작거나 같을 동안만 출력 --%>
                    <c:if test="${i le tp}">
                        <c:if test="${i eq cp}" >
                            <li class="page-item active"><a href="${pglink}${i}" class="page-link bg-dark border-dark">${i}</a></li>
                        </c:if>
                        <c:if test="${i ne cp}">
                            <li class="page-item"><a href="${pglink}${i}" class="page-link text-dark border-dark">${i}</a></li>
                        </c:if>
                    </c:if>
                </c:forEach>
                <%-- '다음'버튼 작동 --%>
                <li class="page-item <c:if test="${ep gt tp}">disabled</c:if>"><a href="${pglink}${sp+10}" class="page-link text-dark border-dark">다음</a></li>

            </ul>

        </div> <!-- 페이지 네비게이션 -->
    </div><!-- cside -->

    <!-- 우측 영역 -->
    <div class="rside">
        <p>우측 영역</p>
    </div><!-- rside -->

    </div><!--wrap-->
</div>
