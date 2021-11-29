<%-- 
    Document   : weddinghall
    Created on : Oct 17, 2021, 5:22:16 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1 class="text-center text-danger">SẢNH CƯỚI</h1>

<form action="">
    <h5>Lọc sảnh cưới</h5>
    <div class="row">
        <div class="col-md-3">
            <input class="form-control" type="text" name="kw" placeholder="Nhập tên sảnh"/>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">
            <input type="radio" name="price" value="pri-incr"> Giá tăng
        </div>
        <div class="col-md-2">
            <input type="radio" name="time" value="Sáng"> Sáng
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">
            <input type="radio" name="price" value="pri-decr"> Giá giảm
        </div> 
        <div class="col-md-2">
            <input type="radio" name="time" value="Chiều"> Chiều
        </div>  
    </div>
    <div class="row">
        <div class="col-md-2">
            <input type="radio" name="price" value=""> Mặc định
        </div>
        <div class="col-md-2">
            <input type="radio" name="time" value="Tối"> Tối
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <input type="submit" value="Lọc" class="btn btn-success" />
        </div>
    </div>
</form>

<div>
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(count/6)}" var="i" >
            <li class="page-item"><a class="page-link" href="<c:url value="/weddinghall" />?page=${i}">${i}</a></li>
        </c:forEach>
    </ul>
</div>

<div class="row">
    <c:forEach var="wh" items="${weddinghall}">
       <div class="card col-md-4">
           <div class="card-body">
               <c:if test="${wh.weddingHallImages != null && wh.weddingHallImages.startsWith('https') == true}">
                   <img class="img-fluid" src="<c:url value="${wh.weddingHallImages}" />" alt="${wh.name}" />
               </c:if>
               <c:if test="${wh.weddingHallImages == null || wh.weddingHallImages.startsWith('https') == false}">
                   <img class="img-fluid" src="<c:url value="/images/default.jpg" />" alt="${wh.name}" />
               </c:if>
               <h3>${wh.name}</h3>
               <span>Buổi: ${wh.timeWedding}</span><br>
               <span class="text-danger">Giá: <fmt:formatNumber value="${wh.weddingHallPrice}" type="currency" currencySymbol="₫"/> </span>
           </div>
            <div class="card-footer">
                <button type="button" class="btn btn-primary" onclick="location.href='<c:url value="/weddinghall/${wh.id}" />' ">Chi tiết</button>
            </div>
        </div> 
    </c:forEach>
</div> 
