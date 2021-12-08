<%-- 
    Document   : wedding-revenue-year-stats
    Created on : Dec 8, 2021, 9:32:15 AM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h3 class="text-center text-danger">THỐNG KÊ DOANH THU THEO NĂM</h3>

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
  <canvas id="myWeddingRevenueYearChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Năm</th>
        <th>Doanh thu</th>
    </tr>
    <c:forEach items="${weddingRevenueYearStats}" var="w">
        <tr>
            <td>${w[0]}</td>
            <td><fmt:formatNumber value="${w[1]}" type="currency" currencySymbol="₫"/></td>
        </tr>
    </c:forEach>
</table>

<script>
    let weddingRevenueYearLabels=[], weddingRevenueYearInfo=[]; 
    <c:forEach items="${weddingRevenueYearStats}" var="w">
        weddingRevenueYearLabels.push('${w[0]}')
        weddingRevenueYearInfo.push(${w[1]})
    </c:forEach>
    window.onload = () => {
        weddingChart("myWeddingRevenueYearChart", weddingRevenueYearLabels.reverse(), weddingRevenueYearInfo.reverse())
    }
</script>
