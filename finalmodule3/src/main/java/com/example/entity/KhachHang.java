package com.example.entity;

import java.util.Date;

public class KhachHang {
    private int id;
    private String tenKhachHang;
    private Date ngaySinh;
    private String dienThoai;
    private String diaChi;
    private String email;

    public KhachHang() {
    }

    public KhachHang(int id, String tenKhachHang, Date ngaySinh, String dienThoai, String diaChi, String email) {
        this.id = id;
        this.tenKhachHang = tenKhachHang;
        this.ngaySinh = ngaySinh;
        this.dienThoai = dienThoai;
        this.diaChi = diaChi;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "id=" + id +
                ", tenKhachHang='" + tenKhachHang + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", dienThoai='" + dienThoai + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
