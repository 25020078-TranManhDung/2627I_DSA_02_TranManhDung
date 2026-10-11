import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class MergeSortSurvey {
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)                    a[k] = aux[j++];
            else if (j > hi)                a[k] = aux[i++];
            else if (aux[j] < aux[i])       a[k] = aux[j++];
            else                            a[k] = aux[i++];
        }
    }

    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void mergeSort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static double timeTrial(int[] original) {
        int[] a = original.clone();
        long start = System.nanoTime();
        mergeSort(a);
        long end = System.nanoTime();
        return (end - start) / 1000000.0;
    }

    // (2) Sinh dữ liệu ngẫu nhiên
    public static int[] generateRandom(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(100000);
        }
        return a;
    }

    // (3) Dữ liệu sắp xếp xuôi
    public static int[] generateSorted(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        return a;
    }

    // (4) Dữ liệu sắp xếp ngược
    public static int[] generateReverse(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = n - i;
        }
        return a;
    }

    // (5) Dữ liệu toàn giá trị bằng nhau
    public static int[] generateEqual(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = 1;
        }
        return a;
    }

    public static double getAverageTime(int[] data, int trials) {
        double totalTime = 0; // Đổi sang double
        for (int i = 0; i < trials; i++) {
            totalTime += timeTrial(data);
        }
        return totalTime / trials;
    }

    public static void main(String[] args) {
        // (1) Đọc file test 4Kints.txt (lấy trung bình 3 lần chạy)
        In in = new In("4Kints.txt");
        int[] fileData = in.readAllInts();
        System.out.println("Thời gian (1) File test 4Kints.txt: " + getAverageTime(fileData, 3) + " ms");

        // Thống kê với các kích thước N khác nhau
        int[] sizes = {1000, 4000, 8000, 16000};

        for (int n : sizes) {
            System.out.println("\nKích thước N = " + n);

            int[] randomData = generateRandom(n);
            int[] sortedData = generateSorted(n);
            int[] reverseData = generateReverse(n);
            int[] equalData = generateEqual(n);

            System.out.println("(2) Ngẫu nhiên: " + getAverageTime(randomData, 5) + " ms");
            System.out.println("(3) Sắp xếp xuôi: " + getAverageTime(sortedData, 3) + " ms");
            System.out.println("(4) Sắp xếp ngược: " + getAverageTime(reverseData, 3) + " ms");
            System.out.println("(5) Bằng nhau: " + getAverageTime(equalData, 3) + " ms");
        }
    }
}
