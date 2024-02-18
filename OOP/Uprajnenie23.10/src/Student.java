public class Student extends Person {
    private String facultyNumber;

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        validateFacultyNumber(facultyNumber);
        this.facultyNumber = facultyNumber;
    }

    private void validateFacultyNumber(String facultyNumber) {
        int len = facultyNumber.length();
        if(len < 5 || len > 10) {
            throw new IllegalArgumentException("Invalid faculty number - length must be between 5 and 10 symbols.");
        }
    }

    public Student(String firstName, String surname, String facultyNumber) {
        super(firstName, surname);
        setFacultyNumber(facultyNumber);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("*** Student\n");
        sb.append(super.toString());
        sb.append("\nFaculty Number: ");
        sb.append(facultyNumber);
        return sb.toString();
    }
}
