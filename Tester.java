
import java.util.LinkedList;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Perpustakaan perpus = Perpustakaan.getInstance();

        Scanner sc = new Scanner(System.in);

        System.out.println("Halo, selamat datang di Perpustakaan!");
        System.out.println("Pilih peran Anda (ketik 1 / 2)");
        System.out.println("1. Anggota");
        System.out.println("2. Pengurus");

        int role = sc.nextInt();

        if (role == 1) {
            System.out.println("Apakah anda sudah mendaftar sebelumnya? (ketik 1 / 2)");
            System.out.println("1. Sudah");
            System.out.println("2. Belum");

            int keanggotaan = sc.nextInt();

            if (keanggotaan == 2) {
                System.out.println("Masukkan beberapa data berikut :");
                System.out.print("Nama : ");
                String nama = sc.next();
                System.out.print("Tanggal lahir (hhmmyyyy) : ");
                String tanggalLahir = sc.next();
                System.out.print("No telpon : ");
                String noTelp = sc.next();
                System.out.print("Alamat : ");
                String alamat = sc.next();
                System.out.println();
                Anggota baru = new Anggota(nama, tanggalLahir, noTelp, alamat);
            }

            System.out.println("Apa yang anda ingin lakukan di Perpustakaan? (ketik 1 / 2)");
            System.out.println("1. Meminjam Buku");
            System.out.println("2. Mengembalikkan Buku");
        }
    }
}
