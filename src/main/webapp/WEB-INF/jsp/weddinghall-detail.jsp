<%-- 
    Document   : weddinghall-detail
    Created on : Oct 22, 2021, 6:22:26 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1 class="text-center text-danger text-uppercase">${weddinghall.name}</h1>
<div class="row">
    <div class="col-md-6">
        <c:if test="${weddinghall.weddingHallImages != null && weddinghall.weddingHallImages.startsWith('https') == true}">
            <img class="img-fluid" src="<c:url value="${weddinghall.weddingHallImages}" />" alt="${weddinghall.name}" />
        </c:if>
        <c:if test="${weddinghall.weddingHallImages == null || weddinghall.weddingHallImages.startsWith('https') == false}">
            <img class="img-fluid" src="<c:url value="/images/default.jpg" />" alt="${weddinghall.name}" />
        </c:if>
    </div>
    <div class="col-md-6">
        <p>Buổi: ${weddinghall.timeWedding}</p>
        <p>Địa điểm: ${weddinghall.location}</p>
        <p>Mô tả: ${weddinghall.description}</p>
        <p class="text-danger">Giá thuê: <fmt:formatNumber value="${weddinghall.weddingHallPrice}" type="currency" currencySymbol="₫"/></p>
        <div>
            <a href ="#" class="btn btn-success" onclick="addWeddinghallToCart(${weddinghall.id}, '${weddinghall.name}', ${weddinghall.weddingHallPrice})">Thuê sảnh</a>
        </div> 
    </div>
</div>
