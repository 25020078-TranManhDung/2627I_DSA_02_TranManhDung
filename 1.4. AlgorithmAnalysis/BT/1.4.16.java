/**
 * Bài 1.4.16: Closest pair
 * Thời gian chạy tối đa: O(N log N)
 */

import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;

public class ClosestPair {
    /**
     * Tìm và in ra cặp số có khoảng cách gần nhất
     * @param a mảng các số thực (double)
     */
    public static void findClosestPair(double[] a) {
        int n = a.length;
        if (n < 2) {
            StdOut.println("Mảng cần ít nhất 2 phần tử.");
            return;
        }

        // B1: Sắp xếp mảng mất thời gian O(N logN)
        Arrays.sort(a);

        double minDiff = Double.MAX_VALUE;
        double num1 = a[0];
        double num2 = a[1];

        // B2: Duyệt mạng 1 lần duy nhất mất thời gian O(N)
        for (int i = 1; i < n; i++) {
            double diff = Math.abs(a[i] - a[i-1]);

            if (diff < minDiff) {
                minDiff = diff;
                num1 = a[i-1];
                num2 = a[i];
            }
        }

        // B3: In kết quả
        StdOut.printf("Cặp số gần nhất là: %.6f và %.6f\n", num1, num2);
        StdOut.printf("Khoảng cách (hiệu tuyệt đối): %.6f\n", minDiff);
    }

    /**
     * Hàm main để chạy thử nghiệm
     */
    public static void main(String[] args) {
        double[] a = { -1.5, 3.2, 5.8, 9.1, 3.4, -4.0 };

        StdOut.println("Mảng ban đầu:");
        for (double v : a) {
            StdOut.print(v + "  ");
        }
        StdOut.println("\n-----------------");

        findClosestPair(a);
    }
}
