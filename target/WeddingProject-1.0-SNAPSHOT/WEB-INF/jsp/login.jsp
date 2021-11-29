<%-- 
    Document   : login
    Created on : Oct 19, 2021, 9:21:58 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="/login" var="action"/>

<h1 class="text-danger text-center">ĐĂNG NHẬP</h1>

<c:if test="${param.error != null}">
    <div class="aler alert-danger">
        <p>Đăng nhập thất bại</p>
    </div>
</c:if>

<form method="post" action="${action}">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Đăng nhập" />
    </div>
</form>
