package model;

public class Rank {
    private final int index;
    private final String name;
    private final String letter;

    public Rank(int index, String name, String letter) {
        this.index = index;
        this.name = name;
        this.letter = letter;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getLetters() {
        return letter;
    }

    public int compareTo(Rank rank) {
        return index - rank.getIndex();
    }
}
