/**
 * Số câu hỏi: Tỷ lệ thuận với log(N)
 */

import edu.princeton.cs.algs4.StdOut;

public class FractionSearch {
    private static boolean isLessThan(double secretFraction, double x) {
        return secretFraction < x;
    }

    /**
     * Tìm chính xác phân số bí mật p/q
     * @param N giới hạn lớn nhất của mẫu số
     * @param secretP tử số bí mật (để giả lập)
     * @param secretQ mẫu số bí mật (để giả lập)
     */
    public static void findFraction(int N, int secretP, int secretQ) {
        double secretValue = (double) secretP / secretQ;

        double lo = 0.0;
        double hi = 1.0;

        // Khoảng cách nhỏ nhất giữa 2 phân số bất kỳ luôn lớn hơn 1/N^2
        double epsilon = 1.0 / ((double) N * N);
        int questions = 0;

        // B1: Tìm kiếm nhị phân trên trục số thực
        // Thu hẹp khoảng cách cho đến khi lọt vào vùng an toàn
        while (hi - lo > epsilon) {
            double mid = lo + (hi - lo) / 2.0;
            questions++;

            if (isLessThan(secretValue, mid)) {
                hi = mid; // Giá trị bí mật nhỏ hơn mid -> Nằm ở nửa trái
            } else {
                lo = mid; // Giá trị bí mật lớn hơn hoặc bằng mid -> Nằm ở nửa phải
            }
        }

        // Giá trị cực kỳ sát với phân số cần tìm
        double target = lo + (hi - lo) / 2.0;

        // B2: Khôi phục phân số p/q từ số thực
        // Vì khoảng cách đã được thu hẹp tối đa, chắc chắn chỉ có 1 phân số hợp lệ
        int resultP = 0;
        int resultQ = 1;
        double minDiff = Double.MAX_VALUE;

        for (int q = 1; q < N; q++) {
            // Tìm tử số p gần nhất với tỷ lệ target * q
            int p = (int) Math.round(target * q);

            if (p > 0 && p < q) {
                double diff = Math.abs((double) p / q - target);
                if (diff < minDiff) {
                    minDiff = diff;
                    resultP = p;
                    resultQ = q;
                }
            }
        }

        StdOut.println("Phân số bí mật ban đầu: " + secretP + "/" + secretQ);
        StdOut.println("Phân số thuật toán tìm thấy: " + resultP + "/" + resultQ);
        StdOut.println("Số câu hỏi đã sử dụng: " + questions);
        StdOut.println("Mức tối đa dự kiến (~2lgN): " + (int)(2 * Math.log(N) / Math.log(2)));
    }

    public static void main(String[] args) {
        int N = 1000;
        // Phân số 41/152 thỏa mãn 0 < 41 < 152 < 1000
        int secretP = 41;
        int secretQ = 152;

        StdOut.println("Giới hạn mẫu số N = " + N + "\n");
        findFraction(N, secretP, secretQ);
    }
}
