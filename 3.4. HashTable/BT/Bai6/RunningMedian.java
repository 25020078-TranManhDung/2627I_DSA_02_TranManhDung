import java.util.TreeSet;

public class RunningMedian {
    static class Item implements Comparable<Item> {
        int val;
        int idx;        // Thứ tự nhập, để phân biệt các số bằng nhau

        Item(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Item o) {
            if (val != o.val) return Integer.compare(val, o.val);
            return Integer.compare(idx, o.idx);
        }
    }

    public static double[] runningMedian(int[] arr) {
        double[] result = new double[arr.length];
        TreeSet<Item> set = new TreeSet<>();
        Item mid = null;

        for (int i = 0; i < arr.length; i++) {
            Item x = new Item(arr[i], i);
            set.add(x);
            int n = set.size();

            if (n == 1) {
                mid = x;
            }
            else if (x.compareTo(mid) < 0 && n % 2 == 0) {
                mid = set.lower(mid);
            }
            else if (x.compareTo(mid) > 0 && n % 2 == 1) {
                mid = set.higher(mid);
            }

            if (n % 2 == 1) {
                result[i] = mid.val;
            }
            else {
                result[i] = (mid.val + set.higher(mid).val) / 2.0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {12, 4, 5, 3, 8, 7};

        double[] medians = runningMedian(arr);
        for (double m : medians) {
            System.out.printf("%.1f%n", m);
        }
    }
}
