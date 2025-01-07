package com.example.repository;

import com.example.entity.KhachHang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {

    public List<KhachHang> getAll() {
        List<KhachHang> khachHangs = new ArrayList<>();
        String query = "SELECT * FROM khach_hang";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenKhachHang = resultSet.getString("ten_khach_hang");
                Date ngaySinh = resultSet.getDate("ngay_sinh");
                String dienThoai = resultSet.getString("dien_thoai");
                String diaChi = resultSet.getString("dia_chi");
                String email = resultSet.getString("email");

                khachHangs.add(new KhachHang(id, tenKhachHang, ngaySinh, dienThoai, diaChi, email));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching all KhachHang: " + e.getMessage(), e);
        }
        return khachHangs;
    }

    public void save(KhachHang khachHang) {
        String query = "INSERT INTO khach_hang (ten_khach_hang, ngay_sinh, dien_thoai, dia_chi, email) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, khachHang.getTenKhachHang());
            statement.setDate(2, new java.sql.Date(khachHang.getNgaySinh().getTime()));
            statement.setString(3, khachHang.getDienThoai());
            statement.setString(4, khachHang.getDiaChi());
            statement.setString(5, khachHang.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving KhachHang: " + e.getMessage(), e);
        }
    }

    public boolean deleteById(int id) {
        String query = "DELETE FROM khach_hang WHERE id = ?";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting KhachHang: " + e.getMessage(), e);
        }
    }

    public boolean update(KhachHang khachHang) {
        String query = "UPDATE khach_hang SET ten_khach_hang = ?, ngay_sinh = ?, dien_thoai = ?, dia_chi = ?, email = ? WHERE id = ?";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, khachHang.getTenKhachHang());
            statement.setDate(2, new java.sql.Date(khachHang.getNgaySinh().getTime()));
            statement.setString(3, khachHang.getDienThoai());
            statement.setString(4, khachHang.getDiaChi());
            statement.setString(5, khachHang.getEmail());
            statement.setInt(6, khachHang.getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating KhachHang: " + e.getMessage(), e);
        }
    }
}
