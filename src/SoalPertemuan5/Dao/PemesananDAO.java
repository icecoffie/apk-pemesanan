/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SoalPertemuan5.Dao;

import SoalPertemuan5.Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class PemesananDAO {

    public int simpan(String nama, String meja, int total) {
        int id = 0;

        try {
            Connection conn = Koneksi.getConnection();

            String sql = "INSERT INTO pemesanan (nama_pelanggan, tanggal, total) VALUES (?, NOW(), ?)";
            PreparedStatement pst;
            pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, nama + " (Meja " + meja + ")");
            pst.setInt(2, total);

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1); 
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return id;
    }
}