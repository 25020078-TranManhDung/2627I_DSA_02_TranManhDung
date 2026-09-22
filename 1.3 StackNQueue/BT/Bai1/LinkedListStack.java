import java.util.NoSuchElementException;

public class LinkedListStack<Item> {
    private Node first;
    private int n;

    public class Node {
        private Item item;
        private Node next;
    }

    public LinkedListStack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack rỗng");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack rỗng");
        return first.item;
    }
}
