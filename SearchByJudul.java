import java.util.ArrayList;
import java.util.List;


// class ini salah satu implementasi StrategyPattern (implements)
// fungsinya untuk mencari buku berdasarkan judul

public class SearchByJudul implements SearchStrategy {

    @Override
    public List<Buku> cari(List<Buku> daftarBuku, String kataKunci) {
        // list hasil digunakan untuk menyimpan buku-buku yang cocok dengan pencarian
        List<Buku> hasil = new ArrayList<>();

        // loop untuk check satu per satu buku yang ada di daftarBuku
        for (Buku buku : daftarBuku) {
            // getJudul() mengambil judul dari buku
            // toLowerCase() dipakai supaya pencarian tidak sensitif huruf besar/kecil
            // contains() untuk check apakah judul buku mengandung kata kunci
            if (buku.getJudul().toLowerCase().contains(kataKunci.toLowerCase())) {
                hasil.add(buku); // kalau cocok, buku dimasukkan ke list hasil
            }
        }

        // return daftar buku yang cocok
        return hasil;
    }
    
}
