public class StudentArray {
    private Student[] students;
    private int size;
    private static final int MAX_SIZE = 30;

    // Constructor
    public StudentArray() {
        students = new Student[MAX_SIZE];
        size = 0;
    }

    // Add student in sorted order by city code
    public void addStudent(Student student) {
        if (size >= MAX_SIZE) {
            System.out.println("Array is full");
            return;
        }

        // Find position to insert new student
        int insertPos = 0;
        while (insertPos < size && students[insertPos].getCityCode() < student.getCityCode()) {
            insertPos++;
        }

        // Shift elements to make space
        for (int i = size; i > insertPos; i--) {
            students[i] = students[i-1];
        }

        // Insert new student
        students[insertPos] = student;
        size++;
    }

    // Sequential search implementation
    public Student[] findStudents(int cityCode, int course, boolean hasHomePhone) {
        Student[] result = new Student[size];
        int resultSize = 0;

        for (int i = 0; i < size; i++) {
            if (students[i].getCityCode() == cityCode &&
                    students[i].getCourse() == course &&
                    students[i].hasHomePhone() == hasHomePhone) {
                result[resultSize++] = students[i];
            }
        }

        // Create array of exact size
        Student[] trimmedResult = new Student[resultSize];
        System.arraycopy(result, 0, trimmedResult, 0, resultSize);
        return trimmedResult;
    }

    // Remove students from Lviv (code 032) who are first-year and don't have home phone
    public void removeStudents() {
        Student[] newArray = new Student[MAX_SIZE];
        int newSize = 0;

        for (int i = 0; i < size; i++) {
            if (!(students[i].getCityCode() == 32 &&
                    students[i].getCourse() == 1 &&
                    !students[i].hasHomePhone())) {
                newArray[newSize++] = students[i];
            }
        }

        students = newArray;
        size = newSize;
    }

    // Print array contents
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.println(students[i]);
        }
    }
}