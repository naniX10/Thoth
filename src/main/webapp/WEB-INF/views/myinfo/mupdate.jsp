<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="main">
    <div>
        <i class="fas fa-comments fa-2x"> QnA</i>
        <hr> <!-- 페이지 타이틀? -->
   </div>

    <div class="row">
        <div class="col">
            <p class="mwriteTitle">Q&A 수정</p>
        </div>
    </div>

        <form id="reqnafrm" name="reqnafrm">

            <input type="hidden" name="mino" value="${mi.mino}">
            <div class="form-group row">
                <label class="col-2 col-form-label text-right"

                       for="title">제목</label>
                <input type="text" name="title" id="title"
                       class="col-8" value="${mi.title}">
                </div>
            <div class="form-group row">
                <label class="col-2 text-right"
                       for="userid">작성자</label>
                <input type="text" name="userid" id="userid"
                       class="col-8"
                       value="${UID}" readonly>
            </div>
            <div class="form-group row">
                <label class="col-2 text-right"
                       for="contents">내용</label>
                <input type="textarea"  style="height:450px"  class="col-8"
                          name="contents" id="contents" value="${mi.contents}"></textarea>
            </div>
            <div class="form-group row">
                <label class="col-2 text-right">
                    자동<br>입력방지</label>
                <div class="g-recaptcha"
                     data-sitekey="6LfdIwgbAAAAAGZdSMWuY4f3zaKP-dIuhTMUrU8_"></div>
                <input type="hidden" id="g-recaptcha" name="g-recaptcha" />
            </div>

            <div class="form-group row">
                <div class="col offset-5">
                    <button type="button" id="reupqnabtn">
                        <i class="fa fa-check-circle"></i> 수정완료</button>
                    <button type="reset" id="reMbtn2">
                        <i class="fa fa-times-circle"></i> 입력취소</button>
                </div>
            </div><!-- 버튼들 -->


        </form>

        <input type="hidden" name="">

    </div>

</div><!-- 메인 -->
<br>