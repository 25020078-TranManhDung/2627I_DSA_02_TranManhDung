import java.util.NoSuchElementException;

public class ResizingArrayQueueOfStrings {
    private String[] q;
    private int n;
    private int first;
    private int last;

    public ResizingArrayQueueOfStrings() {
        q = new String[2];
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

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = q[(first + i) % q.length];
        }
        q = copy;
        first = 0;
        last = n;
    }

    public void enqueue(String item) {
        if (n == q.length) resize(2 * q.length);

        q[last] = item;
        last = (last + 1) % q.length; //Quay vòng
        n++;
    }

    public String dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue rỗng");

        String item = q[first];
        q[first] = null;
        n--;
        first = (first + 1) % q.length;

        if (n > 0 && n == q.length / 4) resize(q.length / 2);

        return item;
    }
}
