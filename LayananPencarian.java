import java.util.ArrayList;
import java.util.List;

/**
 * FACADE - Subsystem: LayananPencarian
 * Menangani berbagai strategi pencarian buku.
 */
public class LayananPencarian {

    public List<Buku> cariByJudul(List<Buku> koleksi, String query) {
        List<Buku> hasil = new ArrayList<>();
        String q = query.toLowerCase();

        for (int i = 0; i < koleksi.size(); i++) {
            Buku buku = koleksi.get(i);

            if (buku.getJudul().toLowerCase().contains(q)) {
                hasil.add(buku);
            }
        }

        return hasil;
    }

    public List<Buku> cariByPengarang(List<Buku> koleksi, String query) {
        List<Buku> hasil = new ArrayList<>();
        String q = query.toLowerCase();

        for (int i = 0; i < koleksi.size(); i++) {
            Buku buku = koleksi.get(i);

            if (buku.getPengarang().toLowerCase().contains(q)) {
                hasil.add(buku);
            }
        }

        return hasil;
    }

    public List<Buku> cariByGenre(List<Buku> koleksi, String genre) {
        List<Buku> hasil = new ArrayList<>();
        String q = genre.toLowerCase();

        for (int i = 0; i < koleksi.size(); i++) {
            Buku buku = koleksi.get(i);

            if (buku instanceof BukuFiksi) {
                BukuFiksi bukuFiksi = (BukuFiksi) buku;

                if (bukuFiksi.getGenre().toLowerCase().contains(q)) {
                    hasil.add(buku);
                }
            }
        }

        return hasil;
    }

    public List<Buku> cariByTipe(List<Buku> koleksi, String tipe) {
        List<Buku> hasil = new ArrayList<>();

        for (int i = 0; i < koleksi.size(); i++) {
            Buku buku = koleksi.get(i);

            if (buku.getTipe().equalsIgnoreCase(tipe)) {
                hasil.add(buku);
            }
        }

        return hasil;
    }

    public List<Buku> cariByTahun(List<Buku> koleksi, int tahun) {
        List<Buku> hasil = new ArrayList<>();

        for (int i = 0; i < koleksi.size(); i++) {
            Buku buku = koleksi.get(i);

            if (buku.getTahunTerbit() == tahun) {
                hasil.add(buku);
            }
        }

        return hasil;
    }
}