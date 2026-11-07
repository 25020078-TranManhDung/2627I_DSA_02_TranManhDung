public class AVLTree<Key extends  Comparable<Key>, Value> {
    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int height;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
            this.height = 1;
        }
    }

    private int height(Node n) {
        if (n == null) return 0;
        return n.height;
    }

    private int getBalance(Node n) {
        if (n == null) return 0;
        return height(n.left) - height(n.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    public Node put(Node node, Key key, Value val) {
        if (node == null) {
            return new Node(key, val);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key.compareTo(node.left.key) < 0) {
            return rightRotate(node);
        }

        if (balance < -1 && key.compareTo(node.right.key) > 0) {
            return leftRotate(node);
        }

        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public Iterable<Key> keys() {
        java.util.Queue<Key> queue = new java.util.LinkedList<>();
        inOrder(root, queue);
        return queue;
    }

    private void inOrder(Node x, java.util.Queue<Key> q) {
        if (x == null) return;
        inOrder(x.left, q);
        q.add(x.key);
        inOrder(x.right, q);
    }

    public static void main(String[] args) {
        AVLTree<String, Integer> st = new AVLTree<>();

        st.put("S", 1);
        st.put("E", 2);
        st.put("A", 3); // Tại đây xảy ra mất cân bằng Trái-Trái
        st.put("R", 4);
        st.put("C", 5);
        st.put("H", 6);

        System.out.println("Các khóa trong cây AVL (In-order):");
        for (String s : st.keys()) {
            System.out.print(s + " ");
        }
    }
}
