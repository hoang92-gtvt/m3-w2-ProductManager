<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 5/25/2021
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Product</title>
</head>
<body>

    <div>
        <h1>Form tạo mới một sản phẩm</h1>
        <a href="/products?action=home">Quay về trang chủ</a>

        <form method="post">
            <span>STT: <input name="id" type="text" size="15"/></span> <br>
            <span>Tên: <input name="name" type="text" size="15"/></span> <br>
            <span>Giá: <input name="price" type="text" size="15"/></span> <br>
            <span>Mô tả: <input name="description" type="text" size="15"/></span> <br>
            <span>Sản xuất: <input name="producer" type="text" size="15"/></span> <br>
            <button type="submit">Tạo mới</button>
        </form>

    </div>
</body>
</html>
