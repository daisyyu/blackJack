package strategy;

import game.CardHolder;
import game.Round;

/**
 * Created by Daisy on 2/18/16.
 */
public interface IStrategyDealer {
    public DealerMove nextMove(Round round);
}
