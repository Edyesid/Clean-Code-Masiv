package org.masiv.model;
import org.masiv.Exceptions.BetException;
public class BetColor extends Bet {
    private String color;
    public BetColor(int money, String color) throws BetException {
        super(money);
        setColor(color);
    }
    public void setColor(String color) throws BetException {
        if (!(color.equals("rojo")) || !(color.equals("negro"))) {
            throw new BetException(BetException.INVALID_COLOR);
        }
        this.color = color;
    }
    public String getColor() {
        return color;
    }
}
