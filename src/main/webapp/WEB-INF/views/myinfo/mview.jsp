<%@ page pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:parseNumber var="cp" value="${param.mcp}" />
<fmt:parseNumber var="sp" value="${ (cp - 1) / 10 }" integerOnly="true" />
<fmt:parseNumber var="sp" value="${ sp * 10 + 1 }" />
<fmt:parseNumber var="ep" value="${sp + 9}" />

<!-- 총게시물 수를 페이지당 게시물 수로 나눔  총 페이지수 -->
<fmt:parseNumber var="tp" value="${micnt / 5}" integerOnly="true" />
<c:if test="${(micnt % 5) > 0}">
    <fmt:parseNumber var="tp" value="${tp + 1}" />
</c:if>

<%-- 글번호 --%>
<fmt:parseNumber var="snum" value="${micnt -  (cp - 1) * 5}" />

<%--페이지 링크 : 검색기능 x--%>
<c:set var = "pglink" value="/myinfo/mlist?mcp=" />

<c:if test="${empty UID}">
    <script>alert('로그인하세요!');
    location.href='/myinfo/mlist';</script>
</c:if>


<div id="main" class="container">

    <div class="row">
        <div class="col-5 offset-1"></div>
        <div class="col-5 text-right">
            <button type="button" id="listmibtn">목록으로</button>
        </div>
    </div>

    <div class="row">
        <div class="col-5 offset-1">
            <h3>내 정보 수정</h3></div>
    </div>
    <div class="card card-body bg-white col-10 offset-1">
        <form id="miform" name="miform">

            <div class="form-group row">
                <label class="col-3 col-form-label text-right"
                       for="myid">아이디</label>
                <input type="text" name="myid" id="myid"
                       class="form-control col-5" readonly value="${UID}">
            </div>

            <div class="form-group row">
                <label class="col-3 col-form-label text-right"
                       for="mipasswd">비밀번호</label>
                <input type="password" name="mipasswd" id="mipasswd"
                       class="form-control col-5" value="${member.passwd}">
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-right"
                       for="remipasswd">비밀번호 확인</label>
                <input type="password" name="remipasswd" id="remipasswd"
                       class="form-control col-5" value="${member.passwd}">
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-right" for="mitel1">전화번호</label>
                <select class="form-control col-2"
                        name="mitel1" id="mitel1">
                    <option>-국번-</option>
                    <option>010</option>
                    <option>011</option>
                </select>
                <span class="col-form-label">&nbsp;&mdash;&nbsp;</span>
                <input type="text" name="mitel2" id="mitel2"
                       class="form-control col-2" maxlength="4" value="${member.phone}">
                <span class="col-form-label">&nbsp;&mdash;&nbsp;</span>
                <input type="text" name="mitel3" id="mitel3"
                       class="form-control col-2" maxlength="4">
            </div><!-- 전화번호 -->
            <div class="form-group row">
                <label class="col-3 col-form-label text-right"
                       for="miemail1">이메일 주소</label>
                <input type="text" name="miemail1" id="miemail1"
                       class="form-control col-3" value="${(member.email)}">

                <div class="input-group-prepend">
                    <span class="input-group-text">@</span>
                </div>
                <input type="text" name="miemail2" id="miemail2"
                       class="form-control border-dark col-2" readonly>
                &nbsp;
                <select class="form-control col-2" id="miemail3">
                    <option>-선택하세요-</option>
                    <option>직접입력하기</option>
                    <option>naver.com</option>
                    <option>gmail.com</option>
                    <option>hotmail.com</option>
                </select>
            </div>

            <div class="col-4"></div>
            <div class="col-4"></div>
            <div class="col-4 offset-4">
                <button type="button" id="updateinfobtn">회원정보 수정</button>
            </div>

            </form>

        </div>


    </div>
    <br>
    <div class="row">
        <div class="col-5 offset-1">
            <h3><i > 내 주문</i></h3></div>
    </div>
    <div class="card card-body bg-light col-10 offset-1">
        <form id="moform" name="moform">
            <table class="table table-striped text-center table-hover">
                <thead style="background: #dff0d8">
                <tr>
                    <th style="width: 7%">주문날짜</th>
                    <th>제품명</th>
                    <th style="width: 15%">상태</th>
                    <th style="width: 15%">취소/확인</th>
                </tr>
                </thead>
                <tbody>
                <tr class="text-danger">
                    <th>2021/06/18</th>
                    <th>한권으로 끝내는 FFF</th>
                    <th>배송중<br>배송조회</th>
                    <th>[반품하기]<br> [수취확인]</th>

                </tr>
                <c:forEach var="mo" items="${mos}">
                    <tr>
                        <td>${fn:substring(mi.ordate,0,10)}</td>
                        <td><a href="/myinfo/mview?mino=${mi.mino}">${mi.contents}</a></td>
                        <td>${mi.userid}</td>
                        <c:set var="snum" value="${snum - 1}" />
                    </tr>
                </c:forEach>


                </tbody>
            </table>

        </form>
    </div>
    <br>
    <div class="row">
        <div class="col-5 offset-1">
            <h3><i > 내 QnA</i></h3></div>
    </div>
    <div class="card card-body bg-light col-10 offset-1">
        <form id="mqform" name="mqform">
            <table class="table table-striped text-center table-hover">
                <thead style="background: #dff0d8">
                <tr>
                    <th>제목</th>
                    <th style="width: 15%">작성자</th>
                    <th style="width: 15%">작성일</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="mmi" items="${mmis}">
                    <tr>
                        <td><a href="/myinfo/mview?mino=${mmi.mino}">${mmi.contents}</a></td>
                        <td>${mmi.userid}</td>
                        <td>${fn:substring(mmi.regdate,0,10)}</td>
                        <c:set var="snum" value="${snum - 1}" />
                    </tr>
                </c:forEach>


                </tbody>
            </table>

        </form>
    </div>

<br>