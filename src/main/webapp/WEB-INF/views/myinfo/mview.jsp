<%@ page pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="main">
    <div>
        <i > My info</i>
        <hr>
    </div>
    <div class="row">
        <div class="col-5 offset-1"></div>
        <div class="col-5 text-right">
            <button type="button" id="listmibtn">
                <i ></i>&nbsp; 목록으로</button>
        </div>
    </div>

    <div class="card card-body bg-light col-10 offset-1">
        <form id="miform" name="miform">

            <div class="form-group row">
                <label class="col-3 col-form-label text-right"
                       for="passwd">비밀번호</label>
                <input type="text" name="passwd" id="passwd"
                       class="form-control border-danger col-5"
                       value="${param.passwd}" >
            </div>



        </form>


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

</div>
