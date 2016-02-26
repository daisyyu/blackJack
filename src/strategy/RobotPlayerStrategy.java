package strategy;

import game.CardHolder;
import game.Round;

import java.util.Scanner;

/**
 * Created by Daisy on 2/18/16.
 */
public class RobotPlayerStrategy implements IStrategyPlayer {
    private CardHolder cardHolder;
    private Scanner reader;

    public RobotPlayerStrategy(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
        reader = new Scanner(System.in);
    }

    @Override
    public PlayerMove nextMove(Round round) {
        if (cardHolder.getCardTotal() == 0) {
            return PlayerMove.INIT;
        } else if (cardHolder.getCardTotal() < 17) {
            return PlayerMove.HIT;
        } else {
            return PlayerMove.STAND;
        }

    }
}
