// 글쓰기
$('#gowrite').on('click' , function() {
    location.href = "/notice/ntwrite";
});

// save Notice
$('#savebdbtn').on('click',function() {
    if ($('#title').val() == '') alert('제목을 작성하세요');
    else if ($('#contents').val() == '') alert('본문을 작성하세요');
    else {
        const frm = $('#boardfrm');
        frm.attr('method','post');
        frm.attr('action','/notice/ntwrite');
        frm.submit();
    }
});

