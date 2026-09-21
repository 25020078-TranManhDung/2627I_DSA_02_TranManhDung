/**
 Thả 2 trứng (Tối ưu c*sqrt(F))
 */
import edu.princeton.cs.algs4.StdOut;

public class TwoEggDrop {
    private static boolean dropEgg(int floor, int F) {
        return floor >= F;
    }

    public static int findF(int N, int F_secret) {
        int k = 1;
        int stepFloor = 1;
        int drops = 0;

        // Trứng 1: Nhảy theo các số chính phương (1, 4, 9, 16...)
        while (stepFloor <= N) {
            drops++;
            if (dropEgg(stepFloor, F_secret)) {
                break; // Trứng 1 vỡ
            }
            k++;
            stepFloor = k * k;
        }

        // Đảm bảo không quét vượt quá N
        int hi = Math.min(stepFloor, N);
        int lo = (k - 1) * (k - 1) + 1;

        // Sửa lại nếu k=1 thì bắt đầu từ tầng 1
        if (k == 1) lo = 1;

        // Trứng 2: Quét tuyến tính trong khoảng [lo, hi]
        for (int i = lo; i <= hi; i++) {
            drops++;
            if (dropEgg(i, F_secret)) {
                StdOut.println("Tổng số lần thả: " + drops);
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 1000000;
        int F = 2500; // Kỳ vọng căn bậc 2 của F là 50

        StdOut.println("Tòa nhà có " + N + " tầng. F bí mật = " + F);
        int foundF = findF(N, F);
        StdOut.println("Tìm thấy trứng vỡ tại tầng: " + foundF);
    }
}
