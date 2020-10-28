package org.masiv.services;
import org.masiv.model.Roulette;
import java.util.ArrayList;
public interface RouletteService {
    ArrayList<Roulette> getAllRoulettes();
    String createRoulette();
}
