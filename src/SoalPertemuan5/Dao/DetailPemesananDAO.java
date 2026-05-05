package SoalPertemuan5.Dao;

import SoalPertemuan5.Koneksi.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DetailPemesananDAO {

    public void simpan(int idPemesanan, int idMenu, int jumlah, int subtotal) {
        try {
            Connection conn = Koneksi.getConnection();

            String sql = "INSERT INTO detail_pemesanan (id_pemesanan, id_menu, jumlah, subtotal) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setInt(1, idPemesanan);
            pst.setInt(2, idMenu);
            pst.setInt(3, jumlah);
            pst.setInt(4, subtotal);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}