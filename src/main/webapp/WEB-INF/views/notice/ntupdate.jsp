<%@ page pageEncoding="UTF-8"%>

<div id = "main" container>
    <!-- Page Title -->
    <div class="row">
        <div class="col">
            <p class="ntwriteTitle">공지사항 수정</p>
        </div>
    </div>

    <form name = "updateboardfrm" id = "updateboardfrm">
        <input type="hidden" name="bdno" value="${bd.bdno}">
        <div class="col-10 offset-2">
            <div class="form-group row bdfrmA">
                <label for = "title" class="col-2 text-right">제목</label>
                <input type="text" class="col-8" name = "title" id = "title" value = "${bd.title}" >
            </div>

            <div class="form-group row bdfrmB">
                <label for = "userid" class="col-2 text-right">작성자</label>
                <input type="text" class="col-8" name = "userid" id = "userid" value = "${bd.userid}" readonly>
            </div>

            <div class="form-group row bdfrmC">
                <label for = "contents" class="col-2 text-right">본문내용</label>
                <input type="textarea"  style="height:450px" class="col-8" rows="15" name = "contents" id = "contents" value = "${bd.contents}">
                </input>
            </div>

        </div>
        <div class="form-group row bdfrmD">
            <div class="col offset-5">
            <button type="submit" id="updatebdbtn">입력완료</button>
            <button type="reset" id="reNt2btn">다시입력</button>
        </div>
        </div>

    </form>
</div>