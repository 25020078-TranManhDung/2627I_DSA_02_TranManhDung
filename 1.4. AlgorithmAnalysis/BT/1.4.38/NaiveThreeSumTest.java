import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class NaiveThreeSumTest {

    // 1. Cài đặt 3-Sum chuẩn
    public static int standardThreeSum(int[] a) {
        int n = a.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    // 2. Cài đặt 3-Sum ngây thơ
    public static int naiveThreeSum(int[] a) {
        int n = a.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i < j && j < k) {
                        if (a[i] + a[j] + a[k] == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    // 3. Chạy thử nghiệm và đo thời gian
    public static void timeTrial(int N) {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniformInt(-1000000, 1000000);
        }

        // Đo thời gian thuật toán chuẩn
        Stopwatch timer1 = new Stopwatch();
        standardThreeSum(a);
        double time1 = timer1.elapsedTime();

        // Đo thời gian thuật toán ngây thơ
        Stopwatch timer2 = new Stopwatch();
        naiveThreeSum(a);
        double time2 = timer2.elapsedTime();

        // Tính chênh lệch
        double ratio = (time1 == 0) ? 0 : time2 / time1;

        StdOut.printf("%7d %10.3f %10.3f %10.2f\n", N, time1, time2, ratio);
    }

    public static void main(String[] args) {
        StdOut.printf("%7s %10s %10s %10s\n", "N", "Time(Std)", "Time(Naive)", "Ratio");
        StdOut.println("-------------------------------------------");

        // Nhân đôi kích thước mảng liên tục để theo dõi sự tăng trưởng
        for (int N = 250; N <= 4000; N += N) {
            timeTrial(N);
        }
    }
}
