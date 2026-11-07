import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        return x;
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedList<Key>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node x, Queue<Key> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }

    //Cách 1
    public boolean isBST() {
        Queue<Key> q = new LinkedList<Key>();
        inorder(root, q);

        Key prev = null;
        for (Key k : q) {
            if (prev != null && k.compareTo(prev) <= 0) return false;
            prev = k;
        }
        return true;
    }

    //Cách 2

    public boolean isBST2() {
        return isBST2(root, null, null);
    }

    public boolean isBST2(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST2(x.left, min, x.key)
                && isBST2(x.right, x.key, max);
    }

    private Node node(Key k, Node l, Node r) {
        Node n = new Node(k, null);
        n.left = l;
        n.right = r;
        return n;
    }

    public static void main(String[] args) {
        // Test 1: BST dựng bằng put
        BST<String, Integer> st = new BST<String, Integer>();
        String[] a = "S E A R C H E X A M P L E".split(" ");
        for (int i = 0; i < a.length; i++) st.put(a[i], i);

        StringBuilder sb = new StringBuilder();
        for (String s : st.keys()) sb.append(s).append(' ');
        System.out.println("In-order : " + sb.toString().trim());
        System.out.println("Test 1 (BST dựng bằng put)  -> isBST = " + st.isBST()
                + ", isBST2 = " + st.isBST2() + "   (mong đợi: true, true)");

        // Test 2: cây hợp lệ  3(2(1), 5(4, 6))
        BST<Integer, Integer> t2 = new BST<Integer, Integer>();
        t2.root = t2.node(3,
                t2.node(2, t2.node(1, null, null), null),
                t2.node(5, t2.node(4, null, null), t2.node(6, null, null)));
        System.out.println("Test 2 (cây hợp lệ)         -> isBST = " + t2.isBST()
                + ", isBST2 = " + t2.isBST2() + "   (mong đợi: true, true)");

        // Test 3: sai - 4 nằm ở cây con trái của 3 nhưng lại lớn hơn 3
        BST<Integer, Integer> t3 = new BST<Integer, Integer>();
        t3.root = t3.node(3,
                t3.node(2, t3.node(1, null, null), t3.node(4, null, null)),
                t3.node(5, null, null));
        System.out.println("Test 3 (4 lệch bên trái 3)  -> isBST = " + t3.isBST()
                + ", isBST2 = " + t3.isBST2() + "   (mong đợi: false, false)");

        // Test 4: sai - giá trị trùng nhau
        BST<Integer, Integer> t4 = new BST<Integer, Integer>();
        t4.root = t4.node(2, t4.node(2, null, null), t4.node(3, null, null));
        System.out.println("Test 4 (key trùng)          -> isBST = " + t4.isBST()
                + ", isBST2 = " + t4.isBST2() + "   (mong đợi: false, false)");

        // Test 5: cây rỗng
        BST<Integer, Integer> t5 = new BST<Integer, Integer>();
        System.out.println("Test 5 (cây rỗng)           -> isBST = " + t5.isBST()
                + ", isBST2 = " + t5.isBST2() + "   (mong đợi: true, true)");
    }
}
