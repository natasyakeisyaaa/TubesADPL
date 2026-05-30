
import java.util.LinkedList;

public abstract class PesanBuku {

    private LinkedList<Anggota> pemesanBuku;

    public PesanBuku() {
        this.pemesanBuku = new LinkedList<>();
    }

    public void pesanBuku(Anggota pemesan) {
        pemesanBuku.add(pemesan);
    }

    public void batalPesan(Anggota pemesan) {
        pemesanBuku.remove(pemesan);
    }

    public void beritahuPemesan() {
        for (Anggota pemesan : pemesanBuku) {
            pemesan.bukuTersedia();
        }
    }
}
