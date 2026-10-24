import java.util.Arrays;

public class NaturalMergeSort {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                               a[k] = aux[j++];
            else if (j > hi)                                a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0)          a[k] = aux[j++];
            else                                            a[k] = aux[i++];
        }
    }

    // Natural Merge Sort
    public static void sort(Comparable[] a) {
        int n = a.length;
        if (n <= 1) return;

        Comparable[] aux = new Comparable[n];

        while (true) {
            int lo = 0;
            int numMerges = 0;

            while (lo < n - 1) {
                // 1. Tìm điểm kết thúc của Run 1
                int mid = lo;
                while (mid < n - 1 && a[mid + 1].compareTo(a[mid]) >= 0) {
                    mid++;
                }

                // Nếu Run 1 kéo dài đến cuối mảng thì mảng đã hết, dừng quét
                if (mid == n - 1) break;

                // 2. Tìm điểm kết thúc của Run 2
                int hi = mid + 1;
                while (hi < n - 1 && a[hi + 1].compareTo(a[hi]) >= 0) {
                    hi++;
                }

                // 3. Trộn Run 1 và Run 2 lại với nhau
                merge(a, aux, lo, mid, hi);
                numMerges++;

                // Nhảy con trỏ để đi tìm các Run tiếp theo
                lo = hi + 1;
            }

            // Dừng thuật toán nếu lướt qua cả mảng mà không cần trộn lần nào
            if (numMerges == 0) break;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = { 4, 7, 2, 9, 1, 5, 8, 3, 6 };

        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
        sort(arr);
        System.out.println("Đã sắp xếp:   " + Arrays.toString(arr));
    }
}
