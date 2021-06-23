<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="fnameMain" value="${fn:split(b.fnames,'/')[0]}"/>
<c:set var="fsizeMain" value="${fn:split(b.fsizes,'/')[0]}"/>
<c:set var="fnames" value="${fn:split(b.fsizes,'/')}"/>
<c:set var="fsizes" value="${fn:split(b.fsizes,'/')}"/>
<c:set var="baseURL" value="http://localhost/book/"/>

<a name="top"></a>
<div class="wrapPlist"></div>
<div id="main" class="container">
    <div id="row">
        <!-- 좌측 영역 -->


        <!-- 중앙 영역 -->
        <div class="cside">
            <!-- 버튼 -->
            <button type="button" class="modPbtn" id="modPbtn">상품수정</button>
            <button type="button" class="delPbtn" id="delPbtn">상품삭제</button>
            <button type="button" class="listPbtn" id="listPbtn">목록보기</button>

            <!-- 상품수정/삭제를 위해 넘겨주는 값 -->
            <input type="hidden" id="tnum" value="${param.tnum}"/>

            <table class="table table-striped text-center table-hover">
                <thead style="background: #dff0d8">
                <tr>
                    <th>이미지</th>
                    <th>제목</th>
                    <th>작가</th>
                    <th>출판사</th>
                    <th>정가</th>
                    <th>판매가</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <!-- 기존글 이미지  -->
                        <c:if test="${not empty p.image}">
                            <td><img src="${p.image}" alt="도서이미지" width="100px"></img></td>
                        </c:if>
                        <!-- 새글쓰기로 추가한 이미지 -->
                        <c:if test="${empty p.image}">
                            <c:set var="f" value="${fnameMain}"/>
                                    <c:if test="${f ne '-'}">
                                        <c:set var="pos" value="${fn:indexOf(f,'.')}"/>
                                        <c:set var="fname" value="${fn:substring(f,0,pos)}"/>
                                        <c:set var="fext" value="${fn:substring(f,pos+1,fn:length(f))}"/>
                            <td><img src="${baseURL}${fname}${b.uuid}.${fext}" alt="도서이미지2" width="100px"></img></td>
                                    </c:if>
                        </c:if>
                            <td>${p.title}</td>
                        <td>${p.author}</td>
                        <td>${p.publish}</td>
                        <td>${p.origin_price}</td>
                        <td>${p.sale_price}</td>
                    </tr>
                </tbody>
            </table>

        </div><!-- cside -->

        <!-- 우측 영역 -->
        <div class="rside">
            <div class="quick_menu">
                <div class="quick_top"><a href="#top"><i class="fa fa-arrow-up fa-2x"></i></a></div>
                <div class="quick_bottom"><a href="#bottom"><i class="fa fa-arrow-down fa-2x"></i></a></div>
            </div>
        </div><!-- rside -->

    </div><!--wrap-->
</div>
<a name="bottom"></a>