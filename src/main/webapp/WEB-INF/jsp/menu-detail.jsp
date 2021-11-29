<%-- 
    Document   : menu-detail
    Created on : Oct 22, 2021, 8:05:04 PM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1 class="text-center text-danger text-uppercase">${menu.name}</h1>
<div class="row">
    <c:forEach var="d" items="${menu.dishesanddrink}">
       <div class="card col-md-4">
           <div class="card-body">
               <c:if test="${d.dishesDrinkImages != null && d.dishesDrinkImages.startsWith('https') == true}">
                   <img class="img-fluid" src="<c:url value="${d.dishesDrinkImages}" />" alt="${d.name}" />
               </c:if>
               <c:if test="${d.dishesDrinkImages == null || d.dishesDrinkImages.startsWith('https') == false}">
                   <img class="img-fluid" src="<c:url value="/images/default.jpg" />" alt="${d.name}" />
               </c:if>
               <h3>${d.name}</h3>
               <p class="text-danger">Giá: <fmt:formatNumber value="${d.price}" type="currency" currencySymbol="₫"/> </p>
           </div>
        </div> 
    </c:forEach>
</div>
<div>
    <h4 class="text-success">Tổng tiền: <span><fmt:formatNumber value="${menu.totalMoney}" type="currency" currencySymbol="₫"/></span></h4>
</div>
<div>
    <a href ="#" class="btn btn-success" onclick="addMenuToCart(${menu.id}, '${menu.name}', ${menu.totalMoney})">Đặt thực đơn</a>
</div> 