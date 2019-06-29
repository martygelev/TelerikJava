package com.team6.beertagweb.controller;

import com.team6.beertagweb.exception.DatabaseItemNotFoundException;
import com.team6.beertagweb.models.Beer;
import com.team6.beertagweb.models.Tag;
import com.team6.beertagweb.services.base.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/beer")
public class BeerRestController {
    private BeerService beerService;

    @Autowired
    public BeerRestController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping
    public List<Beer> allBeers() {
        return beerService.getAllBeers();
    }

    @GetMapping("/{id}")
    public Beer getBeerById(@PathVariable int id) {
        try {
            return beerService.getBeerById(id);
        } catch (DatabaseItemNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    e.getMessage()
            );
        }
    }

    @PostMapping()
    public void createBeer(@RequestBody Beer beer) {
        beerService.addNewBeer(beer);
    }

    @GetMapping("/sort/rating")
    public List<Beer> sortBeersByRating(@RequestBody Beer beer) {
        return beerService.sortBeersByRating(beer);
    }

    @GetMapping("/sort/name")
    public List<Beer> sortBeersAlphabetically() {
        return beerService.getAllBeersSortedByName();
    }

    @GetMapping("/sort/abv")
    public List<Beer> sortBeersABV() {
        return beerService.getAllBeersSortedByAbv();
    }

    @GetMapping("/filter/style/{id}")
    public List<Beer> getBeerByStyle(@PathVariable int id) {
        return beerService.getBeerByStyle(id);
    }

    @GetMapping("filter/country/{id}")
    public List<Beer> getBeersByCountry(@PathVariable int id) {
        try {
            return beerService.getBeersByCountry(id);
        } catch (DatabaseItemNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    e.getMessage());
        }
    }

    @GetMapping("/filter/tag/{id}")
    public List<Beer> getBeersByTag(@PathVariable int id) {
        return beerService.getBeersByTag(id);
    }

    @PostMapping("/tag/{beerId}")  // only tag id
    public Beer beerAddTag(@PathVariable int beerId, @RequestBody Tag tag) {
        return beerService.beerAddTag(beerId, tag);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBeer(@PathVariable int id) {
        beerService.deleteBeer(id);
    }

    @PutMapping("/update")
    public void editBeer(@RequestBody @Valid Beer beerToEdit) {

        beerService.editBeer(beerToEdit);
    }
}
