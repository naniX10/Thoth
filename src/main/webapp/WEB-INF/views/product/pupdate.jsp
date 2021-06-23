<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<a name="top"></a>
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
            <form id="modprdfrm" class="modprdfrm">
                <div class="prdfrmA">
                    <label for="tnum">분류코드</label>
                    <input type="text" name="tnum" id="tnum" value="${p.tnum}" readonly>
                </div>
                <!-- 이미지 업로드는 나중에 구현 -->
                <div class="prdfrmB1">
                    <input type="checkbox" id="die1">
                    <label class="imageMain" for="imageMain">메인이미지</label>
                    <input type="file" name="img" id="imageMain" accept="image/*" disabled>
                </div>
                <div class="prdfrmB2">
                    <input type="checkbox" id="die2">
                    <label class="imageSub1" for="imageSub1">서브이미지</label>
                    <input type="file" name="img" id="imageSub1" accept="image/*" disabled>
                </div>
                <div class="prdfrmB3">
                    <input type="checkbox" id="die3">
                    <label class="imageSub2" for="imageSub2">서브이미지</label>
                    <input type="file" name="img" id="imageSub2" accept="image/*" disabled>
                </div>
                <div class="prdfrmC">
                    <label for="title">제목</label>
                    <input type="text" name="title" id="title" value="${p.title}" readonly>
                </div>
                <div class="prdfrmD">
                    <label for="author">저자</label>
                    <input type="text" name="author" id="author" value="${p.author}">
                </div>
                <div class="prdfrmE">
                    <label for="publish">출판사</label>
                    <input type="text" name="publish" id="publish" value="${p.publish}">
                </div>
                <div class="prdfrmF">
                    <label for="origin_price">정가</label>
                    <input type="text" name="origin_price" id="origin_price" value="${p.origin_price}">
                </div>
                <div class="prdfrmG">
                    <label for="sale_price">판매가</label>
                    <input type="text" name="sale_price" id="sale_price" value="${p.sale_price}">
                </div>
                <div class="prdfrmH">
                    <label for="amount">판매량</label>
                    <input type="text" name="amount" id="amount" value="${p.amount}">
                </div>

                <!-- 자동입력방지 -->
                <div class="prdfrmI">
                    <label>자동입력방지</label>
                    <div class="g-recaptcha" data-sitekey="6LfaIwgbAAAAAEVrujfQ72ArOe5Ru4YCjVW1GBSl"></div>
                    <input type="hidden" id="g-recaptcha" name="g-recaptcha" />
                </div>

                <!-- 버튼들 -->
                <div class="prdfrmJ">
                    <button type="button" id="save2Pbtn">수정완료</button>
                    <button type="reset" id="re2Pbtn">다시입력</button>
                </div>

                <%-- 기타 넘겨주는 변수들 --%>
                <input type="hidden" name="todie" id="todie">
                <input type="hidden" name="uuid" value="${b.uuid}">

            </form>
        </div><!-- cside -->

        <!-- 우측 영역 -->
        <div class="rside">
            <div class="quick_menu">
                <div class="quick_top"><a href="#top"><i class="fa fa-arrow-up fa-2x"></i></a></div>
                <div class="quick_bottom"><a href="#bottom"><i class="fa fa-arrow-down fa-2x"></i></a></div>
            </div>
        </div><!-- rside -->

    </div><!--wrap-->
</div>
<a name="bottom"></a>

