/**
 * Bài 1.4.15: Faster 3-Sum
 * Phương pháp: Sắp xếp + Hai con trỏ
 */

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSumFast {
    public static int count(int[] a) {
        // B1: Sắp xếp mảng mất O(N logN)
        Arrays.sort(a);

        int n = a.length;
        int count = 0;

        // B2: Cố định 1 phần tử a[i]
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;

            // B3: Áp dụng Two Pointers
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = (long) a[i] + a[left] + a[right];

                if (sum == 0) {
                    count++;

                    //Bỏ qua các số trùng lặp để đếm bộ duy nhất
                    while (left < right && a[left] == a[left + 1]) left++;
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
        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        int totalThrees = count(a);
        StdOut.println("Total 3-sum pairs: " + totalThrees);
    }
}
