public class BSTInsertion<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left,right;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    public void putRecursive(Key key, Value val) {
        root = putRecursive(root, key, val);
    }

    private Node putRecursive(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val);

        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = putRecursive(x.left, key, val);
        else if (cmp > 0) x.right = putRecursive(x.right, key, val);
        else x.val = val;

        return x;
    }

    public void putIterative(Key key, Value val) {
        if (root == null) {
            root = new Node(key, val);
            return;
        }

        Node current = root;
        while (true) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0) {
                if (current.left == null) {
                    current.left = new Node(key, val);
                    return;
                }
                current = current.left;
            }
            else if (cmp > 0) {
                if (current.right == null) {
                    current.right = new Node(key, val);
                    return;
                }
                current = current.right;
            }
            else {
                current.val = val;
                return;
            }
        }
    }

    public Iterable<Key> keys() {
        java.util.Queue<Key> queue = new java.util.LinkedList<>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node x, java.util.Queue<Key> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.add(x.key);
        inorder(x.right, q);
    }

    public static void main(String[] args) {
        BSTInsertion<String, Integer> st = new BSTInsertion<>();

        // Test Cách 1
        st.putRecursive("S", 1);
        st.putRecursive("E", 2);
        st.putRecursive("A", 3);
        st.putRecursive("R", 4);

        // Test Cách 2
        st.putIterative("C", 5);
        st.putIterative("H", 6);

        // Cập nhật lại giá trị của khóa "E" bằng Cách 2
        st.putIterative("E", 100);

        System.out.println("Các khóa theo thứ tự (In-order):");
        for (String s : st.keys()) {
            System.out.print(s + " ");
        }
    }
}
