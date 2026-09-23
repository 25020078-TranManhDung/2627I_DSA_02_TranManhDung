/*
Dựa trên thuật toán 2 ngăn xếp của Dijkstra
Ta dùng 2 Stack: một chứa toán tử (ops), một chứa toán hạng/chuỗi giá trị (vals)
- Gặp toán tử (+, -, *, /): Đẩy vào ngăn xếp ops
- Gặp toán hạng (số): Đẩy vào ngăn xếp vals
- Gặp ngoặc đóng ')': Ta rút 1 toán tử và 2 toán hạng ra, ghép chúng lại kẹp giữa 2 dấu ngoặc thành một chuỗi hoàn chỉnh "( val1 op val2 )", rồi đẩy chuỗi mới này ngược lại vào vals
 */

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MissingLeftParentheses {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<String> vals = new Stack<String>();

        //Đọc chuỗi ký tự cách nhau bởi khoảng trắng
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                ops.push(s);
            }
            else if (s.equals(")")) {
                String op = ops.pop();
                String v2 = vals.pop();
                String v1 = vals.pop();

                String subExpr = "( " + v1 + " " + op + " " + v2 + " )";
                vals.push(subExpr);
            }
            else {
                vals.push(s);
            }
        }

        //Kết quả cuối là giá trị cuối cùng còn lại trên đỉnh stack
        StdOut.println(vals.pop());
    }
}
