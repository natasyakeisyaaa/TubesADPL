// interface ini adalah inti dari State Pattern
// semua status buku wajib memiliki aturan pinjam, kembalikan, getStatus

public interface BookState {
    boolean pinjam(Buku buku); // method ini mengatur apa yang terjadi saat buku dipinjam
    boolean kembalikan(Buku buku); // method ini mengatur apa yang terjadi saat buku dikembalikan
    String getStatus(); // method ini mengembalikan nama status buku
}