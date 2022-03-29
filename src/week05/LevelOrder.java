package week05;

class Node {
    public int key;
    public Node left, right;
    public Node (int item) {
        key = item;
    }
}

class BinaryTree {
    Node root;

    private BinaryTree() {
        root = null;
    }

    private int treeHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = treeHeight(root.left);
            int rightHeight = treeHeight(root.right);

            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }

    private void levelOrderTraversal() {
        int height = treeHeight(root);
        for (int i = 1; i <= height; ++i) {
            printCurrLevel(root, i);
        }
    }

    private void printCurrLevel(Node root, int currLevel) {
        if (root == null) {
            return;
        }

        if (currLevel == 1) {
            System.out.println(root.key);
        }

        if (currLevel > 1) {
            printCurrLevel(root.left, currLevel - 1);
            printCurrLevel(root.right, currLevel - 1);
        }
    }

    /**
     * Test cases
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.levelOrderTraversal();
    }
}
