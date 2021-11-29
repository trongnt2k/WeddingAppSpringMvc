<%-- 
    Document   : dishesanddrink
    Created on : Oct 16, 2021, 10:00:52 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">QUẢN LÝ MÓN ĂN</h1>
<c:url value="/admin/dishesanddrink" var="action" />
<form:form method="post" action="${action}" modelAttribute="dishesanddrink" enctype="multipart/form-data">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    <div class="form-group">
        <label for="name">Tên món ăn</label>
        <form:input type="text" id="name" path="name" cssClass="form-control"/>
        <form:errors path="name" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="price">Giá món ăn</label>
        <form:input type="number" id="price" path="price" cssClass="form-control"/>
        <form:errors path="price" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="file">Ảnh món ăn</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="menu">Thực đơn</label>
        <form:select id="menu" path="menu" cssClass="form-control">
            <c:forEach var="menu" items="${menu}">
                <option value="${menu.id}">${menu.name}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm món ăn" class="btn btn-success">
    </div>
</form:form>
