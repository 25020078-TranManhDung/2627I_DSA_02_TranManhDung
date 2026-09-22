import java.util.NoSuchElementException;

public class LinkedListQueue<Item> {
    private Node first;
    private Node last;
    private int n;

    public class Node {
        private Item item;
        private Node next;
    }

    public LinkedListQueue() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue rỗng");
        return first.item;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue rỗng");
        Item item = first.item;
        first = first.next;
        n--;

        if (isEmpty()) {
            last = null;
        }

        return item;
    }
}
