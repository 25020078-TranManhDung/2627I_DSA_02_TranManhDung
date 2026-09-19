/**
 * Bài 1.4.14: 4-Sum
 * Phương pháp: Sử dụng kỹ thuật Sắp xếp + Hai con trỏ
 * Độ phức tạp thời gian: O(N^3)
 * Độ phức tạp không gian: O(1) (hoặc O(log N))
 */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class FourSum {
    /**
     * Đếm số lượng bộ 4 phần tử có tổng bằng 0
     * @param a mảng số nguyên đầu vào
     * @return số lượng bộ 4 thỏa mãn
     */
    public static int count(int[] a) {
        // B1: Sắp xếp mảng (O(N logN))
        Arrays.sort(a);

        int n = a.length;
        int count = 0;

        // B2: Duyệt 2 vòng lặp để cố định 2 phần tử ở đầu
        for (int i = 0; i < n - 3; i++) {
            // Bỏ qua các phần tử trùng lặp cho biến i
            if (i > 0 && a[i] == a[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Bỏ qua các phần tử trùng lặp cho biến j
                if (j > i + 1 && a[j] == a[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) a[i] + a[j] + a[left] + a[right];

                    if (sum == 0) {
                        count++;
                        // Bỏ qua các số trùng lặp phía bên trái
                        while (left < right && a[left] == a[left + 1]) left++;
                        // Bỏ qua các số trùng lặp phía bên phải
                        while (left < right && a[right] == a[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        int totalFours = count(a);
        StdOut.println("Total 4-sum pairs: " + totalFours);
    }
}
