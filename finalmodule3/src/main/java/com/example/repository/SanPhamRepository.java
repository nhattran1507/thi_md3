package com.example.repository;

import com.example.entity.SanPham;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {

    public List<SanPham> getAll() {
        List<SanPham> sanPhams = new ArrayList<>();
        String query = "SELECT * FROM san_pham";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idSanPham = resultSet.getInt("id");
                String tenSanPham = resultSet.getString("ten_san_pham");
                String giaSanPham = resultSet.getString("gia");
                String mucGiamGia = resultSet.getString("muc_giam_gia");
                String tonKho = resultSet.getString("ton_kho");

                sanPhams.add(new SanPham(idSanPham, tenSanPham, giaSanPham, mucGiamGia, tonKho));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching all SanPham", e);
        }
        return sanPhams;
    }

    public void save(SanPham sanPham) {
        String query = "INSERT INTO san_pham (ten_san_pham, gia, muc_giam_gia, ton_kho) VALUES (?, ?, ?, ?)";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, sanPham.getTenSanPham());
            statement.setString(2, sanPham.getGiaSanPham());
            statement.setString(3, sanPham.getMucGiamGia());
            statement.setString(4, sanPham.getTonKho());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving SanPham", e);
        }
    }

    public boolean deleteById(int idSanPham) {
        String query = "DELETE FROM san_pham WHERE id = ?";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idSanPham);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting SanPham", e);
        }
    }

    public boolean update(SanPham sanPham) {
        String query = "UPDATE san_pham SET ten_san_pham = ?, gia = ?, muc_giam_gia = ?, ton_kho = ? WHERE id = ?";
        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, sanPham.getTenSanPham());
            statement.setString(2, sanPham.getGiaSanPham());
            statement.setString(3, sanPham.getMucGiamGia());
            statement.setString(4, sanPham.getTonKho());
            statement.setInt(5, sanPham.getIdSanPham());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating SanPham", e);
        }
    }
    public List<SanPham> getTopBanChay(int top) {
        List<SanPham> sanPhams = new ArrayList<>();
        String sql = "SELECT sp.id, sp.ten_san_pham, sp.gia, sp.muc_giam_gia, sp.ton_kho, SUM(ctdh.so_luong) AS so_luong_dat " +
                "FROM san_pham sp " +
                "JOIN chi_tiet_don_hang ctdh ON sp.id = ctdh.san_pham_id " +
                "GROUP BY sp.id, sp.ten_san_pham, sp.gia, sp.muc_giam_gia, sp.ton_kho " +
                "ORDER BY so_luong_dat DESC " +
                "LIMIT ?";
        ;

        try (Connection connection = BaseRepository.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, top);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idSanPham = resultSet.getInt("id");
                String tenSanPham = resultSet.getString("ten_san_pham");
                String giaSanPham = resultSet.getString("gia");
                String mucGiamGia = resultSet.getString("muc_giam_gia");
                String tonKho = resultSet.getString("ton_kho");

                sanPhams.add(new SanPham(idSanPham, tenSanPham, giaSanPham, mucGiamGia, tonKho));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching top selling SanPham", e);
        }

        return sanPhams;
    }

}
