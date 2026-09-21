/**
 * Thời gian chạy: O(log N) với tối đa ~3lgN phép so sánh
 */

import edu.princeton.cs.algs4.StdOut;

public class BitonicSearch {

    /**
     * Hàm chính để tìm kiếm khóa trong mảng bitonic
     */
    public static boolean search(int[] a, int key) {
        if (a == null || a.length == 0) return false;

        // Bước 1: Tìm chỉ số của đỉnh (~1lgN)
        int peak = findPeak(a);

        // Bước 2: Tìm kiếm nhị phân ở nửa tăng dần (~1lgN)
        boolean foundInAscending = ascendingBinarySearch(a, key, 0, peak);
        if (foundInAscending) {
            return true;
        }

        // Bước 3: Tìm kiếm nhị phân ở nửa giảm dần (~1lgN)
        return descendingBinarySearch(a, key, peak + 1, a.length - 1);
    }

    /**
     * Tìm đỉnh của mảng bitonic
     */
    private static int findPeak(int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < a[mid + 1]) {
                lo = mid + 1; // Sườn đang tăng, đỉnh ở bên phải
            } else {
                hi = mid;     // Sườn đang giảm, đỉnh ở bên trái hoặc chính là mid
            }
        }
        return lo; // lo và hi hội tụ tại đỉnh
    }

    /**
     * Tìm kiếm nhị phân thông thường (mảng tăng dần)
     */
    private static boolean ascendingBinarySearch(int[] a, int key, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Tìm kiếm nhị phân đảo ngược (mảng giảm dần)
     */
    private static boolean descendingBinarySearch(int[] a, int key, int lo, int hi) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key > a[mid]) { // Đảo ngược dấu so sánh so với mảng tăng dần
                hi = mid - 1;
            } else if (key < a[mid]) {
                lo = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 5, 8, 12, 15, 10, 7, 4, 2 };

        StdOut.println("Tìm 12 (Có trong mảng): " + search(a, 12));
        StdOut.println("Tìm 4  (Có trong mảng): " + search(a, 4));
        StdOut.println("Tìm 6  (Không có): " + search(a, 6));
    }
}
