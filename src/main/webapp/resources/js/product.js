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
        frm.attr('enctype','multipart/form-data');
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


// 상품 등록 - 이미지 등록시 파일명 표시
$('#imageMain').on('change',function(){
    var fname = $(this).val();
    fname = fname.substring(fname.lastIndexOf("\\")+1);
    $(this).next('.imageMain').html(fname);
})
$('#imageSub1').on('change',function(){
    var fname = $(this).val();
    fname = fname.substring(fname.lastIndexOf("\\")+1);
    $(this).next('.imageSub1').html(fname);
})
$('#imageSub2').on('change',function(){
    var fname = $(this).val();
    fname = fname.substring(fname.lastIndexOf("\\")+1);
    $(this).next('.imageSub2').html(fname);
})

// 상품 수정 버튼 클릭 이벤트
$('#modPbtn').on('click',function(){
    location.href = '/product/pupdate?tnum='+$('#tnum').val();
});

// 수정 완료 버튼 클릭 이벤트 : 상품 수정 완료
$('#save2Pbtn').on('click',function(){
   if(grecaptcha.getResponse()=='') alert('자동가입방지를 입력해주세요.');
    else {
        const frm = $('#modprdfrm');
         frm.attr('action','/product/pupdate');
         frm.attr('method','post');
         frm.attr('enctype','multipart/form-data');
         frm.submit();
         alert('상품이 수정되었습니다.');
    };
});

// 수정 : 삭제할 이미지 선택
$('#die1').on('change',function(){
    if($('#die1').is(':checked')){// checkbox가 체크되면
        $('#imageMain').attr('disabled',false); // disabled 해제
        $('#todie').val("1"+$('#todie').val()); // 첨부파일 수정목록에 1 추가
    } else if (!$('#die1').is(':checked')){
        $('#imageMain').attr('disabled',true);
        $('#todie').val($('#todie').val().replace(/1/g,'')); // 첨부파일 수정목록에 1 제거
    }
});

$('#die2').on('change',function(){
    if($('#die2').is(':checked')){//checkbox가 체크되면
        $('#imageSub1').attr('disabled',false); // disabled 해제
        $('#todie').val("2"+$('#todie').val()); // 첨부파일 수정목록에 2 추가
    } else if (!$('#die2').is(':checked')){
        $('#imageSub1').attr('disabled',true);
        $('#todie').val($('#todie').val().replace(/2/g,'')); // 첨부파일 수정목록에 2 제거
    }
});

$('#die3').on('change',function(){
    if($('#die3').is(':checked')){// checkbox가 체크되면
        $('#imageSub2').attr('disabled',false); // disabled 해제
        $('#todie').val("3"+$('#todie').val()); // 첨부파일 수정목록에 3 추가
    } else if (!$('#die3').is(':checked')){
        $('#imageSub2').attr('disabled',true);
        $('#todie').val($('#todie').val().replace(/3/g,'')); // 첨부파일 수정목록에 3 제거
    }
});

// 상품 삭제 버튼 클릭 이벤트 2 : list에서 상품 삭제(여러개 제거)