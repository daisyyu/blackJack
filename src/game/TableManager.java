package game;

import suites.Shoe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daisy on 2/20/16.
 */
public class TableManager {
    private List<Round> rounds = new ArrayList<Round>();

    private Shoe shoe = new Shoe();
    private CardHolder player;
    private CardHolder dealer;
    private CardHolder actionableCardHolder;
    private RoundRobin<CardHolder> cardHolderRoundRobin;
    private Round currentRound;

    public void startGame() {
        System.out.println("Black Jack Game started, Good luck!");
//        System.out.println(shoe);
        while (!shouldStopGame(shoe)) {
            setUpTable();
            System.out.println("new round");
            Round round = new Round(dealer, player);
            this.currentRound = round;
            rounds.add(round);
            cardHolderRoundRobin.reset();
            while (!round.isOver()) {
                // always start with dealer
                actionableCardHolder = cardHolderRoundRobin.next();
                System.out.println(actionableCardHolder.name + " takes action");
                actionableCardHolder.move();
                tryToSettle();
            }
            //TODO:
            break;
        }
    }

    /**
     * Try to settle the round, find winner and end round if feasible. If round is not end, handover action to next
     * cardholder
     */
    private void tryToSettle() {
        if (currentRound.tryToSettle()) {
            // round is over, print winner
            System.out.println("Winner is : " + currentRound.getWinner());
        }
    }

    private void setUpTable() {
        List<CardHolder> cardHolders = new ArrayList<CardHolder>();
        // TODO: factory class getNewPlayer and increment player id to up to 6
        // dealer has to be the first cardholder gets in
        dealer = new Dealer(this);
        player = new Player(this, "Player1");
        cardHolders.add(dealer);
        cardHolders.add(player);
        cardHolderRoundRobin = new RoundRobin<CardHolder>(cardHolders);
    }

    private static boolean shouldStopGame(Shoe shoe) {
        int currentSize = shoe.getCards().size();
        if (currentSize <= shoe.getTotalCards() / 3) {
            return true;
        } else {
            return false;
        }
    }


    public Round getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(final Round currentRound) {
        this.currentRound = currentRound;
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(final Shoe shoe) {
        this.shoe = shoe;
    }
}
