package org.masiv.services.impl;
import org.masiv.Exceptions.RouletteException;
import org.masiv.model.Roulette;
import org.masiv.persistence.RouletteRepository;
import org.masiv.services.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Service
public class RouletteServiceImpl implements RouletteService {
    @Autowired
    RouletteRepository rouletteRepository;
    @Override
    public String createRoulette() {
        Roulette roulette = new Roulette();
        rouletteRepository.save(roulette);
        return roulette.getId();
    }
    @Override
    public void openRoulette(String idRoulette) throws RouletteException {
        Roulette roulette = rouletteRepository.findById(idRoulette).orElseThrow(()->new RouletteException(RouletteException.NOT_FOUND));
        roulette.openState();
        rouletteRepository.save(roulette);
    }
    @Override
    public ArrayList<Roulette> getAllRoulettes() {
        ArrayList<Roulette> listRoulettes = new ArrayList<>();
        for (Roulette roulette: rouletteRepository.findAll()) listRoulettes.add(roulette);
        return listRoulettes;
    }
}