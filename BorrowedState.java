// class ini mewakili status buku yang sedang dipinjam
public class BorrowedState implements BookState {

    @Override
    public boolean pinjam(Buku buku) {
        // kalau buku sedang dipinjam, buku tidak boleh dipinjam lagi
        System.out.println("Buku sedang dipinjam, tidak bisa dipinjam lagi.");
        
        // return false artinya proses peminjaman gagal
        return false;
    }

    @Override
    public boolean kembalikan(Buku buku) {
        // kalau buku yang sedang dipinjam dikembalikan,
        // statusnya berubah menjadi AvailableState atau Tersedia.
        buku.setState(new AvailableState());
        System.out.println("Buku berhasil dikembalikan.");
        
        // return true artinya proses pengembalian berhasil
        return true;
    }

    @Override
    public String getStatus() {
        // return nama status buku
        return "Dipinjam";
    }
    
}
