<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">

    <script src="https://www.google.com/recaptcha/api.js"></script>

    <div>
        <i class="fas fa-users fa-2x"> 회원가입 </i>
        <hr>
    </div><!-- 페이지 타이틀 -->

    <nav>
        <ul class="breadcrumb">
            <li class="breadcrumb-item active">
                <button type="button" disabled
                        class="btn btn-success">
                    이용약관</button>
            </li>
            <li class="breadcrumb-item">
                <button type="button" disabled
                        class="btn btn-success">
                    실명확인</button>
            </li>
            <li class="breadcrumb-item">
                <button type="button" disabled
                        class="btn btn-success">
                    정보입력</button>
            </li>
            <li class="breadcrumb-item">
                <button type="button" disabled
                        class="btn btn-light">
                    가입완료</button>
            </li>
        </ul>
    </nav><!-- 브레드크럼 -->

    <div>
        <h2>회원정보 입력</h2>
        <small class="text-muted">
            회원정보는 개인정보 취급방침에 따라 안전하게 보호되며,
            회원님의 명백한 동의없이 공개 또는 제3자에게 제공되지 않습니다.
        </small>
        <hr>
    </div><!-- 섹션 타이틀 -->

    <div class="card card-body bg-light">
        <h3>일반회원</h3>

        <form name="joinfrm" id="joinfrm">
            <div class="row">
                <div class="col-11 offset-1">
                    <div class="form-group row">
                        <label class="col-2 col-form-label text-danger text-right" for="name">
                            이름</label>
                        <input type="text" name="name" id="name"
                               class="form-control border-danger col-2"
                               readonly value="${param.name}">
                    </div><!-- 이름 -->

                    <div class="form-group row">
                        <label class="col-2 col-form-label text-danger text-right" for="jumin1">
                            주민번호</label>
                        <input type="text" name="jumin1" id="jumin1"
                               class="form-control border-danger col-2" readonly value="${param.jumin1}">
                        <span class="col-form-label">
                        &nbsp;&mdash;&nbsp;</span>
                        <input type="text" name="jumin2" id="jumin2"
                               class="form-control border-danger col-2" readonly value="${param.jumin2}">
                    </div><!-- 주민번호 -->

                    <div class="form-group row">
                        <label class="col-2 col-form-label text-danger text-right" for="userid">아이디</label>
                        <input type="text" name="userid" id="userid"
                               class="form-control border-danger col-3">
                        <span id="uidmsg" class="text-muted col-form-label">&nbsp;8~16자의 영문 소문자, 숫자와 특수기호(_)만 사용할 수 있습니다.</span>
                    </div><!-- 아이디 -->

                    <div class="form-group row">
                        <label class="col-2 col-form-label text-danger text-right" for="passwd">비밀번호</label>
                        <input type="password" name="passwd" id="passwd"
                               class="form-control border-danger col-3">
                        <span id="pwdmsg" class="text-muted col-form-label">&nbsp;8~16자의 영문 소문자, 숫자와 특수기호(_)만 사용할 수 있습니다.</span>
                    </div><!-- 비번 -->

                    <div class="form-group row">
                        <label class="col-2 col-form-label text-danger text-right" for="repasswd">비밀번호 확인</label>
                        <input type="password" name="repasswd" id="repasswd"
                               class="form-control border-danger col-3">
                        <span class="col-form-label">&nbsp;이전 항목에서 입력했던 비밀번호를 한번 더 입력하세요.</span>
                    </div><!-- 비번확인 -->

                    <div class="form-group row">
                        <label class="col-2 col-form-label text-danger text-right" for="zip1">우편번호</label>
                        <input type="text" name="zip1" id="zip1"
                               class="form-control border-danger col-1" readonly>
                        <span class="col-form-label">
                        &nbsp;&mdash;&nbsp;</span>
                        <input type="text" name="zip2" id="zip2"
                               class="form-control border-danger col-1" readonly>
                        &nbsp;
                        <button type="button" class="btn btn-dark"
                                data-toggle="modal" data-target="#zipmodal">
                            <i class="fas fa-question-circle"></i>
                            우편번호 찾기</button>
                    </div><!-- 우편번호 -->

                    <div class="form-group row">
                        <label class="col-2 col-form-label text-danger text-right" for="addr1">주소</label>
                        <input type="text" name="addr1" id="addr1"
                               class="form-control border-danger col-4">
                        &nbsp;&nbsp;
                        <input type="text" name="addr2" id="addr2"
                               class="form-control border-danger col-4">
                    </div><!-- 주소 -->

                    <div class="form-group row">
                        <label class="col-2 col-form-label text-danger text-right" for="addr1">전자우편 주소</label>
                        <input type="text" name="email1" id="email1"
                               class="form-control border-danger col-3">

                        <div class="input-group-prepend">
                            <span class="input-group-text">@</span>
                        </div>
                        <input type="text" name="email2" id="email2"
                               class="form-control border-danger col-2" readonly>
                        &nbsp;
                        <select class="form-control border-danger col-2" id="email3">
                            <option>-선택하세요-</option>
                            <option>직접입력하기</option>
                            <option>naver.com</option>
                            <option>gmail.com</option>
                            <option>hotmail.com</option>
                        </select>
                    </div><!-- 이메일 -->

                    <div class="form-group row">
                        <label class="col-2 col-form-label text-danger text-right" for="tel1">전화번호</label>
                        <select class="form-control border-danger col-2"
                                name="tel1" id="tel1">
                            <option>-국번-</option>
                            <option>010</option>
                            <option>011</option>
                        </select>
                        <span class="col-form-label">&nbsp;&mdash;&nbsp;</span>
                        <input type="text" name="tel2" id="tel2"
                               class="form-control border-danger col-2">
                        <span class="col-form-label">&nbsp;&mdash;&nbsp;</span>
                        <input type="text" name="tel3" id="tel3"
                               class="form-control border-danger col-2">
                    </div><!-- 전화번호 -->

                    <div class="form-group row">
                        <label class="col-2 col-form-label text-danger text-right">자동가입방지</label>
                        <div class="g-recaptcha"
                             data-sitekey="6LdmIwgbAAAAAPO06Cyw44ZE0pkeDeMHEwVbgiM-"></div>
                        <input type="hidden" id="g-recaptcha" name="g-recaptcha" />
                    </div><!-- 캡차 -->
                </div>
            </div><!-- 정보입력 -->

            <div class="row">
                <div class="col-12 text-center">
                    <hr>
                    <button type="button" class="btn btn-primary"
                            id="joinbtn"><i class="fas fa-check-circle"></i>
                        입력완료</button>
                    <button type="button" class="btn btn-danger"
                            id="cancelbtn"><i class="fas fa-times-circle"></i>
                        입력취소</button>
                </div>
            </div><!-- 버튼들 -->

            <input type="hidden" name="jumin" id="jumin">
            <input type="hidden" name="zipcode" id="zipcode">
            <input type="hidden" name="email" id="email">
            <input type="hidden" name="phone" id="phone">

        </form>
    </div><!-- 회원정보 입력 -->

    <!-- 우편번호 폼 모달 -->
    <div id="zipmodal" class="modal" role="dialog" tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title">우편번호 찾기</h3>
                    <button type="button" data-dismiss="modal"
                            class="close">&times;</button>
                </div>

                <div class="modal-body">
                    <form name="zipfrm" id="zipfrm">
                        <div class="form-inline row justify-content-center">
                            <label class="col-form-label text-primary text-right" for="dong">검색하실 주소의<br> 동이름을 입력하세요</label>
                            &nbsp;&nbsp;
                            <input type="text" name="dong" id="dong"
                                   class="form-control border-primary col-4">
                            &nbsp;&nbsp;
                            <button type="button" class="btn btn-primary"
                                    id="findzipbtn">
                                <i class="fas fa-search"></i>
                                검색하기</button>
                        </div>
                        <div class="form-group row">
                            <hr class="col-9">
                            <p class="col-12 text-danger text-center">
                                지역의 읍/면/동의 이름을 공백없이 입력하신 후,
                                [검색하기] 버튼을 클릭하세요</p>
                            <select class="col-8 offset-2 form-control"
                                    size="10" id="addrlist" name="addrlist">
                                <option>063-14 서울시 강남구 개포동</option>
                                <option>141-08 서울시 마포구 노고산동</option>
                                <option>016-82 서울시 노원구 상계동</option>
                                <option>047-14 서울시 성동구 행당동</option>
                                <option>043-63 서울시 용산구 용문동</option>
                                <option>033-55 서울시 은평구 불광동</option>
                                <option>045-78 서울시 중구 신당동</option>
                                <option>022-05 서울시 중랑구 면목동</option>
                                <option>256-27 강원도 강릉시 모전리</option>
                                <option>264-49 강원도 원주시 단구동</option>
                                <option>261-19 강원도 정선군 용탄리</option>
                                <option>240-23 강원도 철원군 구수동1길</option>
                                <option>244-06 강원도 춘천시 신숭겸로</option>
                                <option>251-07 강원도 홍천군 한서로</option>
                                <option>241-04 강원도 화천군 수피령로</option>
                                <option>252-21 강원도 횡성군 한우로</option>
                                <option>124-10 경기도 가평군 개곡리</option>
                                <option>134-55 경기도 성남시 운중동</option>
                                <option>175-04 경기도 안성시 봉산리</option>
                                <option>160-46 경기도 의왕시 오전동</option>
                                <option>111-57 경기도 포천시 유교리</option>
                                <option>183-47 경기도 화성시 황계동</option>
                                <option>101-21 경기도 김포시 향산리</option>
                                <option>145-20 경기도 부천시 도당동</option>
                                <option>624-63 광주시 광산구 고룡동</option>
                                <option>616-19 광주시 남구 월산동</option>
                                <option>614-48 광주시 동구 지산동</option>
                                <option>610-96 광주시 북구 동림동</option>
                                <option>619-14 광주시 서구 광천동</option>
                                <option>622-01 광주시 광산구 임곡동</option>
                                <option>616-11 광주시 남구 월산동</option>
                                <option>611-51 광주시 북구 각화동</option>
                                <option>467-05 부산시 강서구 강동동</option>
                                <option>462-25 부산시 금정구 남산동</option>
                                <option>460-44 부산시 기장군 삼성리</option>
                                <option>487-22 부산시 동구 범일동</option>
                                <option>477-55 부산시 동래구 안락동</option>
                                <option>466-10 부산시 북구 만덕동</option>
                                <option>494-18 부산시 사하구 신평동</option>
                                <option>490-72 부산시 영도구 신선동3가</option>

                            </select>
                        </div>
                    </form>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" id="sendzip">
                        <i class="fas fa-check-square"></i>
                        선택하고 닫기</button>
                </div>
            </div>
        </div>
    </div>

</div>