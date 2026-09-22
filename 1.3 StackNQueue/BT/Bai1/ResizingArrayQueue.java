public class ResizingArrayQueue<Item> {
    private Item[] q;
    private int n;
    private int first;
    private int last;

    public ResizingArrayQueue() {
        q = (Item[]) new Object[8];
        n = 0;
        first = 0;
        last = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = q[(first + i) % q.length];
        }
        q = copy;
        first = 0;
        last = n;
    }

    public void enqueue(Item item) {
        if (n == q.length) {
            resize(2 * q.length);
        }

        q[last++] = item;

        if (last == q.length) {
            last = 0;    // quay vòng
        }
        n++;
    }

    public Item dequeue() {
        Item item = q[first];
        q[first] = null;
        n--;
        first++;

        if (first == q.length) {
            first = 0;      // quay vòng
        }

        if (n > 0 && n == q.length / 4) {
            resize(q.length / 2);
        }
        return item;
    }
}
