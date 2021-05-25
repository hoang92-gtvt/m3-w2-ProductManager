<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 5/25/2021
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
    <h1>Danh sách sản phẩm</h1>
    <table border="1" cellspacing="0px" cellpadding="0.5px">
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Giá</th>
            <th>Mô Tả</th>
            <th>Sản Xuất</th>

            <th>Cập nhật</th>
            <th>Xóa</th>
            <th>Chi tiết</th>
        </tr>
        <c:forEach items="${dssp}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td>${product.producer}</td>
                <td><a href="products?action=update">edit</a></td>
                <td><a href="products?action=delete">delele</a></td>
                <td><a href="products?action=detail">detail</a></td>
            </tr>

        </c:forEach>
        <div><a href="/products?action=create">Thêm sản phẩm</a></div>
    </table>
</body>
</html>
