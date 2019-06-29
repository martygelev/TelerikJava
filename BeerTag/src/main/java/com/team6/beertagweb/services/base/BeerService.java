package com.team6.beertagweb.services.base;

import com.team6.beertagweb.models.Beer;
import com.team6.beertagweb.models.Style;
import com.team6.beertagweb.models.Tag;

import java.util.List;
import java.util.Set;

public interface BeerService {

    Beer getBeerById(int id);

    Beer beerAddTag(int beerId, Tag tag);

    List<Beer> getAllBeers();

    List<Beer> getAllBeersSortedByAbv();

    List<Beer> getAllBeersSortedByName();

    List<Beer> getBeersByTag(int tagId);

    List<Beer> getBeerByStyle(int id);

    void addNewBeer(Beer newBeer);

    List<Beer> sortBeersByRating(Beer beer);

    List<Beer> getBeersByCountry(int id);

    Beer editBeer(Beer beerToEdit);

    void deleteBeer(int id);
}
