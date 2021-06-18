// 검색 버튼 클릭 이벤트
$('#searchInbtn').on('click',function(){
    if($('#findkey').val()=='') alert('검색할 내용을 작성해주세요.');
    else {
        let qry = '?findtype=' + $('#findtype').val();
        qry += '&findkey=' + $('#findkey').val()+"&cp=1";
        let url = '/product/find' + qry;
        location.href = url;
    }
});

// 상품 등록 버튼 클릭 이벤트 : 상품 등록 페이지로 이동
$('#newPbtn').on('click',function(){
    location.href = '/product/pwrite'
})

// 입력 완료 버튼 클릭 이벤트 : 상품 등록 완료
$('#savePbtn').on('click',function(){
    if($('#tnum').val()=='') alert('분류코드를 입력해주세요.');
    else if($('#title').val()=='') alert('제목을 입력해주세요.');
    else if($('#author').val()=='') alert('지은이를 입력해주세요.');
    else {
        const frm = $('#prdfrm');
        frm.attr('action','/product/pwrite');
        frm.attr('method','post');
        frm.submit();
    };
});

// 상품 삭제 버튼 클릭 이벤트 :

// 상품 수정 버튼 클릭 이벤트 :