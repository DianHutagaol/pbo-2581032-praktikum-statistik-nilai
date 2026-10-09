import java.util.ArrayList;
import java.util.Scanner;

public class StatistikNilai {
    private static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("~~~~~STATISTIK NILAI KELAS~~~~~");
        System.out.println("Ketik -1 kalo sudah selesai.");

        int inputVal;
        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            inputVal = scanner.nextInt();

            if (inputVal == SELESAI) {
                break;
            }

            if (inputVal < 0 || inputVal > 100) {
                System.out.println("    Ditolak, harus 0-100");
                continue;
            }
            daftar.add(inputVal);
        } while (inputVal != SELESAI);

        System.out.println();

        if (daftar.isEmpty()) {
            System.out.println("Tidak ada data nilai yang dimasukkan");
            scanner.close();
            return;
        }

        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());

        int total = 0;
        for (int nilai : daftar) {
            total += nilai;
        }
        double rataRata = (double) total / daftar.size();
        System.out.printf("Rata-rata        : %.2f\n", rataRata);

        /*
         * KETENTUAN 4:
         * Tertinggi dan terendah dicari dengan loop sendiri, bukan dengan Collections.max/min.
         * ALASAN PEMILIHAN NILAI AWAL:
         * Inisialisasi tertinggi dan terendah dimulai dari elemen pertama 'daftar.get(0)' (bukan 0 atau Integer.MAX_VALUE).
         * Jika terendah dimulai dari 0 padahal semua nilai ujian >= 0, nilai terendah akan selalu bernilai 0
         * meskipun angka 0 tidak ada di dalam daftar input.
         * Menggunakan daftar.get(0) menjamin min dan max berada di dalam rentang data yang valid.
         */

        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);

        for (int i = 1; i < daftar.size(); i++) {
            int val = daftar.get(i);
            if (val > tertinggi) {
                tertinggi = val;
            }
            if (val < terendah) {
                terendah = val;
            }
        }

        System.out.println("Tertinggi      : " + tertinggi);
        System.out.println("Terendah       : " + terendah);

        /*Jumlah mahasiswa di atas rata-rata tidak bisa dihitung pada putaran pertama (saat membaca input) karena nilai rata-rata kelas belum diketahui sampai seluruh data input selesai dibaca dan totalnya dihitung.*/
        int diatasRataRata = 0;
        for (int nilai : daftar) {
            if (nilai > rataRata) {
                diatasRataRata++;
            }
        }
        System.out.println("Di atas rata 2 : " + diatasRataRata + " orang");

        scanner.close();
    }
}
