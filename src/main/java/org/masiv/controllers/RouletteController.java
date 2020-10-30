package org.masiv.controllers;
import org.masiv.Exceptions.RouletteException;
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
            return new ResponseEntity<>("roulette not found.",HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllRoulettes() {
        return new ResponseEntity<>(rouletteService.getAllRoulettes(), HttpStatus.ACCEPTED);
    }
}