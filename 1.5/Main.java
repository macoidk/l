public class Main {
    public static void main(String[] args) {
        // Test first level
        System.out.println("====== Тестування першого рівня - Масив ======");
        StudentArray array = new StudentArray();

        // Add some test students
        array.addStudent(new Student("Петренко", "Іван", 1, 32, false));
        array.addStudent(new Student("Іваненко", "Петро", 2, 44, true));
        array.addStudent(new Student("Сидоренко", "Марія", 1, 32, false));
        array.addStudent(new Student("Коваленко", "Олена", 3, 56, true));

        System.out.println("Початковий масив:");
        array.printArray();

        System.out.println("\nВидалення студентів зі Львова без телефону:");
        array.removeStudents();
        array.printArray();

        // Test second level - BST implementation
        System.out.println("\n====== Тестування другого рівня - BST ======");
        BST bst = new BST();

        // Adding students to BST
        bst.insert(new Student("Петренко", "Іван", 1, 32, false));
        bst.insert(new Student("Іваненко", "Петро", 2, 44, true));
        bst.insert(new Student("Сидоренко", "Марія", 1, 56, false));
        bst.insert(new Student("Коваленко", "Олена", 3, 28, true));

        System.out.println("Вміст BST (обхід в ширину):");
        bst.levelOrderTraversal();

        // Demonstrating search by key (city code)
        System.out.println("\nПошук студента за кодом міста");
        Student found = bst.search(56);
        if (found != null) {
            System.out.println("Знайдено: " + found);
        } else {
            System.out.println("Студента з таким кодом міста не знайдено");
        }

        System.out.println("\nПошук студента за кодом міста 99 (неіснуючий):");
        found = bst.search(99);
        if (found != null) {
            System.out.println("Знайдено: " + found);
        } else {
            System.out.println("Студента з таким кодом міста не знайдено");
        }

        // Test third level - Amortized BST
        System.out.println("\n====== Демонстрація амортизації ======");
        BST regularBst = new BST();
        AmortizedBST amortizedBst = new AmortizedBST();

        // Додаємо елементи в зростаючому порядку (worst case для BST)
        System.out.println("Додавання елементів в зростаючому порядку:");
        for (int i = 0; i < 10; i++) {
            Student student = new Student(
                    "Student" + i, "Name" + i,
                    1, i * 10 + 10, true
            );

            System.out.println("\nДодавання студента з кодом міста: " + (i * 10 + 10));

            regularBst.insert(student);
            System.out.println("Висота звичайного BST: " + regularBst.height(regularBst.getRoot()));

            amortizedBst.insert(student);
            System.out.println("Висота амортизованого BST: " + amortizedBst.height(amortizedBst.getRoot()));
        }

        System.out.println("\n=== Фінальне порівняння ===");
        System.out.println("Висота звичайного BST: " + regularBst.height(regularBst.getRoot()));
        System.out.println("Висота амортизованого BST: " + amortizedBst.height(amortizedBst.getRoot()));



    }
}
