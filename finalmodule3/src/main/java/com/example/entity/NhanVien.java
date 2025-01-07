package com.example.entity;

import java.util.Date;

public class NhanVien {
    private int id;
    private String tenNhanVien;
    private Date ngaySinh;
    private String diaChi;

    public NhanVien() {
    }

    public NhanVien(int id, String tenNhanVien, Date ngaySinh, String diaChi) {
        this.id = id;
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }


    @Override
    public String toString() {
        return "NhanVien{" +
                "id=" + id +
                ", tenNhanVien='" + tenNhanVien + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
