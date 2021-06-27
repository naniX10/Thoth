<%@ page pageEncoding="UTF-8"%>

<div id = "main" container>
    <!-- Page Title -->
    <div class="row">
        <div class="col">
            <p class="ntwriteTitle">공지사항 등록</p>
        </div>
    </div>

    <form name = "boardfrm" id = "boardfrm">
        <div class="col-10 offset-2">
            <div class="form-group row bdfrmA">
                <label for = "title" class="col-2 text-right">제목</label>
                <input type="text" name = "title" id = "title" class="col-8" value = "${title}">
            </div>

            <div class="form-group row bdfrmB">
                <label for = "userid"  class="col-2 text-right">작성자</label>
                <input type="text" name = "userid" id = "userid" class="col-8" value = "${userid}" <%--readonly--%>>
            </div>

            <div class="form-group row bdfrmC">
                <label for = "contents" class="col-2 text-right">본문내용</label>
                <textarea name = "contents" class="col-8" id = "contents" rows="15" value = "${contents}">
                    </textarea>
            </div>
        </div>
            <div class="form-group row bdfrmD">
                <div class="col offset-5">
                <button type="submit" id="savebdbtn">입력완료</button>
                <button type="reset" id="reNtbtn">다시입력</button>
                </div>
            </div>
    </form>
</div>