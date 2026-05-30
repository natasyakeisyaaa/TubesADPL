import java.util.ArrayList;
import java.util.List;

// class ini adalah strategi pencarian berdasarkan pengarang buku
public class SearchByPengarang implements SearchStrategy {

    @Override
    public List<Buku> cari(List<Buku> daftarBuku, String kataKunci) {
        // menyimpan hasil buku yang pengarangnya cocok dengan kata kunci
        List<Buku> hasil = new ArrayList<>();

        // mengecheck semua buku dalam daftar
        for (Buku buku : daftarBuku) {
            // getPengarang() mengambil nama pengarang buku
            // pencarian dibuat tidak sensitif huruf besar/kecil
            if (buku.getPengarang().toLowerCase().contains(kataKunci.toLowerCase())) {
                hasil.add(buku); // buku yang cocok dimasukkan ke hasil
            }
        }

        // return hasil pencarian
        return hasil;
    }
    
}
