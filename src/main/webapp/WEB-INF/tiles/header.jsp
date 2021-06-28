<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <div class="row spaceArea"></div>
    <div class="headerArea">
        <div class="headerAreaA">
            <c:if test="${empty UID}">
            <button type="button" id="loginbtn" class="btn"  data-toggle="modal"
                    data-target="#loginmodal" >로그인</button>
            <span class="spaceA">&nbsp;</span>
            <button type="button" id="signupbtn" class="btn">회원가입</button>
            </c:if>
            <c:if test="${not empty UID}">
            <button type="button" id="logoutbtn" class="btn" >로그아웃</button>
                <span class="spaceA">&nbsp;</span>
                <button type="button" id="myinfobtn" name="myinfobtn"> 내 정보</button>
            </c:if>
        </div>
        <div class="headerAreaB">
            <div class="headerLeft">
                <a href="/"><img src="/img/Thothlogo.png" ></a>
            </div>
            <div class="headerRight">
                <ul class="headerNav">
                    <li class="nav-item"><a href="/" class="nav-link">소개</a></li>
                    <li class="nav-item"><a href="/product/plist" class="nav-link">도서</a></li>
                    <li class="nav-item"><a href="/product/plist" class="nav-link">아동코너</a></li>
                    <li class="nav-item"><a href="/notice/ntlist" class="nav-link">공지사항</a></li>
                    <li class="nav-item"><a href="/myinfo/mlist" class="nav-link">Q&A</a></li>
                    <li class="nav-item"><a href="#" class="nav-link">이벤트</a></li>
                </ul>
            </div>

        </div>
    </div>
    <div class="headerBtn">

    </div>

</header>