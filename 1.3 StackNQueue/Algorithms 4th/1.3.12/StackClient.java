import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class StackClient {
    public static Stack<String> copy(Stack<String> stack) {
        Stack<String> temp = new Stack<String>();
        Stack<String> copy = new Stack<String>();

        for (String s : stack) {
            temp.push(s);
        }

        for (String s : temp) {
            copy.push(s);
        }

        return copy;
    }

    public static void main(String[] args) {
        Stack<String> original = new Stack<String>();
        original.push("X");
        original.push("Y");
        original.push("Z");

        Stack<String> copiedStack = copy(original);

        StdOut.print("Stack gốc: ");
        for (String s : original) {
            StdOut.print(s + " ");
        }

        StdOut.println();

        StdOut.print("Stack bản sao: ");
        for (String s : copiedStack) {
            StdOut.print(s + " ");
        }
    }

}
