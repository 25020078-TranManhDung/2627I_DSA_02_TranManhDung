import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        Stack<Integer> stackIn = new Stack<>();
        Stack<Integer> stackOut = new Stack<>();

        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();

            if (type == 1) {
                int x = scanner.nextInt();
                stackIn.push(x);
            }
            else {
                if (stackOut.isEmpty()) {
                    while (!stackIn.isEmpty()) {
                        stackOut.push(stackIn.pop());
                    }
                }
                if (type == 2) {
                    stackOut.pop();
                } else if (type == 3) {
                    System.out.println(stackOut.peek());
                }
            }
        }
        scanner.close();
    }
}
