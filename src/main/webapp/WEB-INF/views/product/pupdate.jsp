<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div id="main" class="container">
    <!-- Page Title -->
    <div class="row">
        <div class="col">
            <p class="pwriteTitle">상품 수정</p>
        </div>
    </div>
    <form id="modprdfrm" class="modprdfrm">
        <div class="col-10 offset-2">
            <div class="form-group row prdfrmA">
                <label for="tnum" class="col-2 text-right">분류코드</label>
                <input type="text" name="tnum" id="tnum" class="col-8" value="${p.tnum}" readonly>
            </div>
            <div class="form-group row prdfrmC">
                <label for="title" class="col-2 text-right">제목</label>
                <input type="text" name="title" id="title"class="col-8"  value="${p.title}" readonly>
            </div>
            <div class="form-group row prdfrmD">
                <label for="author" class="col-2 text-right">저자</label>
                <input type="text" name="author" id="author" class="col-8" value="${p.author}">
            </div>
            <div class="form-group row prdfrmE">
                <label for="publish" class="col-2 text-right">출판사</label>
                <input type="text" name="publish" id="publish" class="col-8" value="${p.publish}">
            </div>
            <hr>

            <div class="form-group row prdfrmF">
                <label for="origin_price" class="col-2 text-right">정가</label>
                <input type="text" name="origin_price" id="origin_price" class="col-8" value="${p.origin_price}">
            </div>
            <div class="form-group row prdfrmG">
                <label for="sale_price" class="col-2 text-right">판매가</label>
                <input type="text" name="sale_price" id="sale_price" class="col-8" value="${p.sale_price}">
            </div>
            <div class="form-group row prdfrmH">
                <label for="amount" class="col-2 text-right">판매량</label>
                <input type="text" name="amount" id="amount" class="col-8" value="${p.amount}">
            </div>
            <hr>
            <div class="form-group row prdfrmB1">
                <input type="checkbox" id="die1">
                <label class="imageMain col-2 text-right" for="imageMain">메인이미지</label>
                <input type="file" name="img" id="imageMain" class="col-8" accept="image/*" disabled>
            </div>
            <div class="form-group row prdfrmB2">
                <input type="checkbox" id="die2">
                <label class="imageSub1 col-2 text-right" for="imageSub1">서브이미지</label>
                <input type="file" name="img" id="imageSub1" class="col-8" accept="image/*" disabled>
            </div>
            <div class="form-group row prdfrmB3">
                <input type="checkbox" id="die3">
                <label class="imageSub2 col-2 text-right" for="imageSub2">서브이미지</label>
                <input type="file" name="img" id="imageSub2" class="col-8" accept="image/*" disabled>
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
            <button type="button" id="save2Pbtn">수정완료</button>
            <button type="reset" id="re2Pbtn">다시입력</button>
            </div>
        </div>

        <%-- 기타 넘겨주는 변수들 --%>
        <input type="hidden" name="todie" id="todie">
        <input type="hidden" name="uuid" value="${b.uuid}">

    </form>



</div>


