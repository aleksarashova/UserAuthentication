package model;

public class Manga extends Book {
    private final String artist;

    enum Style {
        Chibi, Cartoonish, MOE, Realistic, Shounen
    }
    Style style;

    public Manga(String name, Author author, String artist, Style style) {
        super(name, author);
        this.artist = artist;
        this.style = style;
    }

    protected Style getStyle() {
        return this.style;
    }
}
