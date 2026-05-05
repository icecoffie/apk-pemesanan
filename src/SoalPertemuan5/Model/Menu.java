package SoalPertemuan5.Model;

public class Menu {

    private int id;
    private String nama;
    private int harga;

    // Constructor
    public Menu(int id, String nama, int harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }
}