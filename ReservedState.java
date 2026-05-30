// class ini mewakili status buku yang sedang dipesan
// buku yang dipesan tidak bisa langsung dipinjam oleh sembarang anggota
public class ReservedState implements BookState {

    @Override
    public boolean pinjam(Buku buku) {
        // kalau buku sedang dipesan, sistem menolak peminjaman langsung
        System.out.println("Buku sedang dipinjam, tidak bisa dipinjam langsung.");
        
        // return false artinya proses peminjaman gagal
        return false;
    }

    @Override
    public boolean kembalikan(Buku buku) {
        // status dipesan bukan status sedang dipinjam
        // jadi pengembalian normal tidak dapat dilakukan
        System.out.println("Buku masih dalam status dipesan.");
        
        // return false artinya proses pengembalian gagal
        return false;
    }

    @Override
    public String getStatus() {
        // return nama status buku
        return "Dipesan";
    }

}