package suites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Daisy on 2/18/16.
 */
public class Suite {
    public List<Card> getCards() {
        return cards;
    }

    public void setCards(final List<Card> cards) {
        this.cards = cards;
    }

    private List<Card> cards = new ArrayList<Card>();

    /**
     * Ordered suites
     */
    private Suite() {
        for (Card.Color color : Card.Color.values()) {
            for (Card.Number number : Card.Number.values()) {
                cards.add(new Card(color, number));
            }
        }
    }

    /**
     * suffle cards
     */
    private void suffle() {
        Collections.shuffle(cards);
    }

    public static Suite getOrderedSuites() {
        return new Suite();
    }

    public static Suite getRandomOrderedSuites() {
        Suite suite = new Suite();
        suite.suffle();
        return suite;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("This suites has " + cards.size() + " cards\n");
        for (Card card : cards) {
            buffer.append(card + ", ");
        }
        return buffer.toString();
    }
}
