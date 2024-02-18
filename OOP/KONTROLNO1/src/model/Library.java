package model;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> books;

    public Library(ArrayList<Book> books) {
        this.books = new ArrayList<>();
        this.books.addAll(books);
    }

    public ArrayList<Book> findByAuthorName(String tmp) {
        ArrayList<Book> books = new ArrayList<>();
        for (int i = 0; i < this.books.size(); i++) {
            Author author = this.books.get(i).getAuthor();
            if (author.getFirstName().contains(tmp) || author.getLastName().contains(tmp))
                books.add(this.books.get(i));
        }

        return books;
    }

    public ArrayList<Manga> findByArtStyle(Manga.Style style) {
        ArrayList<Manga> mangas = new ArrayList<>();
        for (int i = 0; i < this.books.size(); i++) {
            Author author = this.books.get(i).getAuthor();
            if(this.books.get(i) instanceof Manga) {
                Manga manga = (Manga) this.books.get(i);
                if(manga.getStyle().equals(style))
                    mangas.add(manga);
            }
        }
        return mangas;
    }
}
