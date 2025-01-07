package com.example.service.impl;

import com.example.entity.KhachHang;
import com.example.repository.KhachHangRepository;
import com.example.service.IKhachHangService;

import java.util.List;

public class KhachHangService implements IKhachHangService {
    private final KhachHangRepository repository = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        return repository.getAll();
    }

    @Override
    public void save(KhachHang khachHang) {
        repository.save(khachHang);
    }

    @Override
    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }

    @Override
    public boolean update(KhachHang khachHang) {
        return repository.update(khachHang);
    }
}
