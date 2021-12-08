<%-- 
    Document   : admin-left
    Created on : Dec 7, 2021, 4:26:25 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar bg-light">

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/weddinghall" />">Quản lý sảnh cưới</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/service" />">Quản lý dịch vụ cưới</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/menu" />">Quản lý thực đơn cưới</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/dishesanddrink" />">Quản lý món ăn</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/wedding-stats" />">Thống kê mật độ tiệc cưới theo tháng</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="<c:url value="/admin/wedding-year-stats" />">Thống kê mật độ tiệc cưới theo năm</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/wedding-revenue-stats" />">Thống kê doanh thu theo tháng</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="<c:url value="/admin/wedding-revenue-year-stats" />">Thống kê doanh thu theo năm</a>
    </li>
  </ul>

</nav>
