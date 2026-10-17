class PriorityQueue {
    private int[] q;
    private int M;

    public PriorityQueue(int K) {
        q = new int[K];
        M = 0;
    }

    public void insert(int val) {
        if (M >= q.length) {
            System.out.println("Hàng đợi đã đầy!");
            return;
        }
        q[M] = val;
        M++;
    }

    public int deleteMin() {
        if (M == 0) {
            throw new RuntimeException("Hàng đợi rỗng!");
        }

        int minIdx = 0;
        for (int i = 1; i < M; i++) {
            if (q[i] < q[minIdx]) {
                minIdx = i;
            }
        }

        int minValue = q[minIdx];

        q[minIdx] = q[M - 1];
        M--;

        return minValue;
    }
}
