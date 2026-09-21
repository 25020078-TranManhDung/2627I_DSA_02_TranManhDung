/**
 * Bài 1.4.10: Tìm kiếm nhị phân trả về chỉ số nhỏ nhất
 * Thời gian chạy: O(log N)
 */

import edu.princeton.cs.algs4.StdOut;

public class BinarySearchFirst {

    /**
     * Tìm vị trí xuất hiện đầu tiên của key trong mảng đã sắp xếp
     * @param a mảng đầu vào (đã sắp xếp tăng dần)
     * @param key khóa cần tìm
     * @return chỉ số nhỏ nhất của key, hoặc -1 nếu không tìm thấy
     */
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        int result = -1; // Biến lưu vết vị trí

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                result = mid;     // Ghi nhớ vị trí hiện tại
                hi = mid - 1;     // Thu hẹp phạm vi tìm kiếm về bên trái
            }
        }

        return result;
    }

    /**
     * Hàm main để chạy thử nghiệm
     */
    public static void main(String[] args) {
        int[] a = { 1, 2, 2, 2, 2, 3, 4, 4, 5 };

        StdOut.println("Mảng: [1, 2, 2, 2, 2, 3, 4, 4, 5]");
        StdOut.println("Index tương ứng:  0, 1, 2, 3, 4, 5, 6, 7, 8\n");

        int key1 = 2;
        StdOut.println("Tìm khóa " + key1 + " -> Chỉ số nhỏ nhất: " + indexOf(a, key1) + " (Kỳ vọng: 1)");

        int key2 = 4;
        StdOut.println("Tìm khóa " + key2 + " -> Chỉ số nhỏ nhất: " + indexOf(a, key2) + " (Kỳ vọng: 6)");

        int key3 = 9;
        StdOut.println("Tìm khóa " + key3 + " -> Chỉ số nhỏ nhất: " + indexOf(a, key3) + " (Kỳ vọng: -1)");
    }
}
