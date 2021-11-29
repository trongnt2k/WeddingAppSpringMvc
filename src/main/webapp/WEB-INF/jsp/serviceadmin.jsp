<%-- 
    Document   : service
    Created on : Oct 14, 2021, 9:25:52 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1 class="text-center text-danger">QUẢN LÝ DỊCH VỤ CƯỚI</h1>
<c:url value="/admin/service" var="action" />
<form:form method="post" action="${action}" modelAttribute="service" enctype="multipart/form-data">
    <form:errors path="*" cssClass="alert alert-danger" element="div"/>
    <div class="form-group">
        <label for="name">Tên dịch vụ cưới</label>
        <form:input type="text" id="name" path="name" cssClass="form-control"/>
        <form:errors path="name" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="price">Giá dịch vụ cưới</label>
        <form:input type="number" id="price" path="price" cssClass="form-control"/>
        <form:errors path="price" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="description">Mô tả</label>
        <form:textarea type="text" id="description" path="description" cssClass="form-control"/>
        <form:errors path="description" cssClass="alert alert-danger" element="div"/>
    </div>
    <div class="form-group">
        <label for="file">Ảnh dịch vụ cưới</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm dịch vụ cưới" class="btn btn-success">
    </div>
</form:form>
