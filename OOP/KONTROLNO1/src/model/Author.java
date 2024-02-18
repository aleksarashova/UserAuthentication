package model;
import java.util.ArrayList;

public class Author extends Person {
    ArrayList<Book> books;

    public Author(String firstName, String lastName, int age, ArrayList<Book> books) {
        super(firstName, lastName, age);
        this.books = new ArrayList<>();
        this.books.addAll(books);
    }
}
