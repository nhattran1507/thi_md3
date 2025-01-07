<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/7/2025
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm mới sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Thêm mới sản phẩm</h1>

    <form action="/sanpham" method="post" class="needs-validation" novalidate>
        <div class="mb-3">
            <label for="name" class="form-label">Name (*):</label>
            <input type="text" id="name" name="name" class="form-control" required>
            <div class="invalid-feedback">Please enter a product name.</div>
        </div>

        <div class="mb-3">
            <label for="price" class="form-label">Price (*):</label>
            <input type="number" id="price" name="price" class="form-control" min="101" required>
            <div class="invalid-feedback">Please enter a valid price (min 101).</div>
        </div>

        <div class="mb-3">
            <label for="discount" class="form-label">Discount (*):</label>
            <select id="discount" name="discount" class="form-select" required>
                <option value="5">5%</option>
                <option value="10">10%</option>
                <option value="15">15%</option>
                <option value="20">20%</option>
            </select>
            <div class="invalid-feedback">Please select a discount percentage.</div>
        </div>

        <div class="mb-3">
            <label for="stock" class="form-label">Stock (*):</label>
            <input type="number" id="stock" name="stock" class="form-control" min="11" required>
            <div class="invalid-feedback">Please enter a valid stock quantity (min 11).</div>
        </div>

        <button type="submit" class="btn btn-primary">Thêm</button>

        <p class="text-danger mt-3">
            <% String error = (String) request.getAttribute("error"); %>
            <%= error != null ? error : "" %>
        </p>
    </form>

    <a href="/sanpham" class="btn btn-secondary mt-3">Quay lại danh sách sản phẩm</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    (function () {
        'use strict'
        const forms = document.querySelectorAll('.needs-validation')
        Array.from(forms).forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }
                form.classList.add('was-validated')
            }, false)
        })
    })()
</script>
</body>
</html>
