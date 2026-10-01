import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

public class InsertionSortSurvey {
    public static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        }
    }

    public static long timeTrial(int[] original) {
        int[] a = original.clone();
        long start = System.currentTimeMillis();    // Bắt đầu đo
        insertionSort(a);
        long end = System.currentTimeMillis();      // Kết thúc đo
        return end - start;
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

    public static long getAverageTime(int[] data, int trials) {
        long totalTime = 0;
        for (int i = 0; i < trials; i++) {
            totalTime += timeTrial(data);
        }
        return totalTime / trials;
    }

    public static void main(String[] args) {
        // Đọc file test
        In in = new In("4Kints.txt");
        int[] fileData = in.readAllInts();
        System.out.println("Thời gian (1) File test: " + getAverageTime(fileData, 3) + " ms");

        // Thống kê với các kích thước N khác nhau
        int[] sizes = {1000, 4000, 8000, 16000};

        for (int n : sizes) {
            System.out.println("Kích thước N = " + n);

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
