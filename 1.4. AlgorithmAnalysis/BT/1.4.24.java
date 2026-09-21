public class EggDrop {

    // Giả lập hàm thả trứng, trả về true nếu trứng vỡ
    private static boolean dropEgg(int floor, int F) {
        return floor >= F;
    }

    public static int findF(int N, int F_secret) {
        // Giai đoạn 1: Search
        int k = 0;
        int floor = 1;

        while (floor <= N && !dropEgg(floor, F_secret)) {
            k++;
            floor = (int) Math.pow(2, k); // Nhảy 1, 2, 4, 8...
        }

        // Đảm bảo biên không vượt quá N
        int hi = Math.min(floor, N);
        int lo = (int) Math.pow(2, Math.max(0, k - 1));

        // Giai đoạn 2: Binary Search trong khoảng [lo, hi]
        int resultF = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (dropEgg(mid, F_secret)) {
                resultF = mid;
                hi = mid - 1; // Thử tìm tầng thấp hơn
            } else {
                lo = mid + 1; // Thử tầng cao hơn
            }
        }
        return resultF;
    }
}
