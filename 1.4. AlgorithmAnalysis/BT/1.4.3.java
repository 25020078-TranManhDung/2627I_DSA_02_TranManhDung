import edu.princeton.cs.algs4.*;

import java.util.ArrayList;

package edu.princeton.cs.algs4;

public class DoublingTest {
    private static final int MAXIMUM_INTEGER = 1000000;

    private DoublingTest() { }

    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        int ignore = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        // Lưu trữ lịch sử N và Time để vẽ lại đồ thị khi Scale thay đổi
        ArrayList<Integer> nList = new ArrayList<>();
        ArrayList<Double> timeList = new ArrayList<>();

        // Thiết lập kích thước cửa sổ vẽ
        StdDraw.setCanvasSize(800, 400);

        for (int n = 250; true; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %7.1f\n", n, time);

            nList.add(n);
            timeList.add(time);

            drawDynamicPlots(nList, timeList);
        }
    }

    /**
     * Hàm vẽ đồ thị động cập nhật theo tỷ lệ dữ liệu lớn nhất
     */
    private static void drawDynamicPlots(ArrayList<Integer> ns, ArrayList<Double> times) {
        StdDraw.clear();

        int maxN = ns.get(ns.size() - 1);
        // Tránh giá trị 0 gây lỗi khi tính Logarit (nếu thời gian chạy quá nhanh < 0.001s)
        double maxTime = Math.max(times.get(times.size() - 1), 0.001);

        // Cố định không gian vẽ trên màn hình từ -0.1 đến +1.2 để chừa lề
        StdDraw.setXscale(-0.1, 1.2);
        StdDraw.setYscale(-0.1, 1.2);

        // Vẽ 2 trục tọa độ giả lập X và Y
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.line(0, 0, 1.1, 0);
        StdDraw.line(0, 0, 0, 1.1);

        // 1. VẼ ĐỒ THỊ CHUẨN (MÀU ĐỎ)
        // Áp dụng phép chia cho maxN và maxTime để nén mọi điểm ảnh vào khung [0, 1]
        StdDraw.setPenColor(StdDraw.RED);
        for (int i = 1; i < ns.size(); i++) {
            double x0 = (double) ns.get(i-1) / maxN;
            double y0 = times.get(i-1) / maxTime;
            double x1 = (double) ns.get(i) / maxN;
            double y1 = times.get(i) / maxTime;

            StdDraw.line(x0, y0, x1, y1);
            StdDraw.filledCircle(x1, y1, 0.015);
        }

        // 2. VẼ ĐỒ THỊ LOG-LOG (MÀU XANH)
        // Áp dụng thuật toán tương tự, nhưng chuẩn hóa các giá trị sau khi đã lấy Logarit
        StdDraw.setPenColor(StdDraw.BLUE);
        double logMaxN = Math.log(maxN);
        double logMaxTime = Math.log(maxTime);
        double logMinTime = Math.log(Math.max(times.get(0), 0.001));

        for (int i = 1; i < ns.size(); i++) {
            double x0 = Math.log(ns.get(i-1)) / logMaxN;
            double y0 = (Math.log(Math.max(times.get(i-1), 0.001)) - logMinTime) / (logMaxTime - logMinTime + 0.0001);

            double x1 = Math.log(ns.get(i)) / logMaxN;
            double y1 = (Math.log(Math.max(times.get(i), 0.001)) - logMinTime) / (logMaxTime - logMinTime + 0.0001);

            StdDraw.line(x0, y0, x1, y1);
            StdDraw.filledCircle(x1, y1, 0.015);
        }
    }
}

