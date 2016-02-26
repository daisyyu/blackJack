package strategy;

import game.Round;

/**
 * Created by Daisy on 2/18/16.
 */
public interface IStrategyPlayer {
    public PlayerMove nextMove(Round round);
}
