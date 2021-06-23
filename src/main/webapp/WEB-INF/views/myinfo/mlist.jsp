<%@ page pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:parseNumber var="cp" value="${param.cp}" />
<fmt:parseNumber var="sp" value="${ (cp - 1) / 10 }" integerOnly="true" />
<fmt:parseNumber var="sp" value="${ sp * 10 + 1 }" />
<fmt:parseNumber var="ep" value="${sp + 9}" />

<!-- 총게시물 수를 페이지당 게시물 수로 나눔 > 총 페이지수 -->
<fmt:parseNumber var="tp" value="${micnt / 20}" integerOnly="true" />
<c:if test="${(micnt % 20) > 0}">
    <fmt:parseNumber var="tp" value="${tp + 1}" />
</c:if>

<%-- 글번호 --%>
<fmt:parseNumber var="snum" value="${micnt -  (cp - 1) * 20}" />

<%--페이지 링크 : 검색기능 x--%>
<c:set var = "pglink" value="/myinfo/mlist?cp=" />

<%-- 검색 링크 : 검색기능 o --%>
<c:if test="${not empty param.findkey}">
    <c:set var = "pglink"
           value="/myinfo/find?findtype=${param.findtype}&findkey=${param.findkey}&cp=" />
</c:if>


<div class="container">

    <div id="main">
        <div class="row text-center">
        <div class="col-5">
            <button type="button" id="qnabtn" name="qnabtn" style="width: 50%;"> QnA</button>
        </div>
        <div class="col-5">
            <button type="button" id="myinfobtn" name="myinfobtn" style="width: 50%"> 내 정보 및 주문상품</button>
        </div>
        </div>

        <span>
        <div class="row">
            <div class="col-5 offset-1">
                <div class="form-group row">
                    <select class="form-control col-3 "
                            name="findtype" id="findtype">
                        <option value="title"> 제목</option>
                        <option value="contents">내용</option>
                        <option value="constit">제목+내용</option>
                        <option value="userid">작성자</option>
                    </select>&nbsp;
                    <input type="text" name="findkey" id="findkey"
                           class="form-control col-4 "
                           value="${param.findkey}" />&nbsp;
                    <button type="button" id="findbtn" >
                        <i ></i> 검색</button>
                </div>
            </div>

        </div>

        <div class="row">
            <div class="col-10 offset-1">
                <table class="table table-striped text-center table-hover">
                    <thead style="background: #dff0d8">
                    <tr>
                        <th style="width: 7%">번호</th>
                        <th> 제목</th>
                        <th style="width: 12%">작성자</th>
                        <th style="width: 12%">작성일</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="mi" items="${mis}">
                        <tr>
                            <td>${snum}</td>
                            <td><a href="/myinfo/mreply?mino=${mi.mino}">${mi.title}</a></td>
                            <td>${mi.userid}</td>
                            <td>${fn:substring(mi.regdate,0,10)}</td>
                            <c:set var="snum" value="${snum - 1}" />
                        </tr>
                    </c:forEach>


                    </tbody>
                </table>
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <ul class="pagination justify-content-center">

                    <!-- 이전 버튼이 작동되야 할때는 sp가 11보다 클때 -->
                    <li class="page-item <c:if test="${sp lt 11}"> disabled </c:if>" >
                        <a href="${pglink}${sp-10}" class="page-link">이전</a></li>

                    <!-- 반복문을 이용해서 페이지 링크 생성 -->
                    <c:forEach var="i" begin="${sp}" end="${ep}" step="1">
                        <!-- 표시하는 페이지 i 가 총 페이지 수 보다 작거나 같을 동안만 출력 -->
                        <c:if test="${i le tp}">
                            <c:if test="${i eq cp}">
                                <li class="page-item active">
                                    <a href="${pglink}${i}" class="page-link">${i}</a></li>
                            </c:if>

                            <c:if test="${i ne cp}">
                                <li class="page-item">
                                    <a href="${pglink}${i}" class="page-link">${i}</a></li>
                            </c:if>
                        </c:if>
                    </c:forEach>


                    <!-- 이전 버튼이 작동되야 할때는 sp가 11보다 작을때 -->
                    <li class="page-item <c:if test="${ep gt tp}"> disabled </c:if>">
                        <a href="${pglink}${sp+10}" class="page-link">다음</a></li>

                </ul>
            </div>
        </div>
            </span>
            <%--</c:if>--%>
        </div><!-- 페이지 네이션 -->


    </div>


</div>
