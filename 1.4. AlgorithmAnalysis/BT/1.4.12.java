/**
 * Bài 1.4.12: In ra các phần tử chung của 2 mảng đã sắp xếp
 * Phương pháp: Hai con trỏ
 * Thời gian chạy: O(N)
 */

import edu.princeton.cs.algs4.StdOut;

public class CommonElements {

    /**
     * Tìm và in ra các phần tử xuất hiện ở cả hai mảng
     * @param a mảng thứ nhất (đã sắp xếp)
     * @param b mảng thứ hai (đã sắp xếp)
     */
    public static void printCommonElements(int[] a, int[] b) {
        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                // Tìm thấy phần tử chung
                StdOut.print(a[i] + " ");
                i++;
                j++;

                // Nếu bài toán yêu cầu không in các số trùng lặp nhiều lần
                // while (i < a.length && a[i] == a[i - 1]) i++;
                // while (j < b.length && b[j] == b[j - 1]) j++;
            }
        }
        StdOut.println();
    }

    /**
     * Hàm main để chạy thử nghiệm
     */
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 5, 8, 9};
        int[] b = {2, 3, 4, 5, 5, 10};

        StdOut.println("Mảng a: 1 3 5 5 8 9");
        StdOut.println("Mảng b: 2 3 4 5 5 10");
        StdOut.print("Phần tử chung: ");

        printCommonElements(a, b);
    }
}
