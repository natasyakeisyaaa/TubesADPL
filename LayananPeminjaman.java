import java.util.ArrayList;
import java.util.List;

/**
 * FACADE - Subsystem: LayananPeminjaman
 * Mengelola transaksi pinjam & kembali, serta perhitungan denda.
 */
public class LayananPeminjaman {
    private List<Peminjaman> daftarPeminjaman;
    private int idCounter = 1;

    public LayananPeminjaman() {
        daftarPeminjaman = new ArrayList<>();
    }

    public boolean pinjam(String idAnggota, Buku buku) {
        if (!buku.getState().pinjam(buku)) {
            System.out.println("[Peminjaman] Buku '" + buku.getJudul() + "' sedang dipinjam.");
            return false;
        }

        String idTrx = String.format("TRX%03d", idCounter++);

        Peminjaman peminjaman = new Peminjaman(idTrx, idAnggota, buku.getId());

        daftarPeminjaman.add(peminjaman);
        buku.setState(new BorrowedState());

        System.out.println("[Peminjaman] Berhasil! ID Transaksi: " + idTrx);
        return true;
    }

    public boolean kembalikan(String idAnggota, Buku buku) {
        Peminjaman aktif = getPeminjamanAktif(idAnggota, buku.getId());

        if (aktif == null) {
            System.out.println("[Peminjaman] Tidak ditemukan peminjaman aktif.");
            return false;
        }

        int denda = aktif.hitungDenda();

        aktif.kembalikan();
        buku.getState().kembalikan(buku);

        if (denda > 0) {
            System.out.println("[Peminjaman] Buku dikembalikan. Denda: Rp " + denda);
        } else {
            System.out.println("[Peminjaman] Buku dikembalikan. Tidak ada denda.");
        }

        return true;
    }

    public int hitungTotalDenda(String idAnggota) {
        int totalDenda = 0;

        for (int i = 0; i < daftarPeminjaman.size(); i++) {
            Peminjaman p = daftarPeminjaman.get(i);

            if (p.getIdAnggota().equals(idAnggota) && p.isAktif()) {
                totalDenda += p.hitungDenda();
            }
        }

        return totalDenda;
    }

    public List<Peminjaman> getRiwayat(String idAnggota) {
        List<Peminjaman> riwayat = new ArrayList<>();

        for (int i = 0; i < daftarPeminjaman.size(); i++) {
            Peminjaman p = daftarPeminjaman.get(i);

            if (p.getIdAnggota().equals(idAnggota)) {
                riwayat.add(p);
            }
        }

        return riwayat;
    }

    public boolean isBukuDipinjam(String idBuku) {
        for (int i = 0; i < daftarPeminjaman.size(); i++) {
            Peminjaman p = daftarPeminjaman.get(i);

            if (p.getIdBuku().equals(idBuku) && p.isAktif()) {
                return true;
            }
        }

        return false;
    }

    private Peminjaman getPeminjamanAktif(String idAnggota, String idBuku) {
        for (int i = 0; i < daftarPeminjaman.size(); i++) {
            Peminjaman p = daftarPeminjaman.get(i);

            if (p.getIdAnggota().equals(idAnggota) && p.getIdBuku().equals(idBuku) && p.isAktif()) {
                return p;
            }
        }

        return null;
    }
}