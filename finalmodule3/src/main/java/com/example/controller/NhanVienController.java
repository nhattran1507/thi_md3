package com.example.controller;

import com.example.entity.NhanVien;
import com.example.service.impl.NhanVienService;

import java.util.List;

public class NhanVienController {
    private final NhanVienService nhanVienService = new NhanVienService();

    public List<NhanVien> getAllNhanVien() {
        return nhanVienService.getAll();
    }

    public void addNhanVien(NhanVien nhanVien) {
        nhanVienService.save(nhanVien);
    }

    public boolean deleteNhanVien(int id) {
        return nhanVienService.deleteById(id);
    }

    public boolean updateNhanVien(NhanVien nhanVien) {
        return nhanVienService.update(nhanVien);
    }
}
