
public abstract class Buku {

    private String id;
    private String judul; // atribut untuk menyimpan judul buku
    private String pengarang;
    private int tahunTerbit;
    private String genre;
    private BookState state; // atribut untuk menyimpan state/status saat ini

    public Buku(String id, String judul, String pengarang, int tahunTerbit, String genre) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
        this.genre = genre;
        this.state = new AvailableState(); // state awal otomatis "Tersedia"
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public int getTahun() {
        return tahunTerbit;
    }

    public void setTahun(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public BookState getState() {
        return state;
    }

    public void setState(BookState state) {
        this.state = state;
    }

    public abstract void tampilInfo();
}
