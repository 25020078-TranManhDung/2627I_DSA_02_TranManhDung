import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

public class DoublingRatioImproved {
    /**
     * Đo tổng thời gian chạy của T lần thử nghiệm cho mảng kích thước N
     */
    public static double timeTrial(int N, int T) {
        double totalTime = 0.0;

        for (int t = 0; t < T; t++) {
            int[] a = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniformInt(-1000000, 1000000);
            }

            Stopwatch timer = new Stopwatch();
            ThreeSum.count(a); // Kiểm thử thuật toán ThreeSum O(N^3)
            totalTime += timer.elapsedTime();
        }

        return totalTime / T; // Trả về thời gian trung bình
    }

    public static void main(String[] args) {
        int T = 1;

        if (args.length > 0) {
            T = Integer.parseInt(args[0]);
        }

        StdOut.println("Chạy thử nghiệm với T = " + T + " lần cho mỗi N:");
        StdOut.printf("%7s %10s %7s\n", "N", "Time(avg)", "Ratio");
        StdOut.println("-----------------------------");

        double prev = timeTrial(125, T);

        for (int N = 250; true; N += N) {
            double time = timeTrial(N, T);
            double ratio = prev == 0 ? 0 : time / prev;

            StdOut.printf("%7d %10.3f %7.2f\n", N, time, ratio);
            prev = time;

            // Dừng sớm để tránh chờ quá lâu khi test mảng lớn
            if (N > 4000) break;
        }
    }
}
