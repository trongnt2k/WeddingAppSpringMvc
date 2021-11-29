<%-- 
    Document   : register
    Created on : Oct 20, 2021, 2:18:32 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="/register" var="action"/>

<h1 class="text-danger text-center">ĐĂNG KÝ</h1>

<c:if test="${errMsg != null}">
    <div class="aler alert-danger">
        ${errMsg}
    </div>
</c:if>

<form:form method="post" action="${action}"
           enctype="multipart/form-data" modelAttribute="user">
    <div class="form-group">
        <label for="firstname">FirstName</label>
        <form:input type="text" id="firstname" path="firstName" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="lastname">LastName</label>
        <form:input type="text" id="lastname" path="lastName" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <form:input type="email" id="email" path="email" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="username">Username</label>
        <form:input type="text" id="username" path="username" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <form:input type="password" id="password" path="password" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="confirm-password">ConfirmPassword</label>
        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="avatar">Avatar</label>
        <form:input type="file" id="avatar" path="file" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Đăng kí" />
    </div>
</form:form>
