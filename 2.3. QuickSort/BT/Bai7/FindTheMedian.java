import java.util.Random;
import java.util.Scanner;

public class FindTheMedian {
    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];

        while (true) {
            while (a[++i] < v) {
                if (i == hi) break;
            }

            while(a[--j] > v) {
                if(j == lo) break;
            }

            if (i >= j) break;

            swap(a, i, j);
        }

        swap(a, lo, j);
        return j;
    }

    public static int select(int[] a, int k) {
        shuffle(a);

        int lo = 0;
        int hi = a.length - 1;

        while (hi > lo) {
            int j = partition(a, lo, hi);

            if (j < k) {
                lo = j + 1;
            }
            else if (j > k) {
                hi = j - 1;
            }

            else {
                return a[k];
            }
        }

        return a[k];
    }

    private static void shuffle(int[] a) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = i + random.nextInt(a.length - i);
            swap(a, i, r);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so luong phan tu n (le): ");
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];

            System.out.println("Nhap cac phan tu cua mang: ");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            // Median k = n / 2
            int median = select(arr, n / 2);

            System.out.println("Phan tu trung vi (Median) la: " + median);
        }

        scanner.close();
    }
}
