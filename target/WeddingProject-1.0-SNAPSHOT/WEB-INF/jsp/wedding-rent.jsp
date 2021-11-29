<%-- 
    Document   : wedding-rent
    Created on : Nov 27, 2021, 10:48:17 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center text-danger">DỊCH VỤ ĐÃ THUÊ</h1>
<table class="table">
    <c:if test="${wedding.weddinghall.id != null}">
    <tr>
        <th>Mã sảnh cưới</th>
        <th>Tên sảnh cưới</th>
        <th>Giá sảnh cưới</th>
    </tr>
    <tr>
        <td>${wedding.weddinghall.id}</td>
        <td><a href="<c:url value="/weddinghall/${wedding.weddinghall.id}" />">${wedding.weddinghall.name}</a></td>
        <td>${wedding.weddinghall.weddingHallPrice} ₫</td>
    </tr>
    </c:if>
    <c:if test="${wedding.menu.id != null}">
    <tr>
        <th>Mã thực đơn</th>
        <th>Tên thực đơn</th>
        <th>Giá thực đơn</th>
    </tr>
    <tr>
        <td>${wedding.menu.id}</td>
        <td><a href="<c:url value="/menu/${wedding.menu.id}" />">${wedding.menu.name}</a></td>
        <td>${wedding.menu.totalMoney} ₫</td>
    </tr>
    </c:if>
    <c:if test="${wedding.service.size() != 0}">
    <tr>
        <th>Mã dịch vụ</th>
        <th>Tên dịch vụ</th>
        <th>Giá dịch vụ</th>
    </tr>
    <c:forEach items="${wedding.service}" var="ws">
        <tr>
            <td>${ws.id}</td>
            <td><a href="<c:url value="/service/${ws.id}" />">${ws.name}</a></td>
            <td>${ws.price} ₫</td>
        </tr>
    </c:forEach>
    </c:if>
</table>
