import model.Card;
import model.Rank;

import java.util.ArrayList;
import java.util.Collections;
public abstract class Game {
    protected ArrayList<Card> deck = new ArrayList<>();
    protected ArrayList<Card> hand = new ArrayList<>();

    //public abstract void makeDeck();

    protected void makeDeck(Rank[] ranks) {
        deck = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Rank rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public int getSize() {
        return this.deck.size();
    }

    public Card removeTopCard() {
        validateEnoughCards();
        Card tmp = this.deck.remove(0);
        return tmp;
    }

    public Card removeBottomCard() {
        validateEnoughCards();
        Card tmp = this.deck.remove(this.deck.size() - 1);
        return tmp;
    }

    public Card getTopCard() {
        validateEnoughCards();
        return this.deck.get(0);
    }

    public Card getBottomCard() {
        validateEnoughCards();
        return this.deck.get(this.deck.size() - 1);
    }

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    public void deal(int numCards) {
        for (int i = 0; i < numCards; i++) {
            Card card = removeTopCard();
            hand.add(card);
        }
    }

    public abstract void deal();

    public int remaining() {
        return this.hand.size();
    }

    public void validateEnoughCards() {
        if (this.hand.isEmpty()) {
            throw new IllegalStateException("ERROR: Not enough cards in hand.");
        }
    }

    public Card playCard() {
        validateEnoughCards();
        Card tmp = this.hand.remove(0);
        return tmp;
    }

    public void sort() {
        Collections.sort(deck, Card::compareTo);
    }

    public Card getHighestCard() {
        validateEnoughCards();
        return Collections.max(hand, Card::compareTo);
    }
}
