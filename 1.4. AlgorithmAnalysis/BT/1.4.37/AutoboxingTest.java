import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdOut;

public class AutoboxingTest {
    public static void main(String[] args) {
        int n = 500000000;

        StdOut.println("Bắt đầu thử nghiệm");

        // Thí nghiệm 1: Tính toán bằng int
        Stopwatch timer1 = new Stopwatch();
        int sum1 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += 1;
        }
        double time1 = timer1.elapsedTime();
        StdOut.println("Thời gian chạy kiểu int: " + time1 + " giây");

        // Thí nghiệm 2: Tính toán bằng đối tượng (Integer)
        Stopwatch timer2 = new Stopwatch();
        Integer sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum2 += 1; // Autoboxing diễn ra liên tục ở đây
        }
        double time2 = timer2.elapsedTime();
        StdOut.println("Thời gian chạy kiểu Integer: " + time2 + " giây");

        StdOut.printf("Autoboxing làm chậm chương trình khoảng %.1f lần\n", (time2 / time1));
    }
}
