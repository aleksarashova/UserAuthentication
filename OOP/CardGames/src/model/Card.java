package model;

public class Card implements Comparable<Card> {
    @Override
    public int compareTo(Card c) {
        int r = suit.compareTo(c.getSuit());
        if (r!=0) return  r;
        return rank.compareTo(c.getRank());
    }

    public enum Suit {
        SPADES("S"), HEARTS("H"), DIAMONDS("D"), CLUBS("C");
        Suit(String letter) {
            this.letter = letter;
        }

        private final String letter;

        public String getLetter() {
            return letter;
        }


    }

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return suit.getLetter()+rank.getLetters();
    }
}
