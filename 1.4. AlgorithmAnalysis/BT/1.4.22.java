/**
 * Thời gian: O(log N) - Bộ nhớ: O(1)
 */

import edu.princeton.cs.algs4.StdOut;

public class FibonacciSearch {

    /**
     * Xác định xem mảng có chứa một giá trị cho trước hay không (Chỉ dùng + và -)
     */
    public static boolean contains(int[] a, int key) {
        int n = a.length;
        if (n == 0) return false;

        // B1: Khởi tạo 3 số Fibonacci đầu tiên
        int f2 = 0; // F(k-2)
        int f1 = 1; // F(k-1)
        int f  = f2 + f1; // F(k)

        // Tìm số Fibonacci nhỏ nhất lớn hơn hoặc bằng N
        while (f < n) {
            f2 = f1;
            f1 = f;
            f  = f1 + f2;
        }

        int offset = -1;

        // B2: Duyệt tìm kiếm (kiểm tra f > 1)
        while (f > 1) {
            // Xác định vị trí i bằng phép cộng
            int i = offset + f2;

            // Xử lý trường hợp F(k) lớn hơn kích thước mảng
            if (i >= n) {
                i = n - 1;
            }

            if (a[i] == key) {
                return true;
            }
            else if (key > a[i]) {
                // Khóa LỚN HƠN -> Nằm bên TRÁI (do mảng giảm dần)
                // Lùi 2 bước trong dãy Fibonacci
                f  = f2;
                f1 = f1 - f2; // F(k-1) cũ trừ đi F(k-2) cũ sẽ ra F(k-3)
                f2 = f  - f1; // Tương tự
            }
            else {
                // Khóa NHỎ HƠN -> Nằm bên PHẢI (do mảng giảm dần)
                // Dịch điểm bắt đầu và lùi 1 bước trong dãy Fibonacci
                offset = i;
                f  = f1;
                f1 = f2;
                f2 = f  - f1;
            }
        }

        // B3: Kiểm tra phần tử sót lại cuối cùng khi f1 = 1
        if (f1 == 1 && offset + 1 < n && a[offset + 1] == key) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        // Mảng phân biệt sắp xếp GIẢM DẦN
        int[] a = { 90, 80, 75, 60, 50, 42, 30, 25, 10, 5 };

        StdOut.println("[90, 80, 75, 60, 50, 42, 30, 25, 10, 5]\n");

        StdOut.println("Tìm 60 (Có trong mảng): " + contains(a, 60)); // True
        StdOut.println("Tìm 5  (Có trong mảng): " + contains(a, 5));  // True
        StdOut.println("Tìm 90 (Có trong mảng): " + contains(a, 90)); // True
        StdOut.println("Tìm 45 (Không có): " + contains(a, 45));      // False
    }
}
