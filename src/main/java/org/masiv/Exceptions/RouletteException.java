package org.masiv.Exceptions;
public class RouletteException extends Exception {
    public static final String NOT_FOUND = "roulette not found.";
    public static final String IS_ALREADY_OPEN = "roulette is currently open";
    public static final String IS_ALREADY_CLOSE = "roulette is currently close";
    public RouletteException() {
        super();
    }
    public RouletteException(String message) {
        super(message);
    }
}