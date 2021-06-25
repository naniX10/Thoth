<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>

    <div class="header_top row" >
        <ul class="row">
            <li><a href="#" class="nav-link"> 매장안내 </a></li>&nbsp;&nbsp;
            <li><a href="#" class="nav-link"> 회원혜택</a> </li>
        </ul>
        <ul class="row">
            <button type="button" id="loginbtn">로그인</button>
            <li><a href="#" class="nav-link">회원가입 </a></li>
            <li><a href="#" class="nav-link">출석체크 </a></li>
            <li><a href="#" class="nav-link">고객센터 </a></li>
            <li><a href="#" class="nav-link">주문배송 </a></li>
        </ul>
    </div>

    <div class="headermain">
        <div class="logo">
            <img src="/img/Tothlogo.png" width="50%">
            <!--                                <i class="fas fa-crow" style="font-size: 30px; color:forestgreen"></i>
                                <div class="col"><h5><b>KYOBO 교보문고</b></h5></div>
            -->
        </div>
        <div class="col">
            <div class="form-group" style="display: flex">
                <input type="text" name="findkey" id="findkey"
                       class="form-control" style="color:#5e6b9e; " >
                <button type="button" id="findbtn"
                        style="background-color: #5e6b9e; color: white"><i class="fas fa-search"></i></button>
            </div>
        </div>
        <div style="width: 300px">

        </div>
    </div>
</header>

<nav class="navbar navbar-expand">
    <ul class="navbar-nav nav-fill w-100">
        <a href="#" class="navbar_toogleBtn"> <i class="fas fa-bars" ></i></a>
        <li class="nav-item" ><a href="#" class="nav-link" style="color: white">국내도서</a></li>
        <li class="nav-item"><a href="#" class="nav-link">외국도서</a></li>
        <li class="nav-item"><a href="#" class="nav-link">eBook</a></li>
        <li class="nav-item"><a href="#" class="nav-link">웹소설</a></li>
        <li class="nav-item"><a href="#" class="nav-link">기프트</a></li>
        <li class="nav-item"><a href="#" class="nav-link">음반</a></li>
        <li class="nav-item"><a href="#" class="nav-link">중고장터</a></li>
    </ul>
    <ul class= "navbar-nav nav-fill w-50" style="font-size: 14px">
        <li>베스트</li>
        <li>신상품</li>
        <li>이벤트</li>
        <li>사은품</li>
        <li>Picks</li>

    </ul>
</nav>