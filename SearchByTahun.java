import java.util.ArrayList;
import java.util.List;

// class ini adalah strategi pencarian berdasarkan tahun terbit buku
public class SearchByTahun implements SearchStrategy {

    @Override
    public List<Buku> cari(List<Buku> daftarBuku, String kataKunci) {
        // list untuk menyimpan buku yang tahun terbitnya cocok
        List<Buku> hasil = new ArrayList<>();

        // check setiap buku di daftar
        for (Buku buku : daftarBuku) {
            // getTahun() menghasilkan int, misalnya 2020
            // String.valueOf() mengubah int menjadi String supaya bisa dibandingkan dengan kataKunci
            if (String.valueOf(buku.getTahun()).equals(kataKunci)) {
                hasil.add(buku); // kalau tahun sama persis dengan kata kunci, buku dimasukkan ke hasil
            }
        }

        // return hasil pencarian
        return hasil;
    }
    
}
