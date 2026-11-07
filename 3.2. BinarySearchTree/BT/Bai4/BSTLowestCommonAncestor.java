public class BSTLowestCommonAncestor<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node right, left;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    public Key lca(Key v1, Key v2) {
        Node ancestor = lca(root, v1, v2);
        return ancestor != null ? ancestor.key : null;
    }

    private Node lca(Node x, Key v1, Key v2) {
        if (x == null) return null;
        int cmp1 = v1.compareTo(x.key);
        int cmp2 = v2.compareTo(x.key);

        if (cmp1 < 0 && cmp2 < 0) {
            return lca(x.left, v1, v2);
        }

        if (cmp1 > 0 && cmp2 > 0) {
            return lca(x.right, v1, v2);
        }

        return x;
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

    public static void main(String[] args) {
        BSTLowestCommonAncestor<Integer, String> bst = new BSTLowestCommonAncestor<>();

        bst.put(4, "Node 4");
        bst.put(2, "Node 2");
        bst.put(7, "Node 7");
        bst.put(1, "Node 1");
        bst.put(3, "Node 3");
        bst.put(6, "Node 6");

        // Tìm LCA của 1 và 7 (Kỳ vọng: 4)
        System.out.println("LCA của 1 và 7 là: " + bst.lca(1, 7));

        // Tìm LCA của 1 và 3 (Kỳ vọng: 2)
        System.out.println("LCA của 1 và 3 là: " + bst.lca(1, 3));
    }
}
