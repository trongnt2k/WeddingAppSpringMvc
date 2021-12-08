<%-- 
    Document   : wedding-stats
    Created on : Dec 7, 2021, 4:30:46 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3 class="text-center text-danger">THỐNG KÊ MẬT ĐỘ TIỆC CƯỚI THEO THÁNG</h3>

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
  <canvas id="myWeddingStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Tháng</th>
        <th>Số lượng tiệc cưới</th>
    </tr>
    <c:forEach items="${weddingStats}" var="w">
        <tr>
            <td>${w[0]}/${w[1]}</td>
            <td>${w[2]}</td>
        </tr>
    </c:forEach>
</table>

<script>
    let weddingLabels=[], weddingInfo=[]; 
    <c:forEach items="${weddingStats}" var="w">
        weddingLabels.push('${w[0]}/${w[1]}')
        weddingInfo.push(${w[2]})
    </c:forEach>
    window.onload = () => {
        weddingRevenueChart("myWeddingStatsChart", weddingLabels.reverse(), weddingInfo.reverse())
    }
</script>