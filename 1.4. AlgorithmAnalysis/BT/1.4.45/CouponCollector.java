import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class CouponCollector {

    // Hàm mô phỏng 1 lần gom đủ N thẻ
    public static int simulate(int N) {
        boolean[] isCollected = new boolean[N];
        int count = 0;         // Tổng số lần đã bốc
        int distinctCount = 0; // Số loại thẻ khác nhau đã gom được

        while (distinctCount < N) {
            int val = StdRandom.uniformInt(N);
            count++;

            // Nếu bốc được thẻ mới chưa từng có
            if (!isCollected[val]) {
                distinctCount++;
                isCollected[val] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int N = 1000;         // Tổng số loại thẻ
        int trials = 10000;   // Chạy mô phỏng 10.000 lần
        long totalCount = 0;

        for (int t = 0; t < trials; t++) {
            totalCount += simulate(N);
        }

        double average = (double) totalCount / trials;

        double harmonicSum = 0.0;
        for (int i = 1; i <= N; i++) {
            harmonicSum += 1.0 / i;
        }
        double mathExpected = N * harmonicSum;

        StdOut.printf("Số loại thẻ (N): %d\n", N);
        StdOut.printf("Trung bình số lần bốc thực tế : %.2f\n", average);
        StdOut.printf("Công thức lý thuyết (N * H_N) : %.2f\n", mathExpected);
        StdOut.printf("Ước lượng xấp xỉ (N * ln(N))  : %.2f\n", N * Math.log(N));
    }
}
