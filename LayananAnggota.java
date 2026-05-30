import java.util.ArrayList;
import java.util.List;

/**
 * FACADE - Subsystem: LayananAnggota
 * Mengelola data anggota perpustakaan.
 */
public class LayananAnggota {
    private List<Anggota> daftarAnggota;

    public LayananAnggota() {
        daftarAnggota = new ArrayList<>();
    }

    public void daftarAnggota(Anggota anggota) {
        daftarAnggota.add(anggota);
    }

    public boolean hapusAnggota(String idAnggota) {
        for (int i = 0; i < daftarAnggota.size(); i++) {
            Anggota anggota = daftarAnggota.get(i);

            if (anggota.getId().equals(idAnggota)) {
                daftarAnggota.remove(i);
                return true;
            }
        }

        return false;
    }

    public Anggota getAnggota(String idAnggota) {
        for (int i = 0; i < daftarAnggota.size(); i++) {
            Anggota anggota = daftarAnggota.get(i);

            if (anggota.getId().equals(idAnggota)) {
                return anggota;
            }
        }

        return null;
    }

    public List<Anggota> getSemuaAnggota() {
        return new ArrayList<>(daftarAnggota);
    }

    public boolean isIdTerdaftar(String idAnggota) {
        for (int i = 0; i < daftarAnggota.size(); i++) {
            Anggota anggota = daftarAnggota.get(i);

            if (anggota.getId().equals(idAnggota)) {
                return true;
            }
        }

        return false;
    }
}