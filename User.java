
public abstract class User {

    private String nama;
    private String id;
    private String noTelp;

    public User(String nama, String id, String noTelp) {
        this.nama = nama;
        this.id = id;
        this.noTelp = noTelp;
    }

    public String getNama() {
        return this.nama;
    }

    public String getId() {
        return this.id;
    }

    public String getNoTelp() {
        return this.noTelp;
    }
}
