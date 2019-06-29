package com.team6.beertagweb.repositories.base;

import com.team6.beertagweb.models.Beer;
import com.team6.beertagweb.models.Tag;

import java.util.List;

public interface BeerRepository {
    List<Beer> getAllBeersSortedByRating(Beer beer);

    List<Beer> getAllBeers();
    Beer getBeerById(int id);

   List<Beer> getBeersByCountry(int id);

    List<Beer> getBeersByTag(int tagId);

    List<Beer> getBeersByStyle(int id );

    void createBeer(Beer beerToCreate);

    void deleteBeer(int id);

    Beer editBeer(Beer beerToEdit);

    List<Beer> getAllBeersSortedByAbv();

    Beer beerAddTag(int beerId, Tag tag);

    List<Beer> getAllBeersSortedByName();
}
