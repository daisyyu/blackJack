import game.TableManager;
import suites.Card;
import suites.Shoe;
import suites.Suite;

import java.util.Random;

/**
 * Created by Daisy on 2/18/16.
 */
public class Client {

    public static void main(String[] args) {
        TableManager tableManager = new TableManager();
        tableManager.startGame();
    }
}