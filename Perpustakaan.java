
public class Perpustakaan {

    private static Perpustakaan instance;

    private Perpustakaan() {

    }

    public static Perpustakaan getInstance() {
        if (instance == null) {
            instance = new Perpustakaan();
        }

        return instance;
    }
}
