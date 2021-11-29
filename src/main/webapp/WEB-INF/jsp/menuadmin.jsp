<%-- 
    Document   : menuadmin
    Created on : Nov 28, 2021, 6:24:16 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">QUẢN LÝ THỰC ĐƠN</h1>
<c:url value="/admin/menu" var="action" />
<form:form method="post" action="${action}" modelAttribute="menu" enctype="multipart/form-data">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    <div class="form-group">
        <label for="name">Tên thực đơn</label>
        <form:input type="text" id="name" path="name" cssClass="form-control"/>
        <form:errors path="name" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="file">Ảnh thực đơn</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="dishesanddrink">Món ăn</label>
        <form:select id="dishesanddrink" path="dishesanddrink" cssClass="form-control">
            <c:forEach var="dishesanddrink" items="${dishesanddrink}">
                <option value="${dishesanddrink.id}">${dishesanddrink.name}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm thực đơn" class="btn btn-success">
    </div>
</form:form>
