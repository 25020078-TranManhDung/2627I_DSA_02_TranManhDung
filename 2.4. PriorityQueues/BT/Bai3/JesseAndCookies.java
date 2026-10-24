import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JesseAndCookies {

    public static int getMinOperations(int k, List<Integer> cookies) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(cookies);
        int operations = 0;

        while (pq.size() > 1 && pq.peek() < k) {
            int leastSweet = pq.poll();
            int secondLeastSweet = pq.poll();

            int newCookie = leastSweet + (2 * secondLeastSweet);
            pq.add(newCookie);
            operations++;
        }

        if (!pq.isEmpty() && pq.peek() >= k) {
            return operations;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            List<Integer> cookies = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                cookies.add(scanner.nextInt());
            }

            int result = getMinOperations(k, cookies);
            System.out.println(result);
        }

        scanner.close();
    }
}
