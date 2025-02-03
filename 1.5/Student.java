public class Student {
    private String lastName;
    private String firstName;
    private int course;
    private int cityCode;
    private boolean hasHomePhone;

    // Constructor
    public Student(String lastName, String firstName, int course, int cityCode, boolean hasHomePhone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
        this.cityCode = cityCode;
        this.hasHomePhone = hasHomePhone;
    }

    // Getters and setters
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getCourse() {
        return course;
    }

    public int getCityCode() {
        return cityCode;
    }

    public boolean hasHomePhone() {
        return hasHomePhone;
    }

    @Override
    public String toString() {
        return String.format("Student{lastName='%s', firstName='%s', course=%d, cityCode=%d, hasHomePhone=%b}",
                lastName, firstName, course, cityCode, hasHomePhone);
    }
}