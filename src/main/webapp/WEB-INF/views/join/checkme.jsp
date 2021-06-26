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
                        class="btn btnDisabled">
                    정보입력</button>
                <span class="itemA">&nbsp;&nbsp;&sc;&nbsp;&nbsp;</span>
            </li>
            <li class="">
                <button type="button" disabled
                        class="btn btnDisabled">
                    가입완료</button>
            </li>
        </ul>

    </nav><!-- 브레드 크럼 -->

    <!-- 섹션 타이틀 -->
    <div class="row sectionTitle">
        <div class="col">
            <h2 style="font-weight:bold">가입인증</h2>
            <small class="text-muted">
                입력하신 정보는 가입완료 전까지 본 사이트에 저장되지 않습니다.
            </small>
            <hr>
        </div>
    </div><!-- 섹션 타이틀 -->

    <div class="card card-body agreeCard">
        <h3 style="margin-bottom:15px;">본인인증</h3>
        <form id="checkfrm2" name="checkfrm2">

            <div class="form-group row">
                        <label class="col-4 col-form-label text-dark
                      text-right" for="name2">이름</label>
                        <input type="text" name="name" id="name2"
                               class="form-control border-dark col-3">
                    </div>
            <div class="form-group row">
                        <label class="col-4 col-form-label text-dark
                      text-right" for="jumin1">주민번호</label>
                        <input type="text" name="jumin1" id="jumin1"

                               class="form-control border-dark col-2">
                        <span class="col-form-label">&nbsp;&mdash;&nbsp;</span>
                        <input type="text" name="jumin2" id="jumin2"

                               class="form-control border-dark col-2">
                    </div>
            <div class="form-group row">
                        <label class="col-4"></label>
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox" id="chkjumin" name="chkjumin"
                                   class="custom-control-input" value="y">
                            <label for="chkjumin"
                                   class="custom-control-label text-dark">
                                주민등록번호 처리에 동의합니다</label>
                        </div>
                    </div>

            <div class="row">
                <div class="col text-center">
                    <hr>
                    <button type="button" id="chk2btn" class="btn">
                        <i class="fa fa-check"></i> 확인하기</button>
                    <button type="button" id="cancel2btn" class="btn">     <i class="fa fa-times"></i> 취소하기</button>
                </div>
            </div><!-- 버튼들 -->
        </form>
    </div><!-- 실명 회원가입 -->
    <br>
    <br>
</div>