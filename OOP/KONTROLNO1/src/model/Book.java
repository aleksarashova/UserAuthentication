package model;

public class Book {
    private final String name;
    private final Author author;

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    protected Author getAuthor() {
        return this.author;
    }
}
