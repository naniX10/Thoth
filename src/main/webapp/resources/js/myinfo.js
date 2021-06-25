//
$('#qnabtn').on('click', function() {
    location.href = '/myinfo/mwrite';
});

//
$('#myinfobtn').on('click', function() {
    location.href = '/myinfo/mview';
});

//
$('#listmibtn').on('click', function() {
    location.href = '/myinfo/mlist';
});

//
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

//
$('#findbtn').on('click', function() {
    if ($('findkey').val() == '') alert('검색할 내용을 입력해주세요');
    else {
        let qry = '?findtype=' + $('#findtype').val();
        qry += "&findkey=" + $('#findkey').val() + "&cp=1";
        let url = '/myinfo/find' + qry;
        location.href = url;
    }
});

//
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
