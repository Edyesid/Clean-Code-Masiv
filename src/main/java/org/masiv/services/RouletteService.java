package org.masiv.services;
import org.masiv.model.Roulette;
import java.util.ArrayList;
public interface RouletteService {
    String createRoulette();
    ArrayList<Roulette> getAllRoulettes();
}
