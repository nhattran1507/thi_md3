<%@ page import="com.example.entity.SanPham" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh sách sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Danh sách sản phẩm</h1>

    <div class="d-flex justify-content-between align-items-center mb-4">
        <!-- Link thêm mới sản phẩm -->
        <a href="/sanpham?action=new" class="btn btn-primary">Thêm mới</a>

        <!-- Form hiển thị top sản phẩm -->
        <form action="/sanpham" method="get" class="d-flex align-items-center">
            <input type="hidden" name="action" value="top">
            <label for="top-products" class="form-label me-2">Danh sách top:</label>
            <select name="top" id="top-products" class="form-select w-auto me-2">
                <option value="3">3</option>
                <option value="5">5</option>
                <option value="10">10</option>
            </select>
            <button type="submit" class="btn btn-outline-primary">Xem</button>
        </form>

        <!-- Form lọc sản phẩm theo ngày -->
        <form action="/sanpham" method="get" class="d-flex align-items-center">
            <input type="hidden" name="action" value="filterByDate">
            <label for="from-date" class="form-label me-2">Danh sách sản phẩm được đặt từ:</label>
            <input id="from-date" name="fromDate" type="date" class="form-control w-auto me-2">
            <label for="to-date" class="form-label me-2">đến:</label>
            <input id="to-date" name="toDate" type="date" class="form-control w-auto me-2">
            <button type="submit" class="btn btn-outline-primary">Xem</button>
        </form>
    </div>

    <!-- Bảng hiển thị danh sách sản phẩm -->
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Price</th>
            <th>Discount</th>
            <th>Stock</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <% List<SanPham> sanPhams = (List<com.example.entity.SanPham>) request.getAttribute("sanPhams"); %>
        <% if (sanPhams != null && !sanPhams.isEmpty()) { %>
        <% int index = 1; %>
        <% for (com.example.entity.SanPham sanPham : sanPhams) { %>
        <tr>
            <td><%= index++ %></td>
            <td><%= sanPham.getTenSanPham() %></td>
            <td><%= sanPham.getGiaSanPham() %></td>
            <td><%= sanPham.getMucGiamGia() %> %</td>
            <td><%= sanPham.getTonKho() %></td>
            <td>
                <a href="/sanpham?action=edit&id=<%= sanPham.getIdSanPham() %>" class="btn btn-sm btn-warning">Edit</a>
                <a href="/sanpham?action=delete&id=<%= sanPham.getIdSanPham() %>" class="btn btn-sm btn-danger" onclick="return confirm('Bạn có chắc muốn xóa không?');">Delete</a>
            </td>
        </tr>
        <% } %>
        <% } else { %>
        <tr>
            <td colspan="6" class="text-center">Không có sản phẩm nào.</td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
