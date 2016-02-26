package suites;

/**
 * Created by Daisy on 2/18/16.
 */
public class Card implements Comparable<Card> {
    private Color color;

    private Number number;

    private boolean isHidden = false;

    public Card(Color color, Number number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public String toString() {
        return isHidden ? "?" : color + " " + number.getNum();
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(final Number number) {
        this.number = number;
    }


    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(final boolean hidden) {
        isHidden = hidden;
    }

    @Override
    public int compareTo(final Card o) {
        return o.getNumber().getNum() - getNumber().getNum();
    }

    public enum Color {
        HEARTS,
        DIAMONDS,
        CLUBS,
        SPADES;
    }

    public enum Number {
        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN
                (10), KING(10);

        private int num;

        Number(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public void setNum(final int num) {
            this.num = num;
        }
    }

}
