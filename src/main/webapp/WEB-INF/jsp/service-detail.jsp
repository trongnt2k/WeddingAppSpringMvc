<%-- 
    Document   : service-detail
    Created on : Oct 22, 2021, 7:54:04 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1 class="text-center text-danger text-uppercase">${service.name}</h1>
<div class="row">
    <div class="col-md-6">
        <c:if test="${service.serviceImage != null && service.serviceImage.startsWith('https') == true}">
            <img class="img-fluid" src="<c:url value="${service.serviceImage}" />" alt="${service.name}" />
        </c:if>
        <c:if test="${service.serviceImage == null || service.serviceImage.startsWith('https') == false}">
            <img class="img-fluid" src="<c:url value="/images/default.jpg" />" alt="${service.name}" />
        </c:if>
    </div>
    <div class="col-md-6">
        <p>Mô tả: ${service.description}</p>
        <p class="text-danger">Giá thuê: <fmt:formatNumber value="${service.price}" type="currency" currencySymbol="₫"/></p>
        <div>
            <a href ="#" class="btn btn-success" onclick="addServiceToCart(${service.id}, '${service.name}', ${service.price})">Thuê dịch vụ</a>
        </div> 
    </div>
</div>

