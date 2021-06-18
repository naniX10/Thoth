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
    else if($('#author').val()=='') alert('저자를 입력해주세요.');
    else if($('#publish').val()=='') alert('출판사를 입력해주세요.');
    else if($('#origin_price').val()=='') alert('정가를 입력해주세요.');
    else if($('#sale_price').val()=='') alert('판매가를 입력해주세요.');
    else if($('#amount').val()=='') alert('판매량을 입력해주세요.');
    else if(grecaptcha.getResponse()=='') alert('자동가입방지를 입력해주세요.');
    else {
        const frm = $('#prdfrm');
        frm.attr('action','/product/pwrite');
        frm.attr('method','post');
        frm.submit();
        alert('상품이 등록되었습니다.');
    };
});

// 목록으로 버튼 클릭 이벤트 : view에서 list로 돌아가기
$('#listPbtn').on('click',function(){
    location.href='/product/plist';
});

// 상품 삭제 버튼 클릭 이벤트 1 : view에서 상품 삭제(1개 제거)
$('#delPbtn').on('click',function(){
    alert('상품이 삭제되었습니다.');
    location.href='/product/premove?tnum='+$('#tnum').val();
});

// 상품 수정 버튼 클릭 이벤트 : view에서 상품 수정


// 상품 삭제 버튼 클릭 이벤트 2 : list에서 상품 삭제(여러개 제거)