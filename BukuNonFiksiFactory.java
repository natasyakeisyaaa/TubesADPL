public class BukuNonFiksiFactory extends BukuFactory {

    public Buku buatBuku(String id, String judul, String pengarang, int tahunTerbit, String topik, int edisi) {
        return new BukuNonFiksi(id, judul, pengarang, tahunTerbit, topik, edisi);
    }
}