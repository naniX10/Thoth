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

$('#updatebdbtn').on('click',function() {
    const frm = $('#updateboardfrm');
    frm.attr('method','post');
    frm.attr('action','/notice/ntupdate');
    frm.submit();
});

$('#delete_btn').on('click' , function() {
    const frm = $('#viewfrm');
    frm.attr('method','post');
    frm.attr('action','/notice/ntdelete');
    frm.submit();
})

// 검색 버튼 클릭 이벤트
$('#searchNbtn').on('click',function(){
    if($('#findkey').val()=='') alert('검색할 내용을 작성해주세요.');
    else {
        let qry = '?findtype=' + $('#findtype').val();
        qry += '&findkey=' + $('#findkey').val()+"&cp=1";
        let url = '/notice/find' + qry;
        location.href = url;
    }
});

// 수정 버튼 클릭 이벤트
$('#mod_btn').on('click',function(){
    location.href = '/notice/ntupdate?bdno='+$('#bdno').val();
});

// 목록으로 버튼 클릭 이벤트
$('#list_btn').on('click',function(){
    location.href = '/notice/ntlist';
});

// 이전 버튼 클릭 이벤트
$('#prev_btn').on('click',function(){
    location.href = '/notice/prev?bdno='+$('#bdno').val();
});

// 다음 버튼 클릭 이벤트
$('#next_btn').on('click',function(){
    location.href = '/notice/next?bdno='+$('#bdno').val();
});