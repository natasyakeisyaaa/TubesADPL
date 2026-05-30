
import java.util.LinkedList;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Perpustakaan perpus = Perpustakaan.getInstance();

        String status = "";

        while (!status.equals("Finish")) {
            //untuk pilih role
            System.out.println("Halo, selamat datang di Perpustakaan!");
            System.out.println("Pilih peran Anda (ketik 1 / 2)");
            System.out.println("1. Anggota");
            System.out.println("2. Pengurus");

            int role = sc.nextInt();

            //kalau role anggota
            if (role == 1) {
                System.out.println("Apakah anda sudah mendaftar sebelumnya? (ketik 1 / 2)");
                System.out.println("1. Sudah");
                System.out.println("2. Belum");

                int keanggotaan = sc.nextInt();
                Anggota userAnggota = null;

                if (keanggotaan == 1) {
                    System.out.print("Masukkan id penduduk anda :");
                    String id = sc.next();
                    userAnggota = perpus.cariAnggota(id);
                }

                if (userAnggota == null) {
                    System.out.println("Masukkan beberapa data berikut :");
                    System.out.println("Id Penduduk : ");
                    String id = sc.next();
                    System.out.print("Nama : ");
                    String nama = sc.next();
                    System.out.print("Tanggal lahir (hhmmyyyy) : ");
                    String tanggalLahir = sc.next();
                    System.out.print("No telpon : ");
                    String noTelp = sc.next();
                    System.out.print("Alamat : ");
                    String alamat = sc.next();
                    System.out.println();

                    userAnggota = perpus.daftarAnggota(id, nama, tanggalLahir, noTelp, alamat);
                }

                System.out.println("Apa yang anda ingin lakukan di Perpustakaan? (ketik 1 / 2 / 3)");
                System.out.println("1. Meminjam Buku");
                System.out.println("2. Mengembalikkan Buku");
                System.out.println("3. Mencari buku yang ada di Perpustakaan");

                int kegiatan = sc.nextInt();

                //kalau ingin meminjam buku
                if (kegiatan == 1) {
                    System.out.println("Masukan nama buku yang ingin dipinjam :");
                    perpus.pinjamBuku(userAnggota, s);
                }

            }
        }
    }

}
