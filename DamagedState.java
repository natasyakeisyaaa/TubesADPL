// class ini mewakili status buku yang rusak
// buku rusak tidak boleh dipinjam
public class DamagedState implements BookState {

    @Override
    public boolean pinjam(Buku buku) {
        // kalau buku rusak, sistem menolak proses peminjaman
        System.out.println("Buku rusak, tidak bisa dipinjam.");
        
        // return false artinya peminjaman gagal
        return false;
    }

    @Override
    public boolean kembalikan(Buku buku) {
        // buku rusak tidak diproses sebagai pengembalian normal
        System.out.println("Buku rusak, tidak dapat diproses sebagai pengembalian normal.");
        
        // return false artinya pengembalian gagal/tidak valid
        return false;
    }

    @Override
    public String getStatus() {
        // return nama status buku
        return "Rusak";
    }
    
}
