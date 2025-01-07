package com.example.controller;

import com.example.entity.KhachHang;
import com.example.service.impl.KhachHangService;

import java.util.List;

public class KhachHangController {
    private final KhachHangService khachHangService = new KhachHangService();

    public List<KhachHang> getAllKhachHang() {
        return khachHangService.getAll();
    }

    public void addKhachHang(KhachHang khachHang) {
        khachHangService.save(khachHang);
    }

    public boolean deleteKhachHang(int id) {
        return khachHangService.deleteById(id);
    }

    public boolean updateKhachHang(KhachHang khachHang) {
        return khachHangService.update(khachHang);
    }
}
