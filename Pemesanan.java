
import java.util.LinkedList;

public class Pemesanan extends PesanBuku {

    public LinkedList<Buku> daftarBukuSiap;

    public Pemesanan() {
        this.daftarBukuSiap = new LinkedList<>();
    }

    public void tambahBukuSiap(Buku bukuDipesan) {
        this.daftarBukuSiap.add(bukuDipesan);
        this.beritahuPemesan(bukuDipesan);
    }

    public LinkedList<Buku> getBuku() {
        return daftarBukuSiap;
    }
}
