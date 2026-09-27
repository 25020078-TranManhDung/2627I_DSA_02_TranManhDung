import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class BirthdayProblem {

    // Hàm mô phỏng 1 lần thử nghiệm, trả về số lần sinh ngẫu nhiên cho đến khi trùng
    public static int simulate(int N) {
        boolean[] found = new boolean[N]; // Mảng ghi nhớ các số đã xuất hiện
        int count = 0;

        while (true) {
            count++;
            int val = StdRandom.uniformInt(N); // Sinh số ngẫu nhiên từ 0 đến N-1

            if (found[val]) {
                return count; // Đã trùng, dừng lại và trả về kết quả
            }
            found[val] = true; // Đánh dấu là đã xuất hiện
        }
    }

    public static void main(String[] args) {
        int N = 365;
        int trials = 10000;
        long totalCount = 0;

        for (int t = 0; t < trials; t++) {
            totalCount += simulate(N);
        }

        double average = (double) totalCount / trials;
        double mathExpected = Math.sqrt(Math.PI * N / 2.0);

        StdOut.printf("N = %d, Số lần thử nghiệm: %d\n", N, trials);
        StdOut.printf("Trung bình thực tế đếm được : %.2f\n", average);
        StdOut.printf("Công thức lý thuyết toán học: %.2f\n", mathExpected);
    }
}
