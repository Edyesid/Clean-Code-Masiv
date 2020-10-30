package org.masiv.controllers;
import org.masiv.Exceptions.RouletteException;
import org.masiv.model.Bet;
import org.masiv.services.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/roulettes")
public class RouletteController {
    @Autowired
    RouletteService rouletteService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createRoulette() {
        return new ResponseEntity<>(rouletteService.createRoulette(),HttpStatus.CREATED);
    }
    @RequestMapping(value="/open/{idRoulette}", method = RequestMethod.PATCH)
    public ResponseEntity<?> openRoulette(@PathVariable("idRoulette") String idRoulette) {
        try {
            rouletteService.openRoulette(idRoulette);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(RouletteException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value="/bets/{idRoulette}", method = RequestMethod.POST)
    public ResponseEntity<?> createBet(@PathVariable("idRoulette") String idRoulette, @RequestHeader("idUser") String idUser, @RequestBody Bet bet) {
        try {
            bet.setIdUser(idUser);
            rouletteService.createBet(idRoulette,bet);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RouletteException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllRoulettes() {
        return new ResponseEntity<>(rouletteService.getAllRoulettes(), HttpStatus.ACCEPTED);
    }
}