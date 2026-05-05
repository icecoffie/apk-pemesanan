package SoalPertemuan5.Dao;

import SoalPertemuan5.Koneksi.Koneksi;
import java.sql.*;
import java.util.*;
import SoalPertemuan5.Model.Menu;

public class MenuDAO {

    public List<Menu> getAllMenu() {
        List<Menu> list = new ArrayList<>();

        try {
            Connection conn = Koneksi.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM menu");

            while (rs.next()) {
                list.add(new Menu(
                    rs.getInt("id_menu"),
                    rs.getString("nama_menu"),
                    rs.getInt("harga")
                ));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
    public List<Menu> getMenuByKategori(String kategori) {
        List<Menu> list = new ArrayList<>();

        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement pst = conn.prepareStatement(
                "SELECT * FROM menu WHERE kategori=?"
            );
            pst.setString(1, kategori);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                list.add(new Menu(
                    rs.getInt("id_menu"),
                    rs.getString("nama_menu"),
                    rs.getInt("harga")
                ));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    public int getIdByNama(String nama) {
        int id = 0;

        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement pst = conn.prepareStatement(
                "SELECT id_menu FROM menu WHERE nama_menu=?"
            );
            pst.setString(1, nama);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id_menu");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public int getHargaByNama(String nama) {
        try {
            Connection conn = Koneksi.getConnection();
            PreparedStatement pst = conn.prepareStatement(
                "SELECT harga FROM menu WHERE nama_menu=?"
            );
            pst.setString(1, nama);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("harga");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}