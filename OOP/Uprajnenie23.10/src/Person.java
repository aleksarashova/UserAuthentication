public abstract class Person {
    private String firstName = "";
    private String surname = "";
    private static final int minLenForFirstName = 4;
    private static final int minLenForLastName = 3;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        validateSurname(surname);
        this.surname = surname;
    }

    private void validateFirstLetter(char firstLetter) {
        if (firstLetter < 'A' || firstLetter > 'Z') {
            throw new IllegalArgumentException("Invalid name - must start with upper case letter.");
        }
    }

    private void validateFirstName(String firstName) {
        validateFirstLetter(firstName.charAt(0));
        if (firstName.length() < minLenForFirstName) {
            throw new IllegalArgumentException("Invalid name - expected length at least 4 symbols.");
        }
    }

    private void validateSurname(String surname) {
        validateFirstLetter(surname.charAt(0));
        if (surname.length() < minLenForLastName) {
            throw new IllegalArgumentException("Invalid name - expected length at least 3 symbols.");
        }
    }

    public Person(String firstName, String surname) {
        setFirstName(firstName);
        setSurname(surname);
    }

    public String toString() {
        return "First Name: " + firstName + "\n" + "Surname: " + surname;
    }
}
