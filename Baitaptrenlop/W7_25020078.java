import java.util.Collections;
import java.util.PriorityQueue;

public class W7_25020078 {

    public static void main(String[] args) {
        int[] a = {12, 4, 5, 3, 8, 7};

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for (int i = 0; i < a.length; i++) {
            int num = a[i];

            if (maxPQ.isEmpty() || num <= maxPQ.peek()) {
                maxPQ.add(num);
            } else {
                minPQ.add(num);
            }

            if (maxPQ.size() > minPQ.size() + 1) {
                minPQ.add(maxPQ.poll());
            } else if (minPQ.size() > maxPQ.size()) {
                maxPQ.add(minPQ.poll());
            }

            // Lấy giá trị trung vị
            double median;
            if (maxPQ.size() == minPQ.size()) {
                median = (maxPQ.peek() + minPQ.peek()) / 2.0;
            } else {
                median = (double) maxPQ.peek();
            }

            System.out.printf("%.1f\n", median);
        }
    }
}
