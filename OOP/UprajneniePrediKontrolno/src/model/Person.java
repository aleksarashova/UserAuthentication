package model;

import error.CapitalLetterException;
import error.FirstNameLengthException;
import error.LastNameLengthException;

import javax.naming.NameAlreadyBoundException;

public abstract class Person {
    private final String firstName;
    private final String lastName;

    public Person(String firstName, String lastName)
            throws CapitalLetterException, FirstNameLengthException, LastNameLengthException
    {
        validateFirstName(firstName);
        validateLastName(lastName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private void validateFirstLetter(String name)
            throws CapitalLetterException
    {
        if(name.charAt(0) < 'A' || name.charAt(0) > 'Z')
            throw new error.CapitalLetterException();
    }

    private void validateLength(String name)
            throws FirstNameLengthException
    {
        if(name.length() < 4)
            throw new FirstNameLengthException();
    }

    private void validateFirstName(String fn)
            throws CapitalLetterException, FirstNameLengthException, LastNameLengthException
    {
        validateFirstLetter(fn);
        validateLength(fn);
    }

    private void validateLastName(String ln)
            throws CapitalLetterException, FirstNameLengthException, LastNameLengthException
    {
        validateFirstLetter(ln);
        validateLength(ln);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: ");
        sb.append(firstName).append("\n");
        sb.append("Surname: ");
        sb.append(lastName).append("\n");
        return sb.toString();
    }

}
