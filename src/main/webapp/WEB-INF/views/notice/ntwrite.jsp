<%@ page pageEncoding="UTF-8"%>

<div id = "main">
    <form name = "boardfrm" id = "boardfrm">

        <div>
            <label for = "title" >제목</label>
            <input type="text" name = "title" id = "title" value = "${title}">
        </div>

        <div>
            <label for = "userid" >작성자</label>
            <input type="text" name = "userid" id = "userid" value = "${userid}" <%--readonly--%>>
        </div>

        <div>
            <label for = "contents" >본문내용</label>
            <input type="text" name = "contents" id = "contents" value = "${contents}">
        </div>

        <div>
            <button type="button" id="savebdbtn">입력완료</button>
            <button type="reset">다시입력</button>
        </div>

    </form>
</div>