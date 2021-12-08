<%-- 
    Document   : wedding-year-stats
    Created on : Dec 8, 2021, 9:34:50 AM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3 class="text-center text-danger">THỐNG KÊ MẬT ĐỘ TIỆC CƯỚI THEO NĂM</h3>

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
  <canvas id="myWeddingYearStatsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Năm</th>
        <th>Số lượng tiệc cưới</th>
    </tr>
    <c:forEach items="${weddingYearStats}" var="w">
        <tr>
            <td>${w[0]}</td>
            <td>${w[1]}</td>
        </tr>
    </c:forEach>
</table>

<script>
    let weddingYearLabels=[], weddingYearInfo=[]; 
    <c:forEach items="${weddingYearStats}" var="w">
        weddingYearLabels.push('${w[0]}')
        weddingYearInfo.push(${w[1]})
    </c:forEach>
    window.onload = () => {
        weddingChart("myWeddingYearStatsChart", weddingYearLabels.reverse(), weddingYearInfo.reverse())
    }
</script>
