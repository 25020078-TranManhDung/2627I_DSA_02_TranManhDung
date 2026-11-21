import java.util.*;

public class MissingNumbers {
    // Cách 1
    public static List<Integer> missingNumbers1(int[] a, int[] b) {
        Map<Integer, Integer> ca = new HashMap<>();
        Map<Integer, Integer> cb = new HashMap<>();

        for (int x : a) {
            ca.put(x, ca.getOrDefault(x, 0) + 1);
        }

        for (int x : b) {
            cb.put(x, cb.getOrDefault(x, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        for (int x : cb.keySet()) {
            if (cb.get(x) > ca.getOrDefault(x, 0)) res.add(x);
        }

        Collections.sort(res);
        return res;
    }

    // Cách 2
    public static List<Integer> missingNumbers2(int[] a, int[] b) {
        int[] sa = a.clone();
        int[] sb = b.clone();

        Arrays.sort(sa);
        Arrays.sort(sb);

        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (j < sb.length) {
            if (i < sa.length && sa[i] == sb[j]) {
                i++;
                j++;
            }
            else if (i < sa.length && sa[i] < sb[j]) {
                i++;
            }
            else {
                if (res.isEmpty() || res.get(res.size() - 1) != sb[j]) {
                    res.add(sb[j]);
                }
                j++;
            }
        }
        return res;
    }

    // Cách 3
    public static List<Integer> missingNumbers3(int[] a, int[] b) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int x : b) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        int[] count = new int[max - min + 1];
        for (int x : b) {
            count[x - min]++;
        }
        for (int x : a) {
            if (x >= min && x <= max) {
                count[x - min]--;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                res.add(i + min);
            }
        }

        return res;
    }

    static void print(String name, List<Integer> res) {
        StringBuilder sb = new StringBuilder();
        for (int x : res) {
            sb.append(x).append(" ");
        }
        System.out.println(name + ": " + sb.toString().trim());
    }

    public static void main(String[] args) {
        int[] a = {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
        int[] b = {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};

        print("Cách 1 (Hash)    ", missingNumbers1(a, b));
        print("Cách 2 (Sort)    ", missingNumbers2(a, b));
        print("Cách 3 (Counting)", missingNumbers3(a, b));
    }
}
