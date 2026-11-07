public class W9_25020078 {

    static class TreeNode {
        int data;
        TreeNode firstChild;
        TreeNode nextSibling;

        public TreeNode(int data) {
            this.data = data;
            this.firstChild = null;
            this.nextSibling = null;
        }
    }

    TreeNode root;

    public W9_25020078(int rootData) {
        this.root = new TreeNode(rootData);
    }

    public TreeNode getFirstChild(TreeNode node) {
        if (node == null) return null;
        return node.firstChild;
    }

    public TreeNode getNextSibling(TreeNode node) {
        if (node == null) return null;
        return node.nextSibling;
    }

    public TreeNode getParent(TreeNode currentNode, TreeNode targetNode) {
        if (currentNode == null || targetNode == null || currentNode == targetNode) {
            return null;
        }

        TreeNode child = currentNode.firstChild;
        while (child != null) {
            if (child == targetNode) {
                return currentNode;
            }

            TreeNode foundParent = getParent(child, targetNode);
            if (foundParent != null) {
                return foundParent;
            }

            child = child.nextSibling;
        }
        return null;
    }

    public static void main(String[] args) {
        W9_25020078 tree = new W9_25020078(10);

        TreeNode node5 = new TreeNode(5);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20);

        tree.root.firstChild = node5;
        node5.nextSibling = node15;
        node15.nextSibling = node20;

        TreeNode node3 = new TreeNode(3);
        node5.firstChild = node3;

        System.out.println(tree.getFirstChild(tree.root).data);
        System.out.println(tree.getNextSibling(node5).data);

        TreeNode parentOf3 = tree.getParent(tree.root, node3);
        if (parentOf3 != null) {
            System.out.println(parentOf3.data);
        }
    }
}
