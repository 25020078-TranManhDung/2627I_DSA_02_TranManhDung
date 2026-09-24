/*
Giả thuyết đúng
- Linked List: Khuyết điểm lớn nhất là mỗi lần gọi push(), hệ thống phải khởi tạo một đối tượng Node mới (`new Node()`).
Việc cấp phát bộ nhớ liên tục này tốn rất nhiều thời gian, đồng thời tạo ra nhiều rác bộ nhớ khiến GC phải hoạt động vất vả hơn khi pop().
Ngoài ra, các Node nằm rải rác trong RAM nên không tận dụng được bộ nhớ đệm
- Resizing Array: Việc thêm/xóa phần tử chỉ là gán giá trị vào chỉ số mảng có sẵn `a[n++]`, cực kỳ nhanh và các phần tử nằm liền kề nhau trong RAM.
Dù mảng thỉnh thoảng tốn O(N) thời gian để resize, nhưng khi chia đều (Amortized), chi phí này là không đáng kể so với việc khởi tạo hàng triệu object Node
*/

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdOut;

public class StackCompare {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        edu.princeton.cs.algs4.Stack<Integer> listStack = new edu.princeton.cs.algs4.Stack<Integer>();
        Stopwatch timer1 = new Stopwatch();
        for (int i = 0; i < N; i++) {
            listStack.push(i);
        }
        for (int i = 0; i < N; i++) {
            listStack.pop();
        }
        double time1 = timer1.elapsedTime();
        StdOut.println("Linked List Stack: " + time1 + " giay");

        edu.princeton.cs.algs4.ResizingArrayStack<Integer> arrayStack = new edu.princeton.cs.algs4.ResizingArrayStack<Integer>();
        Stopwatch timer2 = new Stopwatch();
        for (int i = 0; i < N; i++) {
            arrayStack.push(i);
        }
        for (int i = 0; i < N; i++) {
            arrayStack.pop();
        }
        double time2 = timer2.elapsedTime();
        StdOut.println("Resizing Array Stack: " + time2 + " giay");

        StdOut.printf("Ti le thoi gian (LinkedList / Array): %.2f lan\n", time1 / time2);
    }
}

/*
.../1.4.43> javac-algs4 StackCompare.java
.../1.4.43> java-algs4 StackCompare 10000000
Linked List Stack: 1.684 giay
Resizing Array Stack: 0.204 giay
Ti le thoi gian (LinkedList / Array): 8.25 lan
*/
