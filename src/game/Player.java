package game;

import strategy.IStrategyPlayer;
import strategy.PlayerMove;
import strategy.PlayerStrategy;
import strategy.RobotPlayerStrategy;

/**
 * Created by Daisy on 2/18/16.
 */
public class Player extends CardHolder {
    IStrategyPlayer strategy;

    public Player(TableManager tableManager, String name) {
        this.tableManager = tableManager;
//        strategy = new PlayerStrategy(this);
        strategy = new RobotPlayerStrategy(this);
        this.name = name;
    }

    @Override
    public void move() {
        Round currentRound = tableManager.getCurrentRound();
        PlayerMove move = null;
        while (!isBlackJack() && !isBusted() && (move == null || move != PlayerMove.STAND)) {
            move = strategy.nextMove(currentRound);
            switch (move) {
                case HIT:
                    getCard();
                    calculateIfBusted();
                    break;
                case STAND:
                    System.out.println(name + " stand");
                    setStand(true);
                    break;
                case INIT:
                    getCard();
                    getCard();
                    break;
                case SPLIT:
                    // TODO:
                    break;
                case INSURANCE:
                    // TODO:
                    break;
            }

        }

    }

    private boolean isBlackJack() {
        if (getCardTotal() == 21) {
            System.out.println("Black Jack to you!");
            return true;
        } else {
            return false;
        }
    }

}
