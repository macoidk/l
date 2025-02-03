public class AmortizedBST extends BST {
    private int insertions = 0;
    private static final int REBUILD_THRESHOLD = 4  ; // Arbitrary threshold

    @Override
    public void insert(Student student) {
        super.insert(student);
        insertions++;

        // Perform amortized rebuilding
        if (insertions >= REBUILD_THRESHOLD) {
            rebuild();
            insertions = 0;
        }
    }

    private void rebuild() {
        // Store all nodes in sorted order
        java.util.ArrayList<Student> nodes = new java.util.ArrayList<>();
        storeInorder(getRoot(), nodes);

        // Rebuild tree with median as root
        setRoot(rebuildBalanced(nodes, 0, nodes.size() - 1));
    }

    private Node rebuildBalanced(java.util.ArrayList<Student> nodes, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node node = new Node(nodes.get(mid));

        node.left = rebuildBalanced(nodes, start, mid - 1);
        node.right = rebuildBalanced(nodes, mid + 1, end);

        return node;
    }

    private void storeInorder(Node node, java.util.ArrayList<Student> nodes) {
        if (node == null) return;
        storeInorder(node.left, nodes);
        nodes.add(node.data);
        storeInorder(node.right, nodes);
    }
}