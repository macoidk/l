public class Student {
    private String lastName;
    private String firstName;
    private int course;
    private int studentId;
    private String gender;
    private String residence;

    // Constructor
    public Student(String lastName, String firstName, int course,
                   int studentId, String gender, String residence) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
        this.studentId = studentId;
        this.gender = gender;
        this.residence = residence;
    }

    // Getters
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public int getCourse() { return course; }
    public int getStudentId() { return studentId; }
    public String getGender() { return gender; }
    public String getResidence() { return residence; }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-7d %-10d %-8s %-15s",
                lastName, firstName, course, studentId, gender, residence);
    }
}