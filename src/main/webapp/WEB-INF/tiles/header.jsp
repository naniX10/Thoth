<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="row">
    <div class="col"><h1><a href="/"
                            style="color:black; text-decoration:none">Lorem Ipsum</a></h1></div>
    <div class="col text-right">
            <h1>
                <button type="button" class="btn btn-danger">로그인</button>
                <button type="button" class="btn btn-primary">회원가입</button>
                <button type="button" id="logoutbtn" class="btn btn-dark">로그아웃</button>
            </h1>

    </div>
</header>

<!-- nav Area -->
<nav class="navbar navbar-expand navbar-dark bg-dark">
    <ul class="navbar-nav nav-fill w-100">
        <li class="nav-item"><a href="#" class="nav-link">프로젝트소개</a></li>
        <li class="nav-item"><a href="#" class="nav-link">게시판</a></li>
        <li class="nav-item"><a href="#" class="nav-link">자료실</a></li>
        <li class="nav-item"><a href="#" class="nav-link">갤러리</a></li>
        <li class="nav-item"><a href="#" class="nav-link">관리자</a></li>
    </ul>
</nav>