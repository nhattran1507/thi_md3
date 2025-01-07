package com.example.entity;

public class SanPham {
    private int idSanPham;
    private String tenSanPham;
    private String giaSanPham;
    private String mucGiamGia;
    private String tonKho;

    public SanPham() {
    }

    public SanPham(int idSanPham, String tenSanPham, String giaSanPham, String mucGiamGia, String tonKho) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.mucGiamGia = mucGiamGia;
        this.tonKho = tonKho;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(String giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public String getMucGiamGia() {
        return mucGiamGia;
    }

    public void setMucGiamGia(String mucGiamGia) {
        this.mucGiamGia = mucGiamGia;
    }

    public String getTonKho() {
        return tonKho;
    }

    public void setTonKho(String tonKho) {
        this.tonKho = tonKho;
    }


    @Override
    public String toString() {
        return "SanPham{" +
                "idSanPham=" + idSanPham +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", giaSanPham='" + giaSanPham + '\'' +
                ", mucGiamGia='" + mucGiamGia + '\'' +
                ", tonKho='" + tonKho + '\'' +
                '}';
    }
}
