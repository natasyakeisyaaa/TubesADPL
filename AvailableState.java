// class ini mewakili status buku yang tersedia
// kalau buku tersedia, maka buku boleh dipinjam

public class AvailableState implements BookState {

    @Override
    public boolean pinjam(Buku buku) {
        // kalau buku tersedia lalu dipinjam,
        // maka status buku berubah menjadi BorrowedState atau Dipinjam
        buku.setState(new BorrowedState());
        System.out.println("Buku berhasil dipinjam.");

        // return true artinya proses peminjaman berhasil
        return true;
    }

    @Override
    public boolean kembalikan(Buku buku) {
        // kalau buku sudah tersedia, artinya buku tidak sedang dipinjam
        // jadi tidak bisa diproses sebagai pengembalian
        System.out.println("Buku tidak sedang dipinjam, sehingga tidak dapat dikembalikan.");
        
        // return false artinya proses pengembalian gagal/tidak valid
        return false;
    }

    @Override
    public String getStatus() {
        // return nama status buku
        return "Tersedia";
    }
    
}
