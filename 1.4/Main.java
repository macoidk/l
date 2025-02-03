public class Main {
    public static void main(String[] args) {
        // Level 1: Knuth Shell Sort
        Student[] studentsLevel1 = createTestData();
        System.out.println("Рівень 1 - Сортування Шелла (за Кнутом)");
        System.out.println("До сортування:");
        printArray(studentsLevel1);

        ShellSorter.sortKnuth(studentsLevel1);

        System.out.println("\nПісля сортування:");
        printArray(studentsLevel1);

        // Level 2: Shell's original sort
        Student[] studentsLevel2 = createTestData();
        System.out.println("\nРівень 2 - Сортування Шелла (оригінальний алгоритм)");
        System.out.println("До сортування:");
        printArray(studentsLevel2);

        ShellSorter.sortShell(studentsLevel2);

        System.out.println("\nПісля сортування:");
        printArray(studentsLevel2);

        // Level 3: Bottom-up merge sort
        Student[] studentsLevel3 = createTestData();
        System.out.println("\nРівень 3 - Сортування злиттям (висхідне)");
        System.out.println("До сортування:");
        printArray(studentsLevel3);

        MergeSorter.bottomUpMergeSort(studentsLevel3);

        System.out.println("\nПісля сортування:");
        printArray(studentsLevel3);
    }

    private static Student[] createTestData() {
        return new Student[]{
                new Student("Петренко", "Іван", 201, "ST001"),
                new Student("Іваненко", "Петро", 203, "ST002"),
                new Student("Сидоренко", "Марія", 201, "ST003"),
                new Student("Коваленко", "Олена", 202, "ST004"),
                new Student("Бондаренко", "Андрій", 203, "ST005"),
                new Student("Мельник", "Софія", 202, "ST006")
        };
    }

    private static void printArray(Student[] students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
