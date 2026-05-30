
import java.util.List;

/**
 * FACADE : PerpustakaanFacade Menyederhanakan akses ke 4 subsistem:
 * LayananBuku, LayananAnggota, LayananPeminjaman, LayananPencarian
 */
public class Perpustakaan {

    //singleton
    private static Perpustakaan instance;

    //Subsystems
    private final LayananBuku layananBuku;
    private final LayananAnggota layananAnggota;
    private final LayananPeminjaman layananPeminjaman;
    private final LayananPencarian layananPencarian;

    //Factories (Factory Method)
    private final BukuFactory fiksiFactory;
    private final BukuFactory nonFiksiFactory;

    //Strategy
    private final SearchByGenre cariGenre;
    private final SearchByJudul cariJudul;
    private final SearchByPengarang cariPengarang;
    private final SearchByTahun cariTahun;

    private Perpustakaan() {
        this.layananBuku = new LayananBuku();
        this.layananAnggota = new LayananAnggota();
        this.layananPeminjaman = new LayananPeminjaman();
        this.layananPencarian = new LayananPencarian();
        this.fiksiFactory = new BukuFiksiFactory();
        this.nonFiksiFactory = new BukuNonFiksiFactory();
        this.cariGenre = new SearchByGenre();
        this.cariJudul = new SearchByJudul();
        this.cariPengarang = new SearchByPengarang();
        this.cariTahun = new SearchByTahun();
    }

    public static Perpustakaan getInstance() {
        if (instance == null) {
            instance = new Perpustakaan();
        }
        return instance;
    }

    //MANAJEMEN BUKU 
    //Menambah buku fiksi
    public void tambahBukuFiksi(String id, String judul, String pengarang, int tahun, String genre) {
        if (layananBuku.isIdTerdaftar(id)) {
            System.out.println("[Facade] ID buku sudah terdaftar: " + id);
            return;
        }
        Buku buku = fiksiFactory.buatDanDaftarkan(id, judul, pengarang, tahun, genre);
        layananBuku.tambahBuku(buku);
    }

    //Menambah buku nonfiksi
    public void tambahBukuNonFiksi(String id, String judul, String pengarang, int tahun, String topik, int edisi) {
        if (layananBuku.isIdTerdaftar(id)) {
            System.out.println("[Facade] ID buku sudah terdaftar: " + id);
            return;
        }
        Buku buku = nonFiksiFactory.buatDanDaftarkan(id, judul, pengarang, tahun, topik, String.valueOf(edisi));
        layananBuku.tambahBuku(buku);
    }

    public boolean hapusBuku(String idBuku) {
        if (layananPeminjaman.isBukuDipinjam(idBuku)) {
            System.out.println("[Facade] Buku sedang dipinjam, tidak bisa dihapus.");
            return false;
        }
        boolean ok = layananBuku.hapusBuku(idBuku);
        System.out.println(ok ? "[Facade] Buku dihapus." : "[Facade] ID buku tidak ditemukan.");
        return ok;
    }

    public void tampilkanSemuaBuku() {
        List<Buku> semua = layananBuku.getSemuaBuku();
        if (semua.isEmpty()) {
            System.out.println("  (Koleksi kosong)");
            return;
        }
        for (int i = 0; i < semua.size(); i++) {
            semua.get(i).tampilInfo();
        }
    }

    //MANAJEMEN ANGGOTA
    public Anggota daftarAnggota(String id, String nama, String tglLahir, String noTelp, String alamat) {
        if (layananAnggota.isIdTerdaftar(id)) {
            System.out.println("[Facade] ID anggota sudah terdaftar: " + id);
            return layananAnggota.getAnggota(id);
        }
        Anggota baru = new Anggota(id, nama, tglLahir, noTelp, alamat);
        layananAnggota.daftarAnggota(baru);
        System.out.println("[Facade] Anggota terdaftar: " + nama);

        return baru;
    }

    public Anggota cariAnggota(String id) {
        Anggota cari = layananAnggota.getAnggota(id);
        return cari;
    }

    public void tampilkanSemuaAnggota() {
        List<Anggota> semua = layananAnggota.getSemuaAnggota();
        if (semua.isEmpty()) {
            System.out.println("  (Belum ada anggota)");
            return;
        }
        for (int i = 0; i < semua.size(); i++) {
            semua.get(i).tampilInfo();
        }
    }

    //PEMINJAMAN & PENGEMBALIAN
    public void pinjamBuku(String idAnggota, String idBuku) {
        Anggota anggota = layananAnggota.getAnggota(idAnggota);
        Buku buku = layananBuku.getBuku(idBuku);

        if (anggota == null) {
            System.out.println("[Facade] Anggota tidak ditemukan.");
            return;
        }
        if (buku == null) {
            System.out.println("[Facade] Buku tidak ditemukan.");
            return;
        }

        layananPeminjaman.pinjam(idAnggota, buku);
    }

    public void kembalikanBuku(String idAnggota, String idBuku) {
        Anggota anggota = layananAnggota.getAnggota(idAnggota);
        Buku buku = layananBuku.getBuku(idBuku);

        if (anggota == null) {
            System.out.println("[Facade] Anggota tidak ditemukan.");
            return;
        }
        if (buku == null) {
            System.out.println("[Facade] Buku tidak ditemukan.");
            return;
        }

        layananPeminjaman.kembalikan(idAnggota, buku);
    }

    public void tampilkanRiwayat(String idAnggota) {
        Anggota anggota = layananAnggota.getAnggota(idAnggota);
        if (anggota == null) {
            System.out.println("[Facade] Anggota tidak ditemukan.");
            return;
        }

        System.out.println("=== Riwayat Peminjaman: " + anggota.getNama() + " ===");

        List<Peminjaman> riwayat = layananPeminjaman.getRiwayat(idAnggota);

        if (riwayat.isEmpty()) {
            System.out.println("  (Tidak ada riwayat)");
            return;
        }
        for (Peminjaman peminjaman : riwayat) {
            peminjaman.tampilInfo();
        }
    }

    public void cekDenda(String idAnggota) {
        Anggota anggota = layananAnggota.getAnggota(idAnggota);
        if (anggota == null) {
            System.out.println("[Facade] Anggota tidak ditemukan.");
            return;
        }

        int denda = layananPeminjaman.hitungTotalDenda(idAnggota);
        System.out.println("Denda " + anggota.getNama() + ": Rp " + denda);
    }

    //PENCARIAN
    public void cariBukuByJudul(String judul) {
        List<Buku> hasil = layananPencarian.cariByJudul(layananBuku.getSemuaBuku(), judul);

        tampilkanHasilCari("Judul mengandung '" + judul + "'", hasil);
    }

    public void cariBukuByPengarang(String query) {
        List<Buku> hasil = layananPencarian.cariByPengarang(layananBuku.getSemuaBuku(), query);

        tampilkanHasilCari("Pengarang '" + query + "'", hasil);
    }

    public void cariBukuByGenre(String genre) {
        List<Buku> hasil = layananPencarian.cariByGenre(layananBuku.getSemuaBuku(), genre);
        tampilkanHasilCari("Genre '" + genre + "'", hasil);
    }

    // public void cariBukuByTipe(String tipe) {
    //     List<Buku> hasil = layananPencarian.cariByTipe(layananBuku.getSemuaBuku(), tipe);
    //     tampilkanHasilCari("Tipe '" + tipe + "'", hasil);
    // }
    private void tampilkanHasilCari(String label, List<Buku> hasil) {
        System.out.println("=== Hasil Pencarian: " + label + " ===");
        if (hasil.isEmpty()) {
            System.out.println("  (Tidak ada hasil)");
            return;
        }
        for (Buku buku : hasil) {
            buku.tampilInfo();
        }
    }
}
