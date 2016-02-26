package strategy;

import com.sun.xml.internal.ws.util.StringUtils;
import game.*;

import java.util.Scanner;

/**
 * Created by Daisy on 2/18/16.
 */
public class PlayerStrategy implements IStrategyPlayer {
    private CardHolder cardHolder;
    private Scanner reader;

    public PlayerStrategy(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
        reader = new Scanner(System.in);
    }

    @Override
    public PlayerMove nextMove(Round round) {
        if (cardHolder.getCardTotal() == 0) {
            return PlayerMove.INIT;
        } else {
            return convertUserInputToMove(askForPlayerMove());
        }
    }

    private PlayerMove convertUserInputToMove(String string) {
        if ("HIT".equals(string)) {
            return PlayerMove.HIT;
        } else if ("STAND".equals(string)) {
            return PlayerMove.STAND;
        } else {
            System.out.println("I don't understand what your input is");
            return convertUserInputToMove(askForPlayerMove());
        }
        // TODO: split and insurance
    }

    private String askForPlayerMove() {
        StringBuffer buffer = new StringBuffer("Do you want to ? ");
        for (PlayerMove move : PlayerMove.values()) {
            buffer.append(move + " ");
        }
        System.out.println(buffer.toString());
        String userInput = reader.nextLine();
        return userInput;
    }


}
