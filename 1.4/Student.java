public class Student {
    private String lastName;
    private String firstName;
    private int groupNumber;
    private String studentId;

    // Constructor
    public Student(String lastName, String firstName, int groupNumber, String studentId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.groupNumber = groupNumber;
        this.studentId = studentId;
    }

    // Getters
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public String getStudentId() {
        return studentId;
    }

    // toString method for printing student information
    @Override
    public String toString() {
        return String.format("Group: %d, ID: %s, Name: %s %s",
                groupNumber, studentId, lastName, firstName);
    }
}