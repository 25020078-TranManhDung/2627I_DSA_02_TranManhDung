/**
 * Bài 1.4.17: Farthest pair
 * Thời gian chạy: O(N)
 */

import edu.princeton.cs.algs4.StdOut;

public class FarthestPair {
    /**
     * Tìm và in ra cặp số có khoảng cách xa nhất
     * @param a mảng các số thực (double)
     */
    public static void findFarthestPair(double[] a) {
        int n = a.length;
        if (n < 2) {
            StdOut.println("Mảng cần ít nhất 2 phần tử");
            return;
        }

        // B1: Khởi tạo min và max bằng phần tử đầu tiên
        double min = a[0];
        double max = a[0];

        // B2: Duyệt mảng 1 lần duy nhất - thời gian O(N)
        for (int i = 1; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }

        // B3: In kết quả
        double maxDiff = max - min;
        StdOut.printf("Cặp số xa nhất là: %.6f và %.6f\n", min, max);
        StdOut.printf("Khoảng cách: %.6f\n", maxDiff);
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

        findFarthestPair(a);
    }
}
