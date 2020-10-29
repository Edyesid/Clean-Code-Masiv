package org.masiv.controllers;
import org.masiv.services.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/roulettes")
public class RouletteController {
    @Autowired
    RouletteService rouletteService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createRoulette() {
        return new ResponseEntity<>(rouletteService.createRoulette(),HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllRoulettes() {
        return new ResponseEntity<>(rouletteService.getAllRoulettes(), HttpStatus.ACCEPTED);
    }
}