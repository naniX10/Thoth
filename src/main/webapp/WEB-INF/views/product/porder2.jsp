<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="fnameMain" value="${fn:split(b.fnames,'/')[0]}"/>
<c:set var="fsizeMain" value="${fn:split(b.fsizes,'/')[0]}"/>
<c:set var="fnames" value="${fn:split(b.fsizes,'/')}"/>
<c:set var="fsizes" value="${fn:split(b.fsizes,'/')}"/>
<c:set var="baseURL" value="http://localhost/book/"/>

<c:set var="salePrice" value="${p.origin_price - p.sale_price}"/>
<c:set var="salePercent" value="${(salePrice/p.origin_price)*100}"/>



<div id="main" class="container">
    <!-- Page Title -->
    <div class="row">
        <div class="col">
            <p class="porderTitle">주문하기</p>
        </div>
    </div>
    <!-- 책 정보 관련 내용 -->
    <div class="row viewWrap2">
        <!-- 책 이미지 -->
        <div class="col-3 viewPImage">
            <!-- 기존글 이미지  -->
            <c:if test="${not empty p.image}">
                <td><img src="${p.image}" alt="도서이미지" width="200px"></img></td>
            </c:if>
            <!-- 새글쓰기로 추가한 이미지 -->
            <c:if test="${empty p.image}">
                <c:set var="f" value="${fnameMain}"/>
                <c:if test="${f ne '-'}">
                    <c:set var="pos" value="${fn:indexOf(f,'.')}"/>
                    <c:set var="fname" value="${fn:substring(f,0,pos)}"/>
                    <c:set var="fext" value="${fn:substring(f,pos+1,fn:length(f))}"/>
                    <td><img src="${baseURL}${fname}${b.uuid}.${fext}" alt="도서이미지2" width="200px"></img></td>
                </c:if>
            </c:if>
        </div><!-- 책 이미지 -->
        <!-- 책 정보 -->
        <div class="col-9">
            <div class="container">
                <!-- 책 제목 -->
                <div class="row">
                    <div class="col">
                        <p id="pviewText1">${p.title}</p>
                    </div>
                    <div class="col">
                        <button type="button" class="listPbtn float-right" id="listPbtn">목록보기</button>

                    </div>
                </div>
                <!-- 지은이, 출판사 -->
                <div class="row">
                    <div class="col">
                    <p id="pviewText2">${p.author} 지음 | ${p.publish}</p>
                    <hr class="pviewhr">
                    </div>
                </div>

                <!-- 정가, 판매가 -->
                <div class="row">
                    <div class="col">
                    <p id="pviewText3">정가 : ${p.origin_price}원</p>
                    </div>
                </div>
                <!-- 판매가 -->
                <div class="row">
                    <div class="col">
                    <p id="pviewText4">판매가 : <font color="red" size="5">${p.sale_price}</font>원
                        <span class="badge alert-danger">Now</span>
                        <font color="#916DD5">${fn:substring(salePercent,0,2)}%↓ ${salePrice}원 할인</font></p>
                    <hr class="pviewhr">
                    </div>
                </div>
                <!-- 배송비, 배송일정 -->
                <div class="row">
                    <div class="col">
                    <p id="pviewText5">배송비 : 무료</p>
                    </div>
                </div>
                <!-- 배송일정 -->
                <div class="row">
                    <div class="col">
                    <p id="pviewText6">배송일정 : 주문날짜로부터 3일 이내</p>
                    <hr class="pviewhr">
                    </div>
                </div>
                <!-- 주문 수량 -->
                <div class="row">
                    <div class="col">
                    주문수량 : &nbsp;<input type="number" min="1" max="1000">
                    </div>
                </div>
            </div>
        </div><!-- 책 정보 -->
    </div><!-- 책 정보 관련 내용 -->

    <!-- 구매 폼-->
    <div class="row">
        <div class="col">
            <p class="porderTitle2">구매정보입력</p>
        </div>
    </div>
    <form id="buyprdfrm2" class="buyprdfrm2">
        <div class="col-10 offset-2">
            <div class="form-group row prdfrmA">
                <label for="userid" class="col-2 text-right">회원아이디</label>
                <input type="text" name="userid" id="userid" class="col-8" value="${UID}" readonly>
            </div>
            <div class="form-group row prdfrmC">
                <label for="tnum" class="col-2 text-right">상품번호</label>
                <input type="text" name="tnum" id="tnum"class="col-8"  value="${p.tnum}" readonly>
            </div>
            <div class="form-group row prdfrmD">
                <label for="price" class="col-2 text-right">가격</label>
                <input type="text" name="price" id="price" class="col-8" value="${p.sale_price}" readonly>
            </div>
            <div class="form-group row prdfrmE">
                <label for="qty" class="col-2 text-right">주문량</label>
                <input type="text" name="qty" id="qty" class="col-8" value="">
            </div>
            <div class="form-group row prdfrmE">
                <label for="address" class="col-2 text-right">주소</label>
                <input type="text" name="address" id="address" class="col-8">
            </div>
            <div class="form-group row prdfrmE">
                <label for="regdate" class="col-2 text-right">주문날짜</label>
                <input type="text" name="regdate" id="regdate" class="col-8" disabled value="2021-06-28">
            </div>
            <hr>
            <div class="form-group row prdfrmI">
                <label class="col-2 text-right">자동입력방지</label>
                <div class="g-recaptcha" data-sitekey="6LfaIwgbAAAAAEVrujfQ72ArOe5Ru4YCjVW1GBSl"></div>
                <input type="hidden" id="g-recaptcha" name="g-recaptcha" />
            </div>
        </div>

        <!-- 버튼들 -->
        <div class="form-group row prdfrmJ">
            <div class="col offset-5">
                <button type="button" id="order3Pbtn">주문완료</button>
                <button type="reset" id="re3Pbtn">다시입력</button>
            </div>
        </div>
    </form>

</div>
