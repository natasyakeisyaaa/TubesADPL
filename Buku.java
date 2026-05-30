public class Buku {

    String judul; // atribut untuk menyimpan judul buku
    private BookState state; // atribut untuk menyimpan state/status saat ini

    public Buku(String judul) {
        this.judul = judul;
        this.state = new AvailableState(); // state awal otomatis "Tersedia"
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public BookState getState() {
        return state;
    }

    public void setState(BookState state) {
        this.state = state;
    }
}