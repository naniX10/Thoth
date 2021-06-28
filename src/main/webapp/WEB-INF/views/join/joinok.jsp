<%@ page pageEncoding="UTF-8"%>

<div id="main">
    <!-- Page Title -->
    <div class="row">
        <div class="col">
            <p class="joinTitle">회원가입</p>
        </div>
        <hr>
    </div><!-- 페이지 타이틀 -->

    <!-- 브레드 크럼 -->
    <nav class="row">
        <ul class="offset-3 col breadStyle">
            <li class="">
                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                <button type="button" disabled
                        class="btn btnActive">
                    이용약관</button>
                <span class="itemA">&nbsp;&nbsp;&sc;&nbsp;&nbsp;</span>
            </li>
            <li class="">
                <button type="button" disabled
                        class="btn btnActive">
                    실명확인</button>
                <span class="itemA">&nbsp;&nbsp;&sc;&nbsp;&nbsp;</span>
            </li>
            <li class="">
                <button type="button" disabled
                        class="btn btnActive">
                    정보입력</button>
                <span class="itemA">&nbsp;&nbsp;&sc;&nbsp;&nbsp;</span>
            </li>
            <li class="">
                <button type="button" disabled
                        class="btn btnActive">
                    가입완료</button>
            </li>
        </ul>

    </nav><!-- 브레드 크럼 -->
    <!-- 섹션 타이틀 -->
    <div class="row sectionTitle">
        <div class="col">
            <h2 style="font-weight:bold">회원가입 완료</h2>
            <small class="text-muted">
                안전하고 편리한 홈페이지 이용을 위해 회원님의 아이디와
                비밀번호 관리에 주의해 주시기 바랍니다.
            </small>
            <hr>
        </div>
    </div><!-- 섹션 타이틀 -->


    <div class="jumbotron col-10 offset-1 bg-white">
        <h3 style="margin-bottom:15px;">회원가입을 축하드립니다.</h3>
        <p>현재 가입하신 아이디는 변경할 수 없으며
        일부 서비스는 실명확인 후 이용하실 수 있습니다.</p>

        <p>아이디와 비밀번호로 로그인하셔서
            Thoth과 함께 즐거운 시간 되십시오</p>
        <hr>
    </div>

    <div class="row text-center">
        <div class="col">
        <button type="button" id="go2index"
                class="btn">
            <i class="fa fa-home"></i> 메인으로 이동</button>
        </div>
    </div>
    <br>
    <br>
</div>
