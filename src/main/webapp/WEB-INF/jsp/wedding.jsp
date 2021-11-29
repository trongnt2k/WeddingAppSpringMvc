<%-- 
    Document   : wedding
    Created on : Oct 21, 2021, 10:11:26 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1 class="text-center text-danger">TIỆC CƯỚI</h1>
<form action="">
    <h5>Tìm tiệc cưới theo ngày tổ chức</h5>
    <div class="row">
        <div class="col-md-3">
            <input class="form-control" type="text" onblur="(this.type='text')" onfocus="(this.type='date')" name="startDate" placeholder="Từ ngày"/>
            <input class="form-control" type="text" onblur="(this.type='text')" onfocus="(this.type='date')" name="endDate" placeholder="Đến ngày"/>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <input type="radio" name="price" value="pri-incr"> Giá tăng
        </div>
    </div>
    <div class="row">
        <div class="col">
            <input type="radio" name="price" value="pri-decr"> Giá giảm
        </div>   
    </div>
    <div class="row">
        <div class="col">
            <input type="radio" name="price" value=""> Mặc định
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
            <input type="submit" value="Lọc" class="btn btn-success" />
        </div>
    </div>
</form>
<div>
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(count/6)}" var="i" >
            <li class="page-item"><a class="page-link" href="<c:url value="/wedding" />?page=${i}">${i}</a></li>
        </c:forEach>
    </ul>
</div>

<div class="row">
    <c:forEach var="wd" items="${wedding}">
       <div class="card col-md-4">
           <div class="card-body">             
           <img class="img-fluid" src="<c:url value="/images/default.jpg" />" alt="${wd.id}" />
              
           <h4>Ngày tổ chức: <fmt:formatDate value="${wd.organizeDate}" pattern="dd/MM/yyyy" /></h4>
           <span class="text-danger">Tổng tiền: <fmt:formatNumber value="${wd.totalPrice}" type="currency" currencySymbol="₫"/></span>
           </div>
            <div class="card-footer">
                <button type="button" class="btn btn-primary" onclick="location.href='<c:url value="/wedding/${wd.id}" />' ">Chi tiết</button>
            </div>
        </div> 
    </c:forEach>
</div>