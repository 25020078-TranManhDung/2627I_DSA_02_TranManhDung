import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class QuickSortSurvey {
    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];

        while (true) {
            while (a[++i] < v) {
                if (i == hi) break;
            }
            while (v < a[--j]) {
                if (j == lo) break;
            }

            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static void quickSortWithoutShuffle(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void quickSortWithShuffle(int[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length -1);
    }

    // Đo thời gian 1 lần chạy (mode: 1 = không shuffle, 2 = có shuffle)
    public static long timeTrial(int[] original, int mode) {
        int[] a = original.clone();
        long start = System.currentTimeMillis();
        try {
            if (mode == 1) {
                quickSortWithoutShuffle(a);
            } else {
                quickSortWithShuffle(a);
            }
        } catch (StackOverflowError e) {
            return -1; // Đánh dấu StackOverflow
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    // Tính thời gian trung bình qua nhiều lần chạy
    public static long getAverageTime(int[] data, int mode, int trials) {
        long totalTime = 0;
        for (int i = 0; i < trials; i++) {
            long t = timeTrial(data, mode);
            if (t == -1) return -1; // Bị tràn stack
            totalTime += t;
        }
        return totalTime / trials;
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

    public static void main(String[] args) {
        // (1) File test 4Kints.txt
        In in = new In("4Kints.txt");
        int[] fileData = in.readAllInts();
        System.out.println("--- (1) File test 4Kints.txt ---");
        System.out.println("QuickSort không shuffle : " + getAverageTime(fileData, 1, 3) + " ms");
        System.out.println("QuickSort có shuffle    : " + getAverageTime(fileData, 2, 3) + " ms");

        // Khảo sát trên các kích thước N khác nhau
        int[] sizes = {1000, 4000, 8000, 16000};

        for (int n : sizes) {
            System.out.println("\n================ Kích thước N = " + n + " ================");
            int[] randomData  = generateRandom(n);
            int[] sortedData  = generateSorted(n);
            int[] reverseData = generateReverse(n);
            int[] equalData   = generateEqual(n);

            System.out.printf("%-20s | %-20s | %-20s\n", "Dạng dữ liệu", "Không Shuffle", "Có Shuffle");
            System.out.println("---------------------------------------------------------------");

            long tNoShuf, tShuf;

            // (2) Ngẫu nhiên (5 lần)
            tNoShuf = getAverageTime(randomData, 1, 5);
            tShuf   = getAverageTime(randomData, 2, 5);
            System.out.printf("%-20s | %-17s ms | %-17s ms\n", "Ngẫu nhiên", tNoShuf, tShuf);

            // (3) Sắp xếp xuôi (3 lần)
            tNoShuf = getAverageTime(sortedData, 1, 3);
            tShuf   = getAverageTime(sortedData, 2, 3);
            System.out.printf("%-20s | %-17s ms | %-17s ms\n", "Sắp xếp xuôi",
                    (tNoShuf == -1 ? "Tràn Stack" : tNoShuf), tShuf);

            // (4) Sắp xếp ngược (3 lần)
            tNoShuf = getAverageTime(reverseData, 1, 3);
            tShuf   = getAverageTime(reverseData, 2, 3);
            System.out.printf("%-20s | %-17s ms | %-17s ms\n", "Sắp xếp ngược",
                    (tNoShuf == -1 ? "Tràn Stack" : tNoShuf), tShuf);

            // (5) Bằng nhau (3 lần)
            tNoShuf = getAverageTime(equalData, 1, 3);
            tShuf   = getAverageTime(equalData, 2, 3);
            System.out.printf("%-20s | %-17s ms | %-17s ms\n", "Bằng nhau", tNoShuf, tShuf);
        }
    }
}
