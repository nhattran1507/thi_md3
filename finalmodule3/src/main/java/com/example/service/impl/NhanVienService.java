package com.example.service.impl;

import com.example.entity.NhanVien;
import com.example.repository.NhanVienRepository;
import com.example.service.INhanVienService;

import java.util.List;

public class NhanVienService implements INhanVienService {
    private final NhanVienRepository repository = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return repository.getAll();
    }

    @Override
    public void save(NhanVien nhanVien) {
        repository.save(nhanVien);
    }

    @Override
    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }

    @Override
    public boolean update(NhanVien nhanVien) {
        return repository.update(nhanVien);
    }
}
