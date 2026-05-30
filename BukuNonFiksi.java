
/**
 * FACTORY METHOD - Concrete Product (Fiksi)
 * class ini untuk implementasi Buku untuk kategori Fiksi.
 */
public class BukuNonFiksi extends Buku {

    public BukuNonFiksi(String id, String judul, String pengarang, int tahunTerbit, String topik) {
        super(id, judul, pengarang, tahunTerbit, topik);
    }

    // @Override
    // public String getId() {
    //     return id;
    // }

    // @Override
    // public String getJudul() {
    //     return judul;
    // }

    // @Override
    // public String getPengarang() {
    //     return pengarang;
    // }

    // @Override
    // public int getTahunTerbit() {
    //     return tahunTerbit;
    // }

    // @Override
    // public String getTipe() {
    //     return "NonFiksi";
    // }

    // @Override
    // public boolean isAvailable() {
    //     return available;
    // }

    // @Override
    // public void setAvailable(boolean available) {
    //     this.available = available;
    // }

    // public String getTopik() {
    //     return topik;
    // }

    @Override
    public void tampilInfo() {

        System.out.println("----------------------------------");
        System.out.println("ID          : " + this.getId());
        System.out.println("Judul       : " + this.getJudul());
        System.out.println("Pengarang   : " + this.getPengarang());
        System.out.println("Tahun       : " + this.getTahun());
        System.out.println("Topik       : " + this.getGenre());
        System.out.println("Status      : " + this.getState().getStatus());
        System.out.println("----------------------------------");
    }
}
