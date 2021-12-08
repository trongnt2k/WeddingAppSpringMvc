<%-- 
    Document   : wedding-revenue-stats
    Created on : Dec 7, 2021, 9:29:33 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h3 class="text-center text-danger">THỐNG KÊ DOANH THU THEO THÁNG</h3>

<form action="">
    <div class="form-group">
        <label>Từ Ngày</label>
        <input type="date" name="fromDate" class="form-control" />
    </div>
    <div class="form-group">
        <label>Đến Ngày</label>
        <input type="date" name="toDate" class="form-control" />
    </div>
    <input type="submit" value="Lọc" class="btn btn-primary" />
</form>

<div>
  <canvas id="myWeddingRevenueChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Doanh thu</th>
    </tr>
    <c:forEach items="${weddingRevenueStats}" var="w">
        <tr>
            <td>${w[0]}/${w[1]}</td>
            <td><fmt:formatNumber value="${w[2]}" type="currency" currencySymbol="₫"/></td>
        </tr>
    </c:forEach>
</table>

<script>
    let weddingRevenueLabels=[], weddingRevenueInfo=[]; 
    <c:forEach items="${weddingRevenueStats}" var="w">
        weddingRevenueLabels.push('${w[0]}/${w[1]}')
        weddingRevenueInfo.push(${w[2]})
    </c:forEach>
    window.onload = () => {
        weddingRevenueChart("myWeddingRevenueChart", weddingRevenueLabels.reverse(), weddingRevenueInfo.reverse())
    }
</script>
