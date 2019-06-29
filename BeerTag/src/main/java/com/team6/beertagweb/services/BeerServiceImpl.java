package com.team6.beertagweb.services;

import com.team6.beertagweb.models.Beer;
import com.team6.beertagweb.models.Tag;
import com.team6.beertagweb.repositories.base.BeerRepository;
import com.team6.beertagweb.services.base.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepository;

    @Autowired
    public BeerServiceImpl(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public Beer getBeerById(int id) {
        return beerRepository.getBeerById(id);
    }

    @Override
    public List<Beer> getAllBeers() {
        return beerRepository.getAllBeers();
    }

    @Override
    public List<Beer> getAllBeersSortedByAbv() {
        return beerRepository.getAllBeersSortedByAbv();
    }

    @Override
    public List<Beer> getAllBeersSortedByName() {
        return beerRepository.getAllBeersSortedByName();
    }

    @Override
    public Beer beerAddTag(int beerId, Tag tag) {
        return beerRepository.beerAddTag(beerId, tag);
    }

    @Override
    public List<Beer> getBeersByTag(int tagId) {
        return beerRepository.getBeersByTag(tagId);
    }

    @Override
    public List<Beer> sortBeersByRating(Beer beer) {
        return beerRepository.getAllBeersSortedByRating(beer);
    }

    @Override
    public List<Beer> getBeersByCountry(int id) {
        return beerRepository.getBeersByCountry(id);
    }

    @Override
    public Beer editBeer(Beer beerToEdit) {
        return beerRepository.editBeer(beerToEdit);
    }

    @Override
    public void deleteBeer(int id) {
        beerRepository.deleteBeer(id);
    }

    @Override
    public List<Beer> getBeerByStyle(int id) {
        return beerRepository.getBeersByStyle(id);
    }

    @Override
    public void addNewBeer(Beer newBeer) {
        beerRepository.createBeer(newBeer);
    }

}
