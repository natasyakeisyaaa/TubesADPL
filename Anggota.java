
public class Anggota implements Notifikasi {

    private String nama;
    private String tanggalLahir;
    private String noTelp;
    private String alamat;
    private Pemesanan pinjamBuku;

    public Anggota(String nama, String tanggalLahir, String noTelp, String alamat) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }

    public void bukuTersedia() {
        LinkedList<Buku> daftarBukuSedia = this.pinjamBuku.getBuku();
        for (Buku buku : daftarBukuSedia) {
            System.out.println("Halo " + this.nama + "! Buku " + buku.judul + " sudah siap dipinjam");
        }

    }

}
