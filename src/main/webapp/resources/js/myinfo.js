//
$('#qnabtn').on('click', function() {

        location.href = '/myinfo/mwrite';

});

// id입력?
$('#myinfonqnabtn').on('click', function() {
    let uid = $('#UID');
    location.href = '/minfoupdate/mview?userid=' + uid;
});

//
$('#listmibtn').on('click', function() {
    location.href = '/myinfo/mlist';
});

// 검색?
$('#findbtn').on('click', function() {
    if ($('findkey').val() == '') alert('검색할 내용을 입력해주세요');
    else {
        let qry = '?findtype=' + $('#findtype').val();
        qry += "&findkey=" + $('#findkey').val() + "&cp=1";
        let url = '/myinfo/find' + qry;
        location.href = url;
    }
});

// 글 작성?
$('#upqnabtn').on('click', function() {
    if ($('#title').val() == '') alert('제목을 작성하세요');
    else if ($('#contents').val() == '') alert('본문을 작성하세요');
    else if (grecaptcha.getResponse() == '') alert('자동가입방지를 확인하세요');
    else {
        const frm = $('#qnafrm');
        frm.attr('method', 'post');
        frm.attr('action', '/myinfo/mwrite');
        frm.submit();
    }
});


// QnA 수정 완료
$('#reupqnabtn').on('click', function () {
    if (grecaptcha.getResponse() == '') alert('자동입력방지를 확인해 주세요!');
    else {
        const frm = $('#reqnafrm');
        frm.attr('method','post');
        frm.attr('action','/myinfo/mupdate');
        frm.submit();
    }
});

// 수정 버튼 클릭 이벤트 - 수정 페이지로 이동
$('#mmodqnabtn').on('click',function(){
    location.href = '/myinfo/mupdate?mino='+$('#mino').val();
});


// 수정완료
$('#reupqnabtn').on('click',function() {
    const frm = $('#reqnafrm');
    frm.attr('method','post');
    frm.attr('action','/myinfo/mupdate');
    frm.submit();
});


// QnA 삭제?
$('#delqnabtn').on('click', function () {
    location.href = '/myinfo/mirmv?mino=' + $('#mino').val();

});

// 댓글 작성?
$('#newmrbtn').on('click', function() {
    if ($('#reply').val() == '') alert('댓글을 작성하세요!');
    else {
        const frm = $('#replyfrm');
        frm.attr('method', 'post');
        frm.attr('action', '/reply/mwrite');
        frm.submit();
    }
});

// show reply
function addReply(rno) {
    $('#replyModal').modal('show');
    $('#rpno').val(rno);  // 대댓글 작성시 부모댓글번호를 넘겨줌
}

// new reply
$('#newrrpbtn').on('click', function (){
    if ($('#rreply').val() == '') alert('대댓글을 작성하세요!!');
    else {
        const frm = $('#rpfrm');
        frm.attr('method', 'post');
        frm.attr('action', '/rreply/mwrite');
        frm.submit();
    }
});

// 내정보 수정하기

$('#updateinfobtn').on('click', function () {
    const frm = $('#upmiform');
    frm.attr('method','post');
    frm.attr('action','/myinfo/mview');
    frm.submit();
});


