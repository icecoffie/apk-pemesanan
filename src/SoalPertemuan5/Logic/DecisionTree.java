package SoalPertemuan5.Logic;

public class DecisionTree {

    public static String getRekomendasi(int total, int totalItem) {

        if (total > 50000) {
            if (totalItem > 3) {
                return "Status: Boros\nSaran:\n- Kurangi jumlah pesanan\n- Hindari pembelian berlebihan";
            } else {
                return "Status: Cukup Boros\nSaran:\n- Perhatikan pengeluaran";
            }
        } else {
            if (total < 20000) {
                return "Status: Hemat\nSaran:\n- Pertahankan pola ini 👍";
            } else {
                return "Status: Normal\nSaran:\n- Pengeluaran masih aman";
            }
        }
    }
}