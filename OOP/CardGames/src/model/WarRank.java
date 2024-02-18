package model;

import model.Rank;

public class WarRank {

    public static Rank[] values() {
        return new Rank[]{
                new Rank(1, "Two", "2"),
                new Rank(2, "Three", "3"),
                new Rank(3, "Four", "4"),
                new Rank(4, "Five", "5"),
                new Rank(5, "Six", "6"),
                new Rank(6, "Seven", "7"),
                new Rank(7, "Eight", "8"),
                new Rank(8, "Nine", "9"),
                new Rank(9, "Ten", "10"),
                new Rank(10, "Jack", "J"),
                new Rank(11, "Queen", "Q"),
                new Rank(12, "King", "K"),
                new Rank(13, "Ace", "A")
        };
    }
}
