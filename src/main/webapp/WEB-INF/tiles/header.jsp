<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="row">
    <div class="col"><h1><a href="/" style="color:black; text-decoration:none">Thoth</a></h1></div>
</header>

<div class="row">
    <button type="button" class="btn btn-danger">로그인</button>
    <button type="button" class="btn btn-primary">회원가입</button>
    <button type="button" id="logoutbtn" class="btn btn-dark">로그아웃</button>
</div>

<!-- nav Area -->
<nav class="navbar navbar-expand navbar-dark bg-dark">
    <ul class="navbar-nav nav-fill w-100">
        <li class="nav-item"><a href="/product/plist" class="nav-link">도서</a></li>
        <li class="nav-item"><a href="#" class="nav-link">공지사항</a></li>
        <li class="nav-item"><a href="#" class="nav-link">Q&A</a></li>
        <li class="nav-item"><a href="#" class="nav-link">이벤트</a></li>
    </ul>
</nav>