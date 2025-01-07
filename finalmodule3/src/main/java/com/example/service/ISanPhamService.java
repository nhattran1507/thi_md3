package com.example.service;

import com.example.entity.SanPham;

import java.util.List;

public interface ISanPhamService extends IService<SanPham> {
    List<SanPham> getTopBanChay(int top);
}
