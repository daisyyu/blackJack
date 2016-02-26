package game;

import strategy.DealerStrategy;
import strategy.DealerMove;
import strategy.IStrategyDealer;
import suites.Card;

/**
 * Created by Daisy on 2/18/16.
 */
public class Dealer extends CardHolder {
    IStrategyDealer strategy;
    int count = 0;

    public Dealer(TableManager tableManager) {
        this.tableManager = tableManager;
        name = Dealer.class.getSimpleName();
        strategy = new DealerStrategy(this);
    }

    public void move() {
        count++;
        if (count == 2) {
            makeAllCardsVisible();
        }
        Round currentRound = tableManager.getCurrentRound();
        DealerMove move = null;
        while (move == null || move == DealerMove.DEAL) {
            move = strategy.nextMove(currentRound);
            switch (move) {
                case INIT:
                    getCardFaceDown();
                    getCard();
                    break;
                case DEAL:
                    getCard();
                    calculateIfBusted();
                    break;
                case STAND:
                    System.out.println(name + " stand with total:" + getCardTotal());
                    setStand(true);
                    break;
            }

        }
    }

    private void getCardFaceDown() {
        Card card = tableManager.getShoe().getNextCard();
        card.setHidden(true);
        System.out.println(name + " gets card " + card);
        cards.add(card);
    }

    private void makeAllCardsVisible() {
        for (Card card : cards) {
            card.setHidden(false);
        }
    }
}
