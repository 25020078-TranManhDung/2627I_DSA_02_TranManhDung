import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> {
    private Item[] s;
    private int n;

    public ResizingArrayStack() {
        s = (Item[]) new Object[8];
        n = 0;
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
            copy[i] = s[i];
        }
        s = copy;
    }

    public void push(Item item) {
        if (n == s.length) {
            resize(2 * s.length);
        }
        s[n++] = item;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack rỗng");

        Item item = s[n - 1];
        s[n-1] = null;
        n--;

        if (n > 0 && n == s.length / 4) {
            resize(s.length / 2);
        }

        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return s[n - 1];
    }
}
