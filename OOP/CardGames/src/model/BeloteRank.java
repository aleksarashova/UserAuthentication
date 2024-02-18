package model;

public class BeloteRank {
        public static Rank Seven = new Rank(1, "Seven", "7");
        public static Rank Eight = new Rank(2, "Eight", "8");
        public static Rank Nine = new Rank(3, "Nine", "9");
        public static Rank Ten = new Rank(4, "Ten", "10");
        public static Rank Jack = new Rank(5, "Jack", "J");
        public static Rank Queen = new Rank(6, "Queen", "Q");
        public static Rank King = new Rank(7, "King", "K");
        public static Rank Ace = new Rank(8, "Ace", "A");

        public static Rank[] ranks = {Seven, Eight, Nine, Ten, Jack, Queen, King, Ace};

        public static Rank[] values() {return ranks;}

}
