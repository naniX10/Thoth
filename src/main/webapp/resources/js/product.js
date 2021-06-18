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