/*
Nguyên lý thuật toán:
- Gặp dấu ngoặc mở '(', '[', '{': push vào Stack
- Gặp dấu ngoặc đóng ')', ']', '}': pop phần tử trên cùng của Stack ra để đối chiếu
  + Nếu Stack rỗng (thừa ngoặc đóng) -> Sai (false)
  + Nếu phần tử lấy ra không khớp loại với ngoặc đóng -> Sai (false)
- Xử lý xong toàn bộ chuỗi, nếu Stack rỗng (các cặp ngoặc đã triệt tiêu hết) -> Hợp lệ (true).
  Nếu Stack vẫn còn phần tử (thừa ngoặc mở) -> Sai (false).
 */
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            //Nếu là ngoặc mở -> push vào stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            //Nếu là ngoặc đóng -> pop và kiểm tra
            else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }

        //Trả về true nếu stack rỗng
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = StdIn.readString();
        StdOut.println(isBalanced(s));
    }
}
