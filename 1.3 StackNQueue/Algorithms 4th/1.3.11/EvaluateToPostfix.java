/*
Sử dụng 1 Stack duy nhất để lưu các toán hạng
- Gặp toán hạng (số): Đẩy (push) vào Stack
- Gặp toán tử (+, -, *, /): Rút (pop) 2 toán hạng trên cùng ra để tính toán
  Số rút ra đầu tiên là toán hạng bên phải (v2), số rút ra thứ hai là toán hạng bên trái (v1), phép tính là (v1 op v2)
  Sau khi tính xong, đẩy kết quả ngược lại vào Stack
- Xử lý xong toàn bộ chuỗi, kết quả cuối cùng của biểu thức chính là phần tử duy nhất còn lại trên Stack
 */

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluateToPostfix {
    public static void main(String[] args) {
        Stack<Double> vals = new Stack<Double>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

             if (s.equals("+")) {
                 vals.push(vals.pop() + vals.pop());
             }
             else if (s.equals("*")) {
                 vals.push(vals.pop() * vals.pop());
             }
             else if (s.equals("-")) {
                 double v2 = vals.pop();
                 double v1 = vals.pop();
                 vals.push(v1 - v2);
             }
             else if (s.equals("/")) {
                 double v2 = vals.pop();
                 double v1 = vals.pop();
                 vals.push(v1 / v2);
             }
             else {
                 vals.push(Double.parseDouble(s));
             }
        }

        StdOut.println(vals.pop());
    }
}
