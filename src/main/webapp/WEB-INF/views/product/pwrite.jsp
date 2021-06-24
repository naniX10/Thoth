<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a name="top"></a>
<div class="wrapPlist"></div>
<div id="main" class="container">
        <!-- Page Title -->
        <div class="row">
            <div class="col">
                <p class="pwriteTitle">상품 등록</p>
            </div>
        </div>
            <form id="prdfrm" class="prdfrm">
                <div class="col-10 offset-2">
                    <div class="form-group row prdfrmA">
                        <label for="tnum" class="col-2 text-right">분류코드</label>
                        <input type="text" name="tnum" id="tnum" class="col-8"
                        placeholder="분류코드는 알파벳대문자 + 숫자조합으로 작성해주세요.">
                    </div>

                    <div class="form-group row prdfrmC">
                        <label for="title" class="col-2 text-right">제목</label>
                        <input type="text" name="title" id="title" class="col-8">
                    </div>

                    <div class="form-group row prdfrmD">
                        <label for="author" class="col-2 text-right">저자</label>
                        <input type="text" name="author" id="author" class="col-8">
                    </div>
                    <div class="form-group row prdfrmE">
                        <label for="publish" class="col-2 text-right">출판사</label>
                        <input type="text" name="publish" id="publish" class="col-8">
                    </div>
                    <hr>
                    <div class="form-group row prdfrmF">
                        <label for="origin_price" class="col-2 text-right">정가</label>
                        <input type="text" name="origin_price" id="origin_price"class="col-8">
                    </div>
                    <div class="form-group row prdfrmG">
                        <label for="sale_price" class="col-2 text-right">판매가</label>
                        <input type="text" name="sale_price" id="sale_price"class="col-8">
                    </div>
                    <div class="form-group row prdfrmH">
                        <label for="amount" class="col-2 text-right">판매량</label>
                        <input type="text" name="amount" id="amount" class="col-8">
                    </div>
                    <hr>
                    <!-- 이미지 업로드는 나중에 구현 -->
                    <div class="form-group row prdfrmB1 ">
                        <label class="imageMain col-2 text-right" for="imageMain">메인이미지</label>
                        <input type="file" name="img" id="imageMain" accept="image/*">
                    </div>
                    <div class="form-group row prdfrmB2">
                        <label class="imageSub1 col-2 text-right" for="imageSub1">서브이미지</label>
                        <input type="file" name="img" id="imageSub1" accept="image/*">
                    </div>
                    <div class="form-group row prdfrmB3">
                        <label class="imageSub2 col-2 text-right" for="imageSub2">서브이미지</label>
                        <input type="file" name="img" id="imageSub2" accept="image/*">
                    </div>
                    <hr>
                    <!-- 자동입력방지 -->
                    <div class="form-group row prdfrmI">
                        <label class="col-2 text-right">자동입력방지</label>
                        <div class="g-recaptcha" data-sitekey="6LfaIwgbAAAAAEVrujfQ72ArOe5Ru4YCjVW1GBSl"></div>
                        <input type="hidden" id="g-recaptcha" name="g-recaptcha" />
                    </div>
                </div>
                <!-- 버튼들 -->
                <div class="form-group row prdfrmJ">
                    <div class="col offset-5">
                        <button type="submit" id="savePbtn">입력완료</button>
                        <button type="reset" id="rePbtn">다시입력</button>
                    </div>
                </div>
            </form>



    <div class="quick_menu">
        <div class="quick_top"><a href="#top"><i class="fa fa-arrow-up fa-2x"></i></a></div>
        <div class="quick_bottom"><a href="#bottom"><i class="fa fa-arrow-down fa-2x"></i></a></div>
    </div>
</div>
<a name="bottom"></a>

