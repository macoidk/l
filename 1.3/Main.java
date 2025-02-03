import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);

        tree.add(new Student("Петренко", "Іван", 3, 1004, "чоловік", "гуртожиток"));
        tree.add(new Student("Коваленко", "Марія", 2, 1002, "жінка", "квартира"));
        tree.add(new Student("Сидоренко", "Петро", 3, 1006, "чоловік", "гуртожиток"));
        tree.add(new Student("Василенко", "Олег", 3, 1001, "чоловік", "квартира"));
        tree.add(new Student("Мельник", "Андрій", 3, 1003, "чоловік", "гуртожиток"));
        tree.add(new Student("Іваненко", "Ольга", 2, 1005, "жінка", "квартира"));
        tree.add(new Student("Бондар", "Ігор", 3, 1007, "чоловік", "гуртожиток"));

        System.out.println("\nРівень 1: Початковий стан дерева (обхід в ширину):");
        tree.printBreadthFirst();

        System.out.println("\nРівень 2: Пошук студентів");
        System.out.println("\nВведіть критерії пошуку:");

        int searchCourse = 0;
        boolean validCourse = false;
        while (!validCourse) {
            try {
                System.out.print("Курс (1-6): ");
                searchCourse = Integer.parseInt(scanner.nextLine());
                if (searchCourse < 1 || searchCourse > 6) {
                    throw new IllegalArgumentException("Курс повинен бути від 1 до 6");
                }
                validCourse = true;
            } catch (NumberFormatException e) {
                System.out.println("Помилка: Введіть число!");
            } catch (IllegalArgumentException e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }

        String searchGender = "";
        boolean validGender = false;
        while (!validGender) {
            System.out.print("Стать (ч/ж): ");
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "ч":
                    searchGender = "чоловік";
                    validGender = true;
                    break;
                case "ж":
                    searchGender = "жінка";
                    validGender = true;
                    break;
                default:
                    System.out.println("Помилка: Введіть 'ч' для чоловіка або 'ж' для жінки!");
            }
        }

        String searchResidence = "";
        boolean validResidence = false;
        while (!validResidence) {
            System.out.print("Місце проживання (г/к): ");
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "г":
                    searchResidence = "гуртожиток";
                    validResidence = true;
                    break;
                case "к":
                    searchResidence = "квартира";
                    validResidence = true;
                    break;
                default:
                    System.out.println("Помилка: Введіть 'г' для гуртожитку або 'к' для квартири!");
            }
        }

        List<Student> found = tree.searchStudents(searchCourse, searchGender, searchResidence);

        if (found.isEmpty()) {
            System.out.println("\nСтудентів за вказаними критеріями не знайдено.");
        } else {
            System.out.println("\nЗнайдені студенти:");
            System.out.println("Прізвище       Ім'я           Курс    Ст.квиток Стать    Проживання");
            System.out.println("----------------------------------------------------------------");
            for (Student student : found) {
                System.out.println(student.toString());
            }
        }

        System.out.println("\nРівень 3: Видалення знайдених студентів");
        System.out.println("Видаляємо студентів за тими ж критеріями...");
        tree.deleteStudents(searchCourse, searchGender, searchResidence);

        System.out.println("\nСтан дерева після видалення:");
        tree.printBreadthFirst();

        scanner.close();
    }
}
