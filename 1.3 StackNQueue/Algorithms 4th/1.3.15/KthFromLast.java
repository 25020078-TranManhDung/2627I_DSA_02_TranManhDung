/*
Nạp tất cả chuỗi đọc được vào Queue
Khi luồng dữ liệu kết thúc, tổng số phần tử trong Queue là N
Phần tử thứ k từ cuối lên tương đương với phần tử nằm ở vị trí thứ (N - k) tính từ đầu hàng đợi
Ta chỉ cần rút đúng (N - k) phần tử đầu tiên, phần tử nổi lên ngay sau đó chính là đáp án cần tìm
 */

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class KthFromLast {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Queue<String> queue = new Queue<String>();

        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }

        int N = queue.size();

        for (int i = 0; i < N - k; i++) {
            queue.dequeue();
        }

        StdOut.println(queue.dequeue());
    }
}
