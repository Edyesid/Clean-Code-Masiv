package org.masiv.Exceptions;
public class BetException extends Exception {
    public static final String MIN_MONEY = "not enough money to gamble.";
    public static final String INVALID_NUMBER = "the number is not valid for betting.";
    public static final String INVALID_COLOR = "the color is not valid for betting.";
    public static final String MAX_MONEY = "the money exceeds the maximum allowed.";
    public BetException() {
        super();
    }
    public BetException(String message) {
        super(message);
    }
}
