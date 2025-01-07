package com.example.controller;

import com.example.entity.SanPham;
import com.example.service.ISanPhamService;
import com.example.service.impl.SanPhamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "sanPhamController", urlPatterns = "/")
public class SanPhamController extends HttpServlet {
    private static final ISanPhamService sanPhamService = new SanPhamService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("new".equals(action)) {
            req.getRequestDispatcher("/WEB-INF/view/addsanpham.jsp").forward(req, resp);
        } else if ("top".equals(action)) {

            String topParam = req.getParameter("top");
            int top = 3;
            if (topParam != null && !topParam.isEmpty()) {
                try {
                    top = Integer.parseInt(topParam);
                } catch (NumberFormatException e) {
                    req.setAttribute("error", "Số lượng top phải là số hợp lệ.");
                }
            }


            req.setAttribute("sanPhams", sanPhamService.getTopBanChay(top));
            req.getRequestDispatcher("/WEB-INF/view/sanphamlist.jsp").forward(req, resp);
        } else {
            req.setAttribute("sanPhams", sanPhamService.getAll());
            req.getRequestDispatcher("/WEB-INF/view/sanphamlist.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String priceStr = req.getParameter("price");
        String discount = req.getParameter("discount");
        String stockStr = req.getParameter("stock");

        String errorMessage = validateInput(name, priceStr, discount, stockStr);

        if (errorMessage != null) {
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("/WEB-INF/view/addsanpham.jsp").forward(req, resp);
        } else {
            double price = Double.parseDouble(priceStr);
            int stock = Integer.parseInt(stockStr);

            SanPham sanPham = new SanPham();
            sanPham.setTenSanPham(name);
            sanPham.setGiaSanPham(String.valueOf(price));
            sanPham.setMucGiamGia(discount);
            sanPham.setTonKho(String.valueOf(stock));

            sanPhamService.save(sanPham);
            resp.sendRedirect("/sanpham");
        }
    }

    private String validateInput(String name, String priceStr, String discount, String stockStr) {
        if (name == null || name.trim().isEmpty()) {
            return "Name is required.";
        }

        if (priceStr == null || priceStr.trim().isEmpty()) {
            return "Price is required.";
        }

        try {
            double price = Double.parseDouble(priceStr);
            if (price <= 100) {
                return "Price must be greater than 100.";
            }
        } catch (NumberFormatException e) {
            return "Price must be a valid number.";
        }

        if (!"5".equals(discount) && !"10".equals(discount) && !"15".equals(discount) && !"20".equals(discount)) {
            return "Discount must be one of the following values: 5%, 10%, 15%, 20%.";
        }

        if (stockStr == null || stockStr.trim().isEmpty()) {
            return "Stock is required.";
        }

        try {
            int stock = Integer.parseInt(stockStr);
            if (stock <= 10) {
                return "Stock must be greater than 10.";
            }
        } catch (NumberFormatException e) {
            return "Stock must be a valid number.";
        }

        return null;
    }
}
