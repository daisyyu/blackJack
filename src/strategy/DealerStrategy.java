package strategy;

import game.CardHolder;
import game.Round;

/**
 * Created by Daisy on 2/18/16.
 */
public class DealerStrategy implements IStrategyDealer {
    CardHolder cardHolder;

    public DealerStrategy(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }

    @Override

    public DealerMove nextMove(Round round) {
        if (!round.isStarted()) {
            round.setStarted(true);
            return DealerMove.INIT;
        } else if (cardHolder.getCardTotal() < 17) {
            return DealerMove.DEAL;
        } else {
            return DealerMove.STAND;
        }
    }
}
