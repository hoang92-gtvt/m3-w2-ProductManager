<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 5/25/2021
  Time: 5:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Edit Product</title>


</head>
<body>
    <div>
        <h1>Form Edit Product</h1>
        <a href="products?action=home">Quay trở về trang chủ</a>
        <form method ="post">
<%--        <span>STT<input type="text" name="id" value="${product.id}"/></span><br>--%>
        <span>Tên<input type="text" name="name" value="${product.name}"/></span><br>
        <span>Giá<input type="text" name="price" value="${product.price}"/></span><br>
        <span>Mô Tả<input type="text" name="description" value="${product.description}"/></span><br>
        <span>Sản Xuất<input type="text" name="producer" value="${product.producer}"/></span><br>

        <button type="submit">Update</button>
        </form>
    </div>

</body>
</html>
