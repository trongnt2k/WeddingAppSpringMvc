<%-- 
    Document   : weddinghall
    Created on : Oct 14, 2021, 4:24:43 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">QUẢN LÝ SẢNH CƯỚI</h1>
<c:url value="/admin/weddinghall" var="action" />
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<form:form method="post" action="${action}" modelAttribute="weddinghall" enctype="multipart/form-data">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    <div class="form-group">
        <label for="name">Tên sảnh cưới</label>
        <form:input type="text" id="name" path="name" cssClass="form-control"/>
        <form:errors path="name" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="time">Buổi</label>
        <form:input type="text" id="time" path="timeWedding" cssClass="form-control"/>
        <form:errors path="timeWedding" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="location">Địa điểm</label>
        <form:input type="text" id="location" path="location" cssClass="form-control"/>
        <form:errors path="location" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="weddingHallPrice">Giá sảnh cưới</label>
        <form:input type="number" id="weddingHallPrice" path="weddingHallPrice" cssClass="form-control"/>
        <form:errors path="weddingHallPrice" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="description">Mô tả</label>
        <form:textarea type="text" id="description" path="description" cssClass="form-control"/>
        <form:errors path="description" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="file">Ảnh sảnh cưới</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm sảnh cưới" class="btn btn-success">
    </div>
</form:form>
