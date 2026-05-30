public class BukuFiksiFactory extends BukuFactory {

    public Buku buatBuku(String id, String judul, String pengarang, int tahunTerbit, String genre) {
        return new BukuFiksi(id, judul, pengarang, tahunTerbit, genre);
    }
}