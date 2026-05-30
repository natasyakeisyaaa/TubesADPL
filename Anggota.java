
import java.util.LinkedList;

public class Anggota extends User implements Notifikasi {

    private String nama;
    private String tanggalLahir;
    private String noTelp;
    private String alamat;
    private String id;
    private Pemesanan pinjamBuku;

    public Anggota(String id, String nama, String tanggalLahir, String noTelp, String alamat) {
        super(nama, id, noTelp);
        this.tanggalLahir = tanggalLahir;
    }

    public void tampilInfo() {
        System.out.println("----------------------------------");
        System.out.println("ID            : " + id);
        System.out.println("Nama          : " + nama);
        System.out.println("Tanggal lahir : " + tanggalLahir);
        System.out.println("No telpon     : " + noTelp);
        System.out.println("Alamat        : " + alamat);
        System.out.println("----------------------------------");
    }

    public void bukuTersedia() {
        LinkedList<Buku> daftarBukuSedia = this.pinjamBuku.getBuku();

        for (Buku buku : daftarBukuSedia) {
            System.out.println("Halo " + this.nama + "! Buku " + buku.judul + " sudah siap dipinjam");
        }

    }

}
