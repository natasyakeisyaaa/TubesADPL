
import java.util.HashMap;
import java.util.LinkedList;

public abstract class BukuDipesan {

    private HashMap<Buku, LinkedList<Anggota>> daftarPesanan;

    public BukuDipesan() {
        daftarPesanan = new HashMap<>();
    }

    public void pesanBuku(Buku pesanan, Anggota pemesan) {
        if (!daftarPesanan.containsKey(pesanan)) {
            LinkedList<Anggota> daftarPemesanBuku = new LinkedList<>();
            daftarPemesanBuku.add(pemesan);
            daftarPesanan.put(pesanan, daftarPemesanBuku);
        } else {
            LinkedList<Anggota> daftarPemesanBuku = daftarPesanan.get(pesanan);
            daftarPemesanBuku.add(pemesan);
            daftarPesanan.put(pesanan, daftarPemesanBuku);
        }
    }

    public void batalPesan(Anggota pemesan) {
        if (!daftarPesanan.containsKey(pesanan)) {
            return;
        } else {
            LinkedList<Anggota> daftarPemesanBuku = daftarPesanan.get(pesanan);
            daftarPemesanBuku.remove(pemesan);
            daftarPesanan.put(pesanan, daftarPemesanBuku);
        }
    }

    public void beritahuPemesan(Buku bukuSiap) {
        LinkedList<Anggota> anggotaPemesan = daftarPesanan.get(bukuSiap);
        for (Anggota pemesan : anggotaPemesan) {
            pemesan.bukuTersedia();
        }
    }
}
