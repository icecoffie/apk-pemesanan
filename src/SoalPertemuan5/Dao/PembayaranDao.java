package SoalPertemuan5.Dao;

import SoalPertemuan5.Koneksi.Koneksi;
import java.sql.*;

public class PembayaranDao {

    public void simpan(String meja, int total, int ppn, int bayar, int kembali) {
        try {
            Connection conn = Koneksi.getConnection();

            String sql = "INSERT INTO pembayaran (no_meja, total, ppn, bayar, kembali) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, meja);
            pst.setInt(2, total);
            pst.setInt(3, ppn);
            pst.setInt(4, bayar);
            pst.setInt(5, kembali);

            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error simpan pembayaran: " + e.getMessage());
        }
    }

    // 🔥 ambil total pendapatan dari semua transaksi
    public int getTotalPendapatan() {
        int total = 0;

        try {
            Connection conn = Koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(total) AS total FROM pembayaran");

            if (rs.next()) {
                total = rs.getInt("total");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return total;
    }
}