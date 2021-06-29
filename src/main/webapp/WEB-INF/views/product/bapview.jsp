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

<a name="top"></a>
<div class="wrapPlist"></div>
<div id="main" class="container">

    <!-- 상품수정/삭제를 위해 넘겨주는 값 -->
    <input type="hidden" id="tnum" value="${param.tnum}"/>

    <!-- 책 정보 관련 내용 -->
    <div class="row viewWrap">
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
                        <button type="button" class="listPbtn float-right" id="balistPbtn">목록보기</button>
                        <span class="float-right">&nbsp;</span>
                        <button type="button" class="delPbtn float-right" id="badelPbtn">상품삭제</button>
                        <span class="float-right">&nbsp;</span>
                        <button type="button" class="modPbtn float-right" id="bamodPbtn">상품수정</button>
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
                <!-- 버튼들 -->
                <div class="row">
                    <div class="col">
                        <button type="button" class="btn buy2Pbtn float-right" id="buy2Pbtn">바로구매</button>
                        <span class="float-right">&nbsp;</span>
                        <button type="button" class="btn buy1Pbtn float-right" id="buy1Pbtn">장바구니</button>

                    </div>
                </div>
            </div>
        </div><!-- 책 정보 -->
    </div><!-- 책 정보 관련 내용 -->


    <div class="quick_menu">
        <div class="quick_top"><a href="#top"><i class="fa fa-arrow-up fa-2x"></i></a></div>
        <div class="quick_bottom"><a href="#bottom"><i class="fa fa-arrow-down fa-2x"></i></a></div>
    </div>


</div>
<a name="bottom"></a>