package com.example.service.impl;

import com.example.entity.SanPham;
import com.example.repository.SanPhamRepository;
import com.example.service.ISanPhamService;

import java.util.List;

public class SanPhamService implements ISanPhamService {
    private final SanPhamRepository repository = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return repository.getAll();
    }

    @Override
    public void save(SanPham sanPham) {
        repository.save(sanPham);
    }

    @Override
    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }

    @Override
    public boolean update(SanPham sanPham) {
        return repository.update(sanPham);
    }

    @Override
    public List<SanPham> getTopBanChay(int top) {
        return repository.getTopBanChay(top);
    }
}
