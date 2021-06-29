<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="main">

    <!-- Page Title -->
    <div class="row">
        <div class="col">
            <p class="joinTitle">관리자페이지</p>
        </div>
        <hr>
    </div><!-- 페이지 타이틀 -->

    <!-- 섹션 타이틀 -->
    <div class="row sectionTitle">
        <div class="col">
            <h2 style="font-weight:bold">회원정보</h2>
            <small class="text-muted">
                현재 가입되어 있는 상품에 대한 내역입니다.
            </small>
            <hr>
        </div>
    </div><!-- 섹션 타이틀 -->

    <div class="card card-body agreeCard">
        <h3 style="margin-bottom:15px;">총 회원 수 : ${mcnt}명</h3>
        <table class="mglistTable">
            <thead>
                <tr class="text-white" style="background-color:#BD83CE">
                    <th>번호</th>
                    <th>이름</th>
                    <th>아이디</th>
                    <th>주민등록번호</th>
                    <th>우편번호</th>
                    <th>주소</th>
                    <th>이메일</th>
                    <th>전화번호</th>
                    <th>가입날짜</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="mjM" items="${mps}">
                    <tr>
                        <td>${mjM.mno}</td>
                        <td>${mjM.name}</td>
                        <td>${mjM.userid}</td>
                        <td>${mjM.passwd}</td>
                        <td>${mjM.jumin}</td>
                        <td>${mjM.zipcode}</td>
                        <td>${mjM.addr1}&nbsp;${mjM.addr2}</td>
                        <td>${mjM.email}</td>
                        <td>${mjM.regdate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- 섹션 타이틀 -->
    <div class="row sectionTitle">
        <div class="col">
            <h2 style="font-weight:bold">상품정보</h2>
            <small class="text-muted">
                현재 등록되어 있는 상품에 대한 내역입니다.
            </small>
            <hr>
        </div>
    </div><!-- 섹션 타이틀 -->


    <div class="card card-body agreeCard">
        <h3 style="margin-bottom:15px;">종합 : ${pcnt}권</h3>
        <table class="mglistTable">
            <thead>
                <tr class="text-white" style="background-color:#BD83CE">
                    <th>카테고리</th>
                    <th>보유현황</th>
                    <th>카테고리</th>
                    <th>보유현황</th>
                    <th>카테고리</th>
                    <th>보유현황</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>소설</td>
                    <td>???</td>
                    <td>만화</td>
                    <td>???</td>
                    <td>어린이</td>
                    <td>???</td>
                </tr>
                <tr>
                    <td>에세이</td>
                    <td>???</td>
                    <td>요리/와인</td>
                    <td>???</td>
                    <td>유아</td>
                    <td>???</td>
                </tr>
                <tr>
                    <td>시</td>
                    <td>???</td>
                    <td>역사/문화</td>
                    <td>???</td>
                    <td>청소년</td>
                    <td>0</td>
                </tr>
                <tr>
                    <td>인문</td>
                    <td>???</td>
                    <td>자기계발</td>
                    <td>???</td>
                    <td>아동만화</td>
                    <td>???</td>
                </tr>
                <tr>
                    <td>정치사회</td>
                    <td>???</td>
                    <td>여행</td>
                    <td>???</td>
                    <td>기술/컴퓨터</td>
                    <td>???</td>
                </tr>
            </tbody>
        </table>
    </div>

    <!-- 섹션 타이틀 -->
    <div class="row sectionTitle">
        <div class="col">
            <h2 style="font-weight:bold">주문정보</h2>
            <small class="text-muted">
                현재 회원들의 주문 내역입니다.
            </small>
            <hr>
        </div>
    </div><!-- 섹션 타이틀 -->

    <div class="card card-body agreeCard">
        <h3 style="margin-bottom:15px;">총 주문 수 :${ocnt}개 </h3>
        <table  class="mglistTable">
            <thead >
            <tr class="text-white" style="background-color:#BD83CE">
                <th>주문번호</th>
                <th>아이디</th>
                <th>상품번호</th>
                <th>판매가</th>
                <th>양</th>
                <th>주소</th>
                <th>주문날짜</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="mto" items="${tps}">
                <tr>
                    <td>${mto.ordnum}</td>
                    <td>${mto.userid}</td>
                    <td>${mto.tnum}</td>
                    <td>${mto.price}</td>
                    <td>${mto.qty}</td>
                    <td>${mto.address}</td>
                    <td>${mto.regdate}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <br>
    <br>
</div>