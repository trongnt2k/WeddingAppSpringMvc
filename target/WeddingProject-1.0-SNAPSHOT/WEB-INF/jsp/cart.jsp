<%-- 
    Document   : cart.jsp
    Created on : Oct 23, 2021, 5:56:49 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1 class="text-center text-danger">GIỎ HÀNG</h1>
<c:if test="${cart.size() == 0}">
    <h4 class="text-danger">Không có sản phẩm nào trong giỏ</h4>
</c:if>
    
<c:if test="${cart.size() != 0}">
    <table class="table">
        <c:if test="${service.size() != 0}">
        <tr>
            <th>Mã dịch vụ cưới</th>
            <th>Tên dịch vụ cưới</th>
            <th>Giá dịch vụ cưới</th>
            <th></th>
        </tr>
        <c:forEach items="${service}" var="s">
        <tr>
            <td>${s.serviceId}</td>
            <td>${s.serviceName}</td>
            <td>${s.price}</td>
            <td>
                <input type="button" value="Xóa" class="btn btn-danger" onclick="deleteService(${s.serviceId})"/>
            </td>
        </tr>
        </c:forEach>
        </c:if>
        <c:if test="${weddinghall != null}">
            <tr>
                <th>Mã sảnh cưới</th>
                <th>Tên sảnh cưới</th>
                <th>Giá sảnh cưới</th>
                <th></th>
            </tr>
            <tr>
                <td>${weddinghall.weddingHallId}</td>
                <td>${weddinghall.weddingHallName}</td>
                <td>${weddinghall.price}</td>
                <td>
                    <input type="button" value="Xóa" class="btn btn-danger" onclick="deleteWeddinghall(${weddinghall.weddingHallId})"/>
                </td>
            </tr>
        </c:if>
        <c:if test="${menu != null}">
        <tr>
            <th>Mã thực đơn cưới</th>
            <th>Tên thực đơn cưới</th>
            <th>Giá thực đơn cưới</th>
            <th></th>
        </tr>
        <tr>
            <td>${menu.menuId}</td>
            <td>${menu.menuName}</td>
            <td>${menu.price}</td>
            <td>
                <input type="button" value="Xóa" class="btn btn-danger" onclick="deleteMenu(${menu.menuId})"/>
            </td>
        </tr>
        </c:if>
    </table>
    <div>
        <label for="organizeDate">Ngày tổ chức<i class="text-danger">*</i>: </label>
        <input type="date" id="organizeDate" name="organizeDate" data-date="" data-date-format="DD MMMM YYYY">
    </div>
    <div>
        <label for="numberDesk">Số bàn<i class="text-danger">*</i>: </label>
        <input type="number" id="numberDesk" name="numberDesk" onblur="numberDesk(this)">
    </div>
    <textarea class="form-control" id="description" placeholder="Nhập mô tả cho tiệc cưới..."></textarea>
    <div>
        <h4 class="text-success" id="amount">Tổng tiền: <span>${amount}</span> VNĐ</h4>
    </div>
     
    <input type="button" value="Thanh toán" class="btn btn-success" onclick="pay()"/>
    <br></br>
</c:if>
