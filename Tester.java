
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Perpustakaan perpus = Perpustakaan.getInstance();

        String status = "";

        while (!status.equals("Finish")) {
            //untuk pilih role
            System.out.println("Halo, selamat datang di Perpustakaan!");
            System.out.println("Pilih peran Anda (ketik 1 / 2 / 0)");
            System.out.println("1. Anggota");
            System.out.println("2. Pengurus");
            System.out.println("0. Keluar");

            int role = Integer.parseInt(sc.nextLine());
            if (role==0) {
                status="Finish";
                break;
            }
            //kalau role anggota
            else if (role == 1) {
                System.out.println("Apakah anda sudah mendaftar sebelumnya? (ketik 1 / 2)");
                System.out.println("1. Sudah");
                System.out.println("2. Belum");

                int keanggotaan = Integer.parseInt(sc.nextLine());
                Anggota userAnggota = null;

                if (keanggotaan == 1) {
                    System.out.print("Masukkan id penduduk anda :");
                    String id = sc.nextLine();
                    userAnggota = perpus.cariAnggota(id);
                }

                if (userAnggota == null) {
                    System.out.println("Masukkan beberapa data berikut :");
                    System.out.print("Id Penduduk : ");
                    String id = sc.nextLine();
                    System.out.print("Nama : ");
                    String nama = sc.nextLine();
                    System.out.print("Tanggal lahir (hhmmyyyy) : ");
                    String tanggalLahir = sc.nextLine();
                    System.out.print("No telpon : ");
                    String noTelp = sc.nextLine();
                    System.out.print("Alamat : ");
                    String alamat = sc.nextLine();
                    System.out.println();

                    userAnggota = perpus.daftarAnggota(id, nama, tanggalLahir, noTelp, alamat);
                }

                boolean finish = false;

                while (!finish) {
                    System.out.println();
                    System.out.println("Apa yang anda ingin lakukan di Perpustakaan? (ketik 1 / 2 / 3 / 4)");
                    System.out.println("1. Meminjam Buku");
                    System.out.println("2. Mengembalikkan Buku");
                    System.out.println("3. Mencari buku yang ada di Perpustakaan");
                    System.out.println("4. Keluar");

                    int kegiatan = Integer.parseInt(sc.nextLine());

                    //kalau ingin meminjam buku
                    if (kegiatan == 1) {
                        System.out.println("Masukan judul buku yang ingin dipinjam :");
                        String judul = sc.nextLine();
                        System.out.println("Catat id buku yang ingin dipinjam");
                        perpus.cariBukuByJudul(judul);

                        System.out.println("Masukan id buku yang ingin dipinjam :");
                        String id = sc.nextLine();
                        Buku buku = perpus.pinjamBuku(userAnggota.getId(), id);

                        if (buku != null) {
                            System.out.println("Buku berhasil dipinjam");
                        } else {
                            System.out.println("Apakah kamu ingin memesan buku? (ketik 1 untuk Ya /2 untuk Tidak)");
                            int pesan = Integer.parseInt(sc.nextLine());

                            if (pesan == 1) {
                                perpus.pesanBuku(buku, userAnggota);
                            }
                            continue;
                        }
                    } else if (kegiatan == 2) {
                        System.out.println("Masukan judul buku yang ingin dikembalikkan :");
                        String judul = sc.nextLine();
                        System.out.println("Catat id buku yang ingin dikembalikkan");
                        perpus.cariBukuByJudul(judul);

                        System.out.println("Masukan id buku yang ingin dikembalikkan :");
                        String id = sc.nextLine();
                        Buku buku = perpus.kembalikanBuku(userAnggota.getId(), id);
                    } else if (kegiatan == 3) {
                        System.out.println("Cari berdasarkan : (ketik 1 / 2 / 3 / 4 / 5)");
                        System.out.println("1. Judul");
                        System.out.println("2. Genre");
                        System.out.println("3. Pengarang");
                        System.out.println("4. Tahun Terbit");
                        System.out.println("5. Semua buku");

                        int cariBy = Integer.parseInt(sc.nextLine());

                        if (cariBy==5) {
                            perpus.tampilkanSemuaBuku();
                        } else {
                            System.out.println("Masukkan kata kunci :");
                            String kataKunci = sc.nextLine();

                            if (cariBy == 1) {
                                perpus.cariBukuByJudul(kataKunci);
                            } else if (cariBy == 2) {
                                perpus.cariBukuByGenre(kataKunci);
                            } else if (cariBy == 3) {
                                perpus.cariBukuByPengarang(kataKunci);
                            } else if (cariBy == 4) {
                                perpus.cariBukuByTahun(kataKunci);
                            } 
                        }

                        
                    } else if (kegiatan == 4) {
                        finish = true;
                    } else {
                        System.out.println("Coba lagi, pilihan tidak valid");
                    }
                }
            }
            else if(role==2) {
                boolean finish = false;
                while (!finish) {
                    System.out.println();
                    System.out.println("Apa yang anda ingin lakukan di Perpustakaan? (ketik 1 / 2 / 3 / 4)");
                    System.out.println("1. Menambah Buku");
                    System.out.println("2. Menghapus Buku");
                    System.out.println("3. Mencari buku yang ada di Perpustakaan");
                    System.out.println("4. Menampilkan semua anggota yang terdaftar");
                    System.out.println("5. Keluar");

                    int kegiatan = Integer.parseInt(sc.nextLine());

                    if(kegiatan==1) {
                        System.out.println("Apa tipe buku yang ingin ditambahkan? (ketik 1 / 2)");
                        System.out.println("1. Fiksi");
                        System.out.println("2. NonFiksi");

                        int tipe = Integer.parseInt(sc.nextLine());

                        if(tipe==1) {
                            System.out.print("Masukkan id buku :");
                            String idBuku = sc.nextLine();
                            System.out.print("Masukkan judul buku :");
                            String judul = sc.nextLine();
                            System.out.print("Masukan genre buku :");
                            String genre = sc.nextLine();
                            System.out.print("Masukan pengarang buku :");
                            String pengarang = sc.nextLine();
                            System.out.print("Masukan tahun terbit buku :");
                            int tahun = Integer.parseInt(sc.nextLine());

                            perpus.tambahBukuFiksi(idBuku, judul, pengarang, tahun, genre);
                        } else if(tipe==2) {
                            System.out.print("Masukkan id buku :");
                            String idBuku = sc.nextLine();
                            System.out.print("Masukkan judul buku :");
                            String judul = sc.nextLine();
                            System.out.print("Masukan topik buku :");
                            String topik = sc.nextLine();
                            System.out.print("Masukan pengarang buku :");
                            String pengarang = sc.nextLine();
                            System.out.print("Masukan tahun terbit buku :");
                            int tahun = Integer.parseInt(sc.nextLine());
                            perpus.tambahBukuNonFiksi(idBuku, judul, pengarang, tahun, topik);
                        }
                    } else if (kegiatan==2) {
                        System.out.print("Masukan judul buku yang ingin dihapus :");
                        String judul = sc.nextLine();
                        System.out.println("Catat id buku yang ingin dihapus");
                        perpus.cariBukuByJudul(judul);

                        System.out.print("Masukan id buku yang ingin dikembalikkan :");
                        String id = sc.nextLine();
                        perpus.hapusBuku(id);
                    } else if (kegiatan == 3) {
                        System.out.println("Cari berdasarkan : (ketik 1 / 2 / 3 / 4 / 5)");
                        System.out.println("1. Judul");
                        System.out.println("2. Genre");
                        System.out.println("3. Pengarang");
                        System.out.println("4. Tahun Terbit");
                        System.out.println("5. Semua buku");
                        
                        int cariBy = Integer.parseInt(sc.nextLine());
                        if(cariBy==5) {
                            perpus.tampilkanSemuaBuku();
                        } else {

                            System.out.println("Masukkan kata kunci :");
                            String kataKunci = sc.nextLine();

                            if (cariBy == 1) {
                                perpus.cariBukuByJudul(kataKunci);
                            } else if (cariBy == 2) {
                                perpus.cariBukuByGenre(kataKunci);
                            } else if (cariBy == 3) {
                                perpus.cariBukuByPengarang(kataKunci);
                            } else if (cariBy == 4) {
                                perpus.cariBukuByTahun(kataKunci);
                            }
                        } 
                    } else if (kegiatan == 4) {
                        perpus.tampilkanSemuaAnggota();
                    } else if (kegiatan == 5) {
                        finish = true;
                    } else {
                        System.out.println("Coba lagi, pilihan tidak valid");
                    }
                }
            }
        }
    }

}
