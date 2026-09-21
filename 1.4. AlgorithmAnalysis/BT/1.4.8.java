/**
 * Bài 1.4.8: Đếm số cặp phần tử bằng nhau
 * Thời gian chạy: O(N log N)
 */

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class EqualPairs {

    /**
     * Đếm số cặp giá trị bằng nhau trong mảng
     * @param a mảng số nguyên đầu vào
     * @return tổng số cặp bằng nhau
     */
    public static int countEqualPairs(int[] a) {
        int n = a.length;
        if (n < 2) return 0;

        // B1: Sắp xếp mảng (Thời gian O(N log N))
        Arrays.sort(a);

        int totalPairs = 0;
        int currentFreq = 1;

        // B2: Duyệt mảng 1 lần duy nhất (Thời gian O(N))
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {
                // Số mới này sẽ ghép thành cặp với tất cả các số giống nó phía trước
                totalPairs += currentFreq;
                currentFreq++;
            } else {
                // Gặp số mới thì reset lại tần suất đếm
                currentFreq = 1;
            }
        }

        return totalPairs;
    }

    /**
     * Hàm main để chạy thử nghiệm đọc dữ liệu từ file txt
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        int pairs = countEqualPairs(a);
        StdOut.println("Tổng số cặp bằng nhau: " + pairs);
    }
}
