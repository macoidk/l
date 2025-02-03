public class BST {
    protected Node root;

    protected class Node {
        protected Student data;
        protected Node left, right;

        protected Node(Student student) {
            this.data = student;
            left = right = null;
        }
    }

    // Insert at root with rotation
    public void insert(Student student) {
        root = insertAtRoot(root, student);
    }

    protected Node insertAtRoot(Node node, Student student) {
        if (node == null) {
            return new Node(student);
        }

        if (student.getCityCode() < node.data.getCityCode()) {
            node.left = insertAtRoot(node.left, student);
            return rotateRight(node);
        } else {
            node.right = insertAtRoot(node.right, student);
            return rotateLeft(node);
        }
    }

    // Right rotation
    protected Node rotateRight(Node y) {
        if (y == null || y.left == null) return y;
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        return x;
    }

    // Left rotation
    protected Node rotateLeft(Node x) {
        if (x == null || x.right == null) return x;
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        return y;
    }

    // Search by city code
    public Student search(int cityCode) {
        Node result = searchRec(root, cityCode);
        return result == null ? null : result.data;
    }

    private Node searchRec(Node root, int cityCode) {
        if (root == null || root.data.getCityCode() == cityCode)
            return root;

        if (cityCode < root.data.getCityCode())
            return searchRec(root.left, cityCode);

        return searchRec(root.right, cityCode);
    }

    // Level order traversal
    public void levelOrderTraversal() {
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printLevel(root, i);
            System.out.println();
        }
    }

    protected int height(Node root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    protected void printLevel(Node root, int level) {
        if (root == null) return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    protected Node getRoot() {
        return root;
    }

    protected void setRoot(Node newRoot) {
        root = newRoot;
    }
}