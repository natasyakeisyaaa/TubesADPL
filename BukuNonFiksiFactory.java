public class BukuNonFiksiFactory extends BukuFactory {
    @Override
    public Buku buatDanDaftarkan(String id, String judul, String pengarang, int tahun, String topik) {
        Buku baru = new BukuNonFiksi(id, judul, pengarang, tahun, topik);
        System.out.println("Buku dibuat: [" + baru.getJudul() + "]");
        return baru;
    }
}