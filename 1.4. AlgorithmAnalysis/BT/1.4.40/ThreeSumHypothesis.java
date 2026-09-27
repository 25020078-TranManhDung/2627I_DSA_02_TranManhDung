import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import java.util.Arrays;

public class ThreeSumHypothesis {

    // Sử dụng thuật toán đếm N^2 logN hoặc N^3 để đếm số lượng thực tế
    public static int countReal(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Dùng Binary Search tìm số thứ 3 để tăng tốc
                int k = Arrays.binarySearch(a, -(a[i] + a[j]));
                if (k > j) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void runExperiment(int N, int M) {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformInt(-M, M + 1);
        }

        int realCount = countReal(a);

        // Tính toán dựa trên giả thuyết toán học N^3 / 16M
        double expectedCount = (Math.pow(N, 3)) / (16.0 * M);

        StdOut.printf("N = %-6d | M = %-8d\n", N, M);
        StdOut.printf("Thực tế đếm được: %d\n", realCount);
        StdOut.printf("Dự đoán lý thuyết: %.2f\n", expectedCount);
        StdOut.printf("Độ lệch: %.2f%%\n", Math.abs(realCount - expectedCount) / expectedCount * 100);
        StdOut.println("----------------------------------------");
    }

    public static void main(String[] args) {
        // Cố định M, tăng dần N
        int M = 1000000;
        runExperiment(1000, M);
        runExperiment(2000, M);
        runExperiment(4000, M);

        // Cố định N, thay đổi M
        runExperiment(2000, 500000);
        runExperiment(2000, 2000000);
    }
}
