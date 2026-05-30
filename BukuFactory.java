public abstract class BukuFactory {

    public Buku buatDanDaftarkan(Buku buku) {
        System.out.println("Buku dibuat: [" + buku.getTipe() + "] " + buku.getJudul());
        return buku;
    }
}