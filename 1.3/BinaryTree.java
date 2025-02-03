import java.util.*;

public class BinaryTree {
    private TreeNode root;

    // Constructor
    public BinaryTree() {
        root = null;
    }

    // Add node to tree
    public void add(Student student) {
        root = addRecursive(root, student);
    }

    private TreeNode addRecursive(TreeNode current, Student student) {
        if (current == null) {
            return new TreeNode(student);
        }

        if (student.getStudentId() < current.getData().getStudentId()) {
            current.setLeft(addRecursive(current.getLeft(), student));
        } else if (student.getStudentId() > current.getData().getStudentId()) {
            current.setRight(addRecursive(current.getRight(), student));
        }

        return current;
    }

    // Breadth-first traversal
    public void printBreadthFirst() {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("\nПрізвище       Ім'я           Курс    Ст.квиток Стать    Проживання");
        System.out.println("----------------------------------------------------------------");

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println(current.getData().toString());

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }

    // Search for students by criteria (level 2)
    public List<Student> searchStudents(int course, String gender, String residence) {
        List<Student> result = new ArrayList<>();
        searchStudentsRecursive(root, course, gender, residence, result);
        return result;
    }

    private void searchStudentsRecursive(TreeNode current, int course,
                                         String gender, String residence,
                                         List<Student> result) {
        if (current == null) return;

        Student student = current.getData();
        if (student.getCourse() == course &&
                student.getGender().equals(gender) &&
                student.getResidence().equals(residence)) {
            result.add(student);
        }

        searchStudentsRecursive(current.getLeft(), course, gender, residence, result);
        searchStudentsRecursive(current.getRight(), course, gender, residence, result);
    }

    // Delete nodes by criteria (level 3)
    public void deleteStudents(int course, String gender, String residence) {
        root = deleteStudentsRecursive(root, course, gender, residence);
    }





    private TreeNode deleteStudentsRecursive(TreeNode current, int course,
                                             String gender, String residence) {
        if (current == null) return null;

        // Спочатку обробляємо дочірні вузли
        current.setLeft(deleteStudentsRecursive(current.getLeft(), course, gender, residence));
        current.setRight(deleteStudentsRecursive(current.getRight(), course, gender, residence));

        // Перевіряємо, чи поточний вузол підлягає видаленню
        Student student = current.getData();
        if (student.getCourse() == course &&
                student.getGender().equals(gender) &&
                student.getResidence().equals(residence)) {

            // Випадок 1: Вузол без дочірніх вузлів
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            // Випадок 2: Вузол має тільки один дочірній вузол
            if (current.getLeft() == null) {
                return current.getRight();
            }
            if (current.getRight() == null) {
                return current.getLeft();
            }

            // Випадок 3: Вузол має обидва дочірні вузли
            // Знаходимо найменший вузол у правому піддереві
            TreeNode successor = findMin(current.getRight());
            // Видаляємо наступника з правого піддерева
            current.setRight(deleteMin(current.getRight()));
            // Замінюємо поточний вузол наступником
            successor.setLeft(current.getLeft());
            successor.setRight(current.getRight());
            return successor;
        }

        return current;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.getLeft() == null) {
            return node.getRight();
        }
        node.setLeft(deleteMin(node.getLeft()));
        return node;
    }

}