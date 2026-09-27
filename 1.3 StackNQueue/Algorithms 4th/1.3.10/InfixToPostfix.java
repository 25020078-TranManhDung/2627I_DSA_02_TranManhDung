import java.util.Stack;

public class InfixToPostfix {
    static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        }
        return -1;
    }

    static String convertToPostfix(String exp) {
        String res = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == ' ') continue;

            if (Character.isLetterOrDigit(c)) {
                res += c;
            }

            else if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res += stack.pop();
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    res += stack.pop();
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        String infix = "20-(5+2)*1*3-2*(3+1)";
        System.out.println(infix);
        System.out.println(convertToPostfix(infix));
    }
}
