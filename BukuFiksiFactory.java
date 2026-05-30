public class BukuFiksiFactory extends BukuFactory {
    @Override
    public Buku buatDanDaftarkan(String id, String judul, String pengarang, int tahun, String genre) {
        Buku baru = new BukuFiksi(id, judul, pengarang, tahun, genre);
        System.out.println("Buku dibuat: [" + baru.getJudul() + "]");
        return baru;
    }
}