<%-- 
    Document   : wedding-detail
    Created on : Oct 23, 2021, 8:56:32 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1 class="text-center text-danger">TIỆC CƯỚI</h1>
<div class="row">
    <div class="col-md-6">
       <img class="img-fluid" src="<c:url value="/images/default.jpg" />" alt="${wedding.id}" />
    </div>
    <div class="col-md-6">
        <p>Số bàn: ${wedding.numberDesk}</p>
        <p>Ngày tổ chức: ${wedding.organizeDate}</p>
        <p>Mô tả: ${wedding.description}</p>
        <a href ="<c:url value="/wedding/weddingrent/${wedding.id}" />" class="btn btn-success">Các dịch vụ đã thuê</a>
        <p class="text-danger">Tổng tiền: <fmt:formatNumber value="${wedding.totalPrice}" type="currency" currencySymbol="₫"/></p> 
    </div>
</div>
<br></br>
<form class="form-group">
    <textarea class="form-control" id="commentId" placeholder="Nhập bình luận..."></textarea>
    <br>
    <input type="submit" onclick="addComment(${wedding.id})" value="Bình luận" class="btn btn-danger"/>
</form>

<div id="commentArea">

<c:forEach items="${comments}" var="comment">
    <div class="row">
        <div class="col-md-1" style="padding: 10px">
            <img class="rounded-circle img-fluid" src="<c:url value="/images/default.jpg" />" />
        </div>
        <div class="col-md-11 my-date">
            <p>${comment.content}</p>  
            <i>${comment.createdDate}</i> 
        </div>
    </div>
</c:forEach>
    
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(commentCounter/6)}" var="i" >
            <li class="page-item"><a class="page-link" href="<c:url value="/wedding/${wedding.id}" />?page=${i}">${i}</a></li>
        </c:forEach>
    </ul>
</div>

<script>
    window.onload = function() {
        let dates = document.querySelectorAll(".my-date > i")
        for(let i = 0; i < dates.length; i++){
            let d = dates[i]
            d.innerText = moment(d.innerText).fromNow()
        }
    }
    
</script>


