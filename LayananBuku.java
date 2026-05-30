import java.util.ArrayList;
import java.util.List;

/**
 * FACADE - Subsystem: LayananBuku
 * Mengelola koleksi buku perpustakaan.
 */
public class LayananBuku {
    private List<Buku> koleksiBuku;

    public LayananBuku() {
        koleksiBuku = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        koleksiBuku.add(buku);
    }

    public boolean hapusBuku(String idBuku) {
        for (int i = 0; i < koleksiBuku.size(); i++) {
            Buku buku = koleksiBuku.get(i);

            if (buku.getId().equals(idBuku)) {
                koleksiBuku.remove(i);
                return true;
            }
        }

        return false;
    }

    public Buku getBuku(String idBuku) {
        for (int i = 0; i < koleksiBuku.size(); i++) {
            Buku buku = koleksiBuku.get(i);

            if (buku.getId().equals(idBuku)) {
                return buku;
            }
        }

        return null;
    }

    public List<Buku> getSemuaBuku() {
        List<Buku> hasil = new ArrayList<>();

        for (int i = 0; i < koleksiBuku.size(); i++) {
            hasil.add(koleksiBuku.get(i));
        }

        return hasil;
    }

    public boolean isIdTerdaftar(String idBuku) {
        for (int i = 0; i < koleksiBuku.size(); i++) {
            Buku buku = koleksiBuku.get(i);

            if (buku.getId().equals(idBuku)) {
                return true;
            }
        }

        return false;
    }
}