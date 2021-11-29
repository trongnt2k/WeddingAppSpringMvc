<%-- 
    Document   : menu
    Created on : Oct 18, 2021, 9:38:59 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1 class="text-center text-danger">THỰC ĐƠN CƯỚI</h1>

<form action="">
    <h5>Tìm thực đơn cưới</h5>
    <div class="row">
        <div class="col-md-3">
            <input class="form-control" type="text" name="kw" placeholder="Nhập tên thực đơn"/>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <input type="submit" value="Tìm" class="btn btn-success" />
        </div>
    </div>
</form>

<div>
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(count/6)}" var="i" >
            <li class="page-item"><a class="page-link" href="<c:url value="/menu" />?page=${i}">${i}</a></li>
        </c:forEach>
    </ul>
</div>
<div class="row">
    <c:forEach var="m" items="${menu}">
       <div class="card col-md-4">
           <div class="card-body">
               <c:if test="${m.menuImages != null && m.menuImages.startsWith('https') == true}">
                   <img class="img-fluid" src="<c:url value="${m.menuImages}" />" alt="${m.name}" />
               </c:if>
               <c:if test="${m.menuImages == null || m.menuImages.startsWith('https') == false}">
                   <img class="img-fluid" src="<c:url value="/images/default.jpg" />" alt="${m.name}" />
               </c:if>
               <h3>${m.name}</h3>
               <span class="text-danger">Giá: <fmt:formatNumber value="${m.totalMoney}" type="currency" currencySymbol="₫"/></span>
           </div>
            <div class="card-footer">
                <button type="button" class="btn btn-primary" onclick="location.href='<c:url value="/menu/${m.id}" />' ">Chi tiết</button>
            </div>
        </div> 
    </c:forEach>
</div>
