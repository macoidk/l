public class TreeNode {
    private Student data;
    private TreeNode left;
    private TreeNode right;

    // Constructor
    public TreeNode(Student student) {
        this.data = student;
        left = right = null;
    }

    // Getters and setters
    public Student getData() { return data; }
    public TreeNode getLeft() { return left; }
    public TreeNode getRight() { return right; }
    public void setLeft(TreeNode left) { this.left = left; }
    public void setRight(TreeNode right) { this.right = right; }
}