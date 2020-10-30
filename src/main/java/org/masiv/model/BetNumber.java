package org.masiv.model;
import org.masiv.Exceptions.BetException;
public class BetNumber extends Bet {
    private int number;
    public BetNumber(int money, int number) throws BetException {
        super(money);
        this.setNumber(number);
    }
    public void setNumber(int number) throws BetException {
        if (number < 0 || number > 36) {
            throw new BetException(BetException.INVALID_NUMBER);
        }
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
}
