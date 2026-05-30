import java.util.ArrayList;
import java.util.List;

// class ini adalah strategi pencarian berdasarkan genre buku
public class SearchByGenre implements SearchStrategy {

    @Override
    public List<Buku> cari(List<Buku> daftarBuku, String kataKunci) {
        // list untuk menyimpan buku yang genrenya sesuai
        List<Buku> hasil = new ArrayList<>();

        // check setiap buku
        for (Buku buku : daftarBuku) {
            // getGenre() mengambil genre buku
            // contains() digunakan supaya keyword tidak harus sama persis
            if (buku.getGenre().toLowerCase().contains(kataKunci.toLowerCase())) {
                hasil.add(buku); // kalau genre cocok, buku dimasukkan ke hasil
            }
        }

        // return daftar buku yang cocok
        return hasil;
    }
}
