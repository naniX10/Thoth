<%@ page pageEncoding="UTF-8"%>

<div id = "main">
    <form role = "form" method = "get" action = "/notice/update">

        <input type="hidden" name="bdno" value="${bd.bdno}">

        <div>
            <label for = "title" >제목</label>
            <input type="text" name = "title" id = "title" value = "${bd.title}" >
        </div>

        <div>
            <label for = "userid" >작성자</label>
            <input type="text" name = "userid" id = "userid" value = "${bd.userid}" readonly>
        </div>

        <div>
            <label for = "contents" >본문내용</label>
            <input type="text" name = "contents" id = "contents" value = "${bd.contents}">
        </div>

        <div>
            <button type="submit">입력완료</button>
            <button type="reset">다시입력</button>
        </div>

    </form>
</div>