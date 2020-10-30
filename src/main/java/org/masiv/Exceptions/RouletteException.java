package org.masiv.Exceptions;
public class RouletteException extends Exception {
    public static final String NOT_FOUND = "roulette not found.";
    public RouletteException() {
        super();
    }
    public RouletteException(String message) {
        super(message);
    }
}