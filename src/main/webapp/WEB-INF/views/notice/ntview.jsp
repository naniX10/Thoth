<%@ page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${param.bdno eq 'null' or empty param.bdno}">
    <script>alert('게시글이 존재하지 않습니다.'); location.href="/notice/ntlist?cp=1"</script>
</c:if>

<div id="main" class="container">

    <div class="row">
        <div class="col">
            <p class="ntlistTitle">공지사항</p>
        </div>
    </div>

    <div class="row">
    <form class="container" name = "viewfrm" id = "viewfrm">
        <input type="hidden" name="bdno" id="bdno" value="${param.bdno}">

        <div class="row">
            <div class="col">
            <button type="button" class="btn" id="delete_btn">삭제</button>
            <span class="float-right">&nbsp;</span>
            <button type="button" class="btn" id="mod_btn">수정</button>
            </div>
        </div>

        <div class="row">
                <table class="col" style = "margin : 0px auto">
                    <tr>
                        <th colspan="2" class="text-white" style="width:50px; padding:10px;background-color:#BD83CE">
                            <h3 style = "text-align:center">${bd.title}</h3>
                        </th>
                    </tr>
                    <tr style="width:30px;  padding:10px; background-color:#F1C6E7">
                        <td style = "float : left"> 작성자 : ${bd.userid}</td>
                        <td class="text-right">작성일 : ${bd.regdate} / 조회수 : ${bd.views}</td>
                    </tr>

                    <tr>
                        <td colspan="2" style="height:550px; background-color:white;">
                            ${fn:replace(bd.contents, newChar, "<br>")}
                        </td>
                    </tr>

                </table>
            </div>

            <div class="row">
                <div class="col">
                    <button type="button" class="btn float-right" id="list_btn">목록으로</button>
                    <button type="button" class="btn" id="prev_btn">이전글</button>
                    <span> </span>
                    <button type="button" class="btn" id="next_btn">다음글</button>

                </div>

            </div>
    </form>
    </div>
</div>
<br>
<br>