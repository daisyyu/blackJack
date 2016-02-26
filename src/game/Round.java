package game;

import suites.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daisy on 2/18/16.
 */
public class Round {

    private boolean started = false;
    private CardHolder dealer;
    private CardHolder player;

    private boolean isOver = false;
    private String winner;

    public Round(CardHolder dealer, CardHolder player) {
        this.dealer = dealer;
        this.player = player;
    }

    public boolean tryToSettle() {
        // player busted
        if (player.getCardTotal() > 21) {
            setOver(true);
            setWinner("dealer");
            return true;
        } else if ((player.isStand() && dealer.isStand())) {
            setOver(true);
            // dealer busted
            if (dealer.getCardTotal() > 21) {
                setWinner("Player " + player.name);
            } else if (dealer.getCardTotal() > player.getCardTotal()) {
                setWinner("Dealer");
            } else if (dealer.getCardTotal() < player.getCardTotal()) {
                setWinner("Player " + player.name);
            } else {
                setWinner("Tie");
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean isOver() {
        return isOver;
    }

    public void setOver(final boolean over) {
        isOver = over;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(final String winner) {
        this.winner = winner;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(final boolean started) {
        this.started = started;
    }


}
