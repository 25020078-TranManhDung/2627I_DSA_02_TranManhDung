import java.util.HashSet;
import java.util.Set;

public class Pairs {
    public static int pairs(int k, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);

        int count = 0;
        for (int x : arr) {
            if (set.contains(x + k)) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        System.out.println(pairs(2, arr)); // 3
    }
}
