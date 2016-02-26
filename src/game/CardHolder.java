package game;

import strategy.IStrategyDealer;
import suites.Card;

import java.util.*;

/**
 * Created by Daisy on 2/18/16.
 */
public abstract class CardHolder {
    protected List<Card> cards = new ArrayList<Card>();

    protected boolean stand = false;
    protected String name;
    protected TableManager tableManager;

    protected boolean busted = false;

    abstract public void move();

    public int getCardTotal() {
        List<Card> tmp = new ArrayList(cards);
        Collections.sort(tmp);
        int total = 0;
        for (Card card : tmp) {
            if (!card.isHidden()) {
                if (card.getNumber().equals(Card.Number.ONE)) {
                    if (total + 11 <= 21) {
                        total += 11;
                    } else {
                        total += 1;
                    }
                } else {
                    total += card.getNumber().getNum();
                }
            }
        }
        return total;
    }

    public boolean isStand() {
        return stand;
    }

    public void setStand(final boolean stand) {
        this.stand = stand;
    }

    protected void getCard() {
        Card card = tableManager.getShoe().getNextCard();
        System.out.println(name + " gets card " + card);
        cards.add(card);
        printCardOnHand();
    }

    public List<Card> getCards() {
        return cards;
    }

    private void printCardOnHand() {
        StringBuffer buffer = new StringBuffer("cards on hand: ");
        for (Card card1 : cards) {
            buffer.append(card1 + " ");
        }
        buffer.append("total: " + getCardTotal());
        System.out.println(buffer.toString());
    }

    public boolean isBusted() {
        return busted;
    }

    public void setBusted(final boolean busted) {
        this.busted = busted;
    }

    public void setCards(final List<Card> cards) {
        this.cards = cards;
    }

    protected void calculateIfBusted() {
        if (getCardTotal() > 21) {
            setBusted(true);
            System.out.println("Oops," + name + " is bused");
        }
    }
}
