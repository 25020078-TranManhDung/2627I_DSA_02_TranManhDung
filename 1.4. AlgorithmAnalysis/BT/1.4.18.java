/**
 * Thời gian chạy: O(log N) với tối đa ~2lgN phép so sánh
 */

import edu.princeton.cs.algs4.StdOut;

public class LocalMinimum {

    /**
     * Tìm chỉ số của một cực tiểu địa phương trong mảng các số nguyên phân biệt
     * @param a mảng đầu vào
     * @return chỉ số của cực tiểu địa phương, hoặc -1 nếu mảng rỗng
     */
    public static int findLocalMinimum(int[] a) {
        int n = a.length;
        if (n == 0) return -1;
        if (n == 1) return 0;

        if (a[0] < a[1]) return 0;
        if (a[n - 1] < a[n - 2]) return n - 1;

        int lo = 1;
        int hi = n - 2;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) {
                return mid;
            } else if (a[mid - 1] < a[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = { 9, 6, 3, 14, 5, 7, 4 };

        StdOut.println("[9, 6, 3, 14, 5, 7, 4]");
        int minIndex = findLocalMinimum(a);

        if (minIndex != -1) {
            StdOut.println("Cực tiểu địa phương tại chỉ số: " + minIndex);
            StdOut.println("Giá trị cực tiểu: " + a[minIndex]);
        }
    }
}
