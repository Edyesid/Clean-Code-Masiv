package org.masiv.services;
import org.masiv.Exceptions.RouletteException;
import org.masiv.model.Roulette;
import java.util.ArrayList;
public interface RouletteService {
    String createRoulette();
    void openRoulette(String idRoulette) throws RouletteException;
    ArrayList<Roulette> getAllRoulettes();
}
