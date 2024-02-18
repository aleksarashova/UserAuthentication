package model;

import error.CapitalLetterException;
import error.FacultyNumberException;
import error.FirstNameLengthException;
import error.LastNameLengthException;

import java.nio.file.FileSystemAlreadyExistsException;

public class Student extends Person {
    private final String facultyNumber;

    private void validateFacultyNumber(String facultyNumber)
            throws FacultyNumberException
    {
        if(facultyNumber.length() < 5 || facultyNumber.length() > 10)
            throw new FacultyNumberException();
    }

    public Student(String firstName, String lastName, String facultyNumber)
            throws CapitalLetterException, FirstNameLengthException, LastNameLengthException, FacultyNumberException
    {
        super(firstName, lastName);
        validateFacultyNumber(facultyNumber);
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("*** Student\n").append(super.toString());
        sb.append("Faculty Number: ").append(facultyNumber).append("\n");
        return sb.toString();
    }
}
