public class ShellSorter {
    // Knuth sequence Shell sort (Level 1)
    public static void sortKnuth(Student[] students) {
        int n = students.length;

        // Calculate initial gap using Knuth sequence
        int gap = 1;
        while (gap <= n/9) {
            gap = 3 * gap + 1;
        }

        // Sort array using calculated gap
        while (gap > 0) {
            // Insertion sort with gap
            for (int i = gap; i < n; i++) {
                Student temp = students[i];
                int j = i;

                // Compare elements with gap
                while (j >= gap && students[j - gap].getGroupNumber() > temp.getGroupNumber()) {
                    students[j] = students[j - gap];
                    j -= gap;
                }
                students[j] = temp;
            }
            gap /= 3;
        }
    }

    // Shell's original sequence (Level 2)
    public static void sortShell(Student[] students) {
        int n = students.length;

        // Start with n/2 gap and reduce by half each time
        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Student temp = students[i];
                int j = i;

                // Primary sort by group number
                while (j >= gap && (students[j - gap].getGroupNumber() > temp.getGroupNumber() ||
                        (students[j - gap].getGroupNumber() == temp.getGroupNumber() &&
                                students[j - gap].getStudentId().compareTo(temp.getStudentId()) > 0))) {
                    students[j] = students[j - gap];
                    j -= gap;
                }
                students[j] = temp;
            }
        }
    }
}