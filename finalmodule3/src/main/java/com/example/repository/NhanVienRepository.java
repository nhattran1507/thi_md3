package com.example.repository;

import com.example.entity.NhanVien;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {

    public List<NhanVien> getAll() {
        List<NhanVien> nhanViens = new ArrayList<>();
        String query = "SELECT * FROM nhan_vien";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tenNhanVien = resultSet.getString("ten_nhan_vien");
                Date ngaySinh = resultSet.getDate("ngay_sinh");
                String diaChi = resultSet.getString("dia_chi");

                nhanViens.add(new NhanVien(id, tenNhanVien, ngaySinh, diaChi));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching all NhanVien: " + e.getMessage(), e);
        }
        return nhanViens;
    }

    public void save(NhanVien nhanVien) {
        String query = "INSERT INTO nhan_vien (ten_nhan_vien, ngay_sinh, dia_chi) VALUES (?, ?, ?)";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nhanVien.getTenNhanVien());
            statement.setDate(2, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
            statement.setString(3, nhanVien.getDiaChi());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving NhanVien: " + e.getMessage(), e);
        }
    }

    public boolean deleteById(int id) {
        String query = "DELETE FROM nhan_vien WHERE id = ?";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting NhanVien: " + e.getMessage(), e);
        }
    }

    public boolean update(NhanVien nhanVien) {
        String query = "UPDATE nhan_vien SET ten_nhan_vien = ?, ngay_sinh = ?, dia_chi = ? WHERE id = ?";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nhanVien.getTenNhanVien());
            statement.setDate(2, new java.sql.Date(nhanVien.getNgaySinh().getTime()));
            statement.setString(3, nhanVien.getDiaChi());
            statement.setInt(4, nhanVien.getId());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating NhanVien: " + e.getMessage(), e);
        }
    }
}
