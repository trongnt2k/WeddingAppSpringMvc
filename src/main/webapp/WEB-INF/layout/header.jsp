<%-- 
    Document   : header
    Created on : Sep 12, 2021, 8:26:39 AM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="#">Wedding-Pro</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/wedding"/>">Tiệc cưới</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/weddinghall"/>">Sảnh cưới</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/service"/>">Dịch vụ</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/menu"/>">Thực đơn</a>
    </li>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/login"/>">
                <i class="fa fa-user" aria-hidden="true"></i>Đăng nhập
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/register"/>">
                Đăng kí
            </a>
        </li>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <li class="nav-item">
            <a class="nav-link text-danger" href="<c:url value="/weddinghall"/>">
                <c:if test="${currentUser.avatar != null}">
                    <img style="width: 30px" src="${currentUser.avatar}" class="rounded-circle"/>
                </c:if>
                <c:if test="${currentUser.avatar == null}">
                    <i class="fa fa-user" aria-hidden="true"></i>
                </c:if>
                ${pageContext.request.userPrincipal.name}
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-danger" href="<c:url value="/logout"/>">Đăng xuất</a>
        </li>
    </c:if>
    <li class="nav-item">
        <a href="<c:url value="/cart"/>" class="nav-link">
            <i class="fas fa-cart-plus text-success"></i>
            <div class="badge badge-danger" id="cartCounter">${counter}</div>
        </a>
    </li>
  </ul>
</nav>
