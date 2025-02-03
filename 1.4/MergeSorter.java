public class MergeSorter {
    // Bottom-up merge sort (Level 3)
    public static void bottomUpMergeSort(Student[] students) {
        int n = students.length;
        Student[] temp = new Student[n];

        // Iterate through different size subarrays
        for (int width = 1; width < n; width = 2 * width) {
            // Merge subarrays of current width
            for (int i = 0; i < n; i = i + 2 * width) {
                bottomUpMerge(students, i, Math.min(i + width, n),
                        Math.min(i + 2 * width, n), temp);
            }
            // Copy merged subarrays back to original array
            System.arraycopy(temp, 0, students, 0, n);
        }
    }

    private static void bottomUpMerge(Student[] a, int left, int right, int end, Student[] temp) {
        int i = left;
        int j = right;

        // Merge the two parts into temp array
        for (int k = left; k < end; k++) {
            if (i < right && (j >= end || a[i].getGroupNumber() <= a[j].getGroupNumber())) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
        }
    }
}