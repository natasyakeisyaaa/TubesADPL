
import java.util.List;

/**
 * FACADE - Subsystem: LayananPencarian Menangani berbagai strategi pencarian
 * buku.
 */
public class LayananPencarian {

    public List<Buku> cariByJudul(List<Buku> koleksi, String query) {
        SearchByJudul cariJudul = new SearchByJudul();
        return cariJudul.cari(koleksi, query);
    }

    public List<Buku> cariByPengarang(List<Buku> koleksi, String query) {
        SearchByPengarang cariPengarang = new SearchByPengarang();
        return cariPengarang.cari(koleksi, query);
    }

    public List<Buku> cariByGenre(List<Buku> koleksi, String genre) {
        SearchByGenre cariGenre = new SearchByGenre();
        return cariGenre.cari(koleksi, genre);
    }

    // public List<Buku> cariByTipe(List<Buku> koleksi, String tipe) {
    //     List<Buku> hasil = new ArrayList<>();
    //     for (int i = 0; i < koleksi.size(); i++) {
    //         Buku buku = koleksi.get(i);
    //         if (buku.getTipe().equalsIgnoreCase(tipe)) {
    //             hasil.add(buku);
    //         }
    //     }
    //     return hasil;
    // }
    public List<Buku> cariByTahun(List<Buku> koleksi, String tahun) {
        SearchByTahun cariTahun = new SearchByTahun();
        return cariTahun.cari(koleksi, tahun);
    }
}
