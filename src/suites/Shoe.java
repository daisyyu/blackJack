package suites;

import com.sun.istack.internal.Nullable;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * Created by Daisy on 2/18/16.
 */
public class Shoe {
    public int getTotalCards() {
        return totalCards;
    }

    public void setTotalCards(final int totalCards) {
        this.totalCards = totalCards;
    }

    private int totalCards;

    public int getNumOfSuites() {
        return numOfSuites;
    }

    public void setNumOfSuites(final int numOfSuites) {
        this.numOfSuites = numOfSuites;
    }

    private int numOfSuites = DEFAULT_NUM_OF_SUITES;
    private static int DEFAULT_NUM_OF_SUITES = 7;

    private List<Card> cards = new LinkedList<Card>();

    @Nullable
    public Card getNextCard() {
        return ((LinkedList<Card>) cards).poll();
    }

    public Shoe(int numOfSuites) {
        this.numOfSuites = numOfSuites;
        for (int i = 0; i < numOfSuites; i++) {
            cards.addAll(Suite.getOrderedSuites().getCards());
        }
        suffle();
        totalCards = cards.size();
    }

    public Shoe() {
        this(DEFAULT_NUM_OF_SUITES);
    }

    private void suffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(final List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("This shoe has " + cards.size() + " cards\n");
        for (Card card : cards) {
            buffer.append(card + ", ");
        }
        return buffer.toString();
    }
}
