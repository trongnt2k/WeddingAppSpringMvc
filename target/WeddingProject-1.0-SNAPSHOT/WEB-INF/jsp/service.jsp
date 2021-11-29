<%-- 
    Document   : service
    Created on : Oct 17, 2021, 10:05:07 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1 class="text-center text-danger">DỊCH VỤ CƯỚI</h1>

<form action="">
    <h5>Lọc dịch vụ cưới</h5>
    <div class="row">
        <div class="col-md-3">
            <input class="form-control" type="text" name="kw" placeholder="Nhập tên dịch vụ"/>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <input type="radio" name="price" value="pri-incr"> Giá tăng
        </div>
    </div>
    <div class="row">
        <div class="col">
            <input type="radio" name="price" value="pri-decr"> Giá giảm
        </div> 
    </div>
    <div class="row">
        <div class="col">
            <input type="radio" name="price" value=""> Mặc định
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
            <li class="page-item"><a class="page-link" href="<c:url value="/service" />?page=${i}">${i}</a></li>
        </c:forEach>
    </ul>
</div>

<div class="row">
    <c:forEach var="sv" items="${service}">
       <div class="card col-md-4">
           <div class="card-body">
               <c:if test="${sv.serviceImage != null && sv.serviceImage.startsWith('https') == true}">
                   <img class="img-fluid" src="<c:url value="${sv.serviceImage}" />" alt="${sv.name}" />
               </c:if>
               <c:if test="${sv.serviceImage == null || sv.serviceImage.startsWith('https') == false}">
                   <img class="img-fluid" src="<c:url value="/images/default.jpg" />" alt="${sv.name}" />
               </c:if>
               <h3>${sv.name}</h3>
               <span class="text-danger">Giá: <fmt:formatNumber value="${sv.price}" type="currency" currencySymbol="₫"/> </span>
           </div>
            <div class="card-footer">
                <button type="button" class="btn btn-primary" onclick="location.href='<c:url value="/service/${sv.id}" />' ">Chi tiết</button>
            </div>
        </div> 
    </c:forEach>
</div>
