import java.util.*;
public class War {
    public static List<Card> createWarDeck() {
        List<Card> warDeck = new ArrayList<>();

        for (Deck.Paint paint : Deck.Paint.values()) {
            for (Deck.Rank rank : Deck.Rank.values()) {
                Card card = new Card(paint, rank);
                warDeck.add(card);
            }
        }

        return warDeck;
    }
}
