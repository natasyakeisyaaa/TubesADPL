
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
* class untuk Merepresentasikan satu transaksi peminjaman buku.
 * Ide : Setiap objek Peminjaman menyimpan:
 * - ID transaksi
 * - ID anggota yang meminjam
 * - ID buku yang dipinjam
 * - Tanggal pinjam
 * - Tanggal jatuh tempo
 * - Tanggal kembali
 * 
 * Lama peminjaman = 7 hari dan denda = Rp1.000 per hari keterlambatan
 */

public class Peminjaman {

    //aturan peminjaman
    private static final int DURASI_HARI = 7;
    private static final int DENDA_PER_HARI = 1000;

    //data transaksi
    private String idTransaksi;
    private String idAnggota;
    private String idBuku;

    //tanggal peminjaman
    private LocalDate tanggalPinjam;
    private LocalDate tanggalJatuhTempo;
    private LocalDate tanggalKembali;

    
    public Peminjaman(String idTransaksi, String idAnggota, String idBuku) {
        this.idTransaksi = idTransaksi;
        this.idAnggota = idAnggota;
        this.idBuku = idBuku;

        this.tanggalPinjam = LocalDate.now();
        this.tanggalJatuhTempo = tanggalPinjam.plusDays(DURASI_HARI);
        this.tanggalKembali = null;
    }

    //Mengecek apakah transaksi masih aktif kalau Aktif berarti buku belum dikembalikan.
    public boolean isAktif() {

        if (tanggalKembali == null) {
            return true;
        }

        return false;
    }

    /**
     * Ide Menghitung denda saat ini.
     *
     * Alur:
     * 1. Jika buku sudah dikembalikan maka denda 0
     * 2. Ambil tanggal hari ini
     * 3. periksa apakah sudah melewati jatuh tempo
     * 4. Hitung jumlah hari terlambat
     * 5. Kalikan dengan denda per hari
     */
    public int hitungDenda() {

        if (!isAktif()) {
            return 0;
        }

        LocalDate hariIni = LocalDate.now();

        if (hariIni.isAfter(tanggalJatuhTempo)) {

            long keterlambatan =  ChronoUnit.DAYS.between(tanggalJatuhTempo, hariIni);
            
            return (int) keterlambatan * DENDA_PER_HARI;
        }

        return 0;
    }

    /**
     * Menandai buku telah dikembalikan.
     *
     * Tanggal kembali disimpan, menggunakan tanggal saat ini.
     */
    public void kembalikan() {

        this.tanggalKembali = LocalDate.now();
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public String getIdBuku() {
        return idBuku;
    }

    public LocalDate getTanggalPinjam() {
        return tanggalPinjam;
    }

    public LocalDate getJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public LocalDate getTanggalKembali() {
        return tanggalKembali;
    }

    /**
     * informasi transaksi.
     * akan terhubung dengan Berguna untuk menu:Riwayat Peminjaman
     */
    public void tampilInfo() {

        System.out.println("  Transaksi   : " + idTransaksi);
        System.out.println("  ID Anggota  : " + idAnggota);
        System.out.println("  ID Buku     : " + idBuku);
        System.out.println("  Tgl Pinjam  : " + tanggalPinjam);
        System.out.println("  Jatuh Tempo : " + tanggalJatuhTempo);

        if (isAktif()) {
            System.out.println("  Status      : Aktif");

        } else {

            System.out.println("  Status      : Dikembalikan (" +tanggalKembali +")");
        }

        if (isAktif() && hitungDenda() > 0) {
            System.out.println("  Denda       : Rp " +hitungDenda());
        }
    }
}