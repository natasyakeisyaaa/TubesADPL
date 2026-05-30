import java.util.List;

// interface ini tuh inti dari Strategy Pattern
// semua strategi pencarian buku wajib mengikuti bentuk method cari() di sini

public interface SearchStrategy {
    List<Buku> cari(List<Buku> daftarBuku, String kataKunci);
    // method cari() menerima daftar buku dan kata kunci pencarian
    // hasilnya berupa List<Buku>, yaitu daftar buku yang cocok dengan kata kunci
}