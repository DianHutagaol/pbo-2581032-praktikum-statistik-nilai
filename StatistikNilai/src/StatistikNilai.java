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

        scanner.close();
    }
}