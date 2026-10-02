import java.util.Arrays;
import java.util.Scanner;

public class W4_25020078 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();;
            int[] citation = new int[n];

            for (int i = 0; i < n; i++) {
                citation[i] = scanner.nextInt();
            }

            Arrays.sort(citation);

            int hIndex = 0;

            for (int i = n - 1; i >= 0; i--) {
                if (citation[i] > hIndex) {
                    hIndex++;
                } else {
                    break;
                }
            }

            System.out.println(hIndex);
        }

        scanner.close();
    }
}
