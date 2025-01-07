<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/7/2025
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Danh sách sản phẩm bán chạy</h2>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Tên sản phẩm</th>
    <th>Giá</th>
    <th>Mức giảm giá</th>
    <th>Tồn kho</th>
    <th>Số lượng đặt</th>
  </tr>
  <c:forEach var="sp" items="${topSanPham}">
    <tr>
      <td>${sp.id}</td>
      <td>${sp.tenSanPham}</td>
      <td>${sp.gia}</td>
      <td>${sp.mucGiamGia}</td>
      <td>${sp.tonKho}</td>
      <td>${sp.soLuongDat}</td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
