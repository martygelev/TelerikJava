package com.team6.beertagweb.repositories.base;

import com.team6.beertagweb.models.Beer;
import com.team6.beertagweb.models.Rating;
import com.team6.beertagweb.models.User;

import java.util.List;

public interface UserRepository {
    User getUserById(int userId);

    void updateUser(User userToUpdate, int userId);

    List<User> getUsers();

    void addBeerToDrank(int userId, int beerId);

    void addBeerToWantToDrink(int userId, int beerId);

    Rating rateBeer(int userId, int beerId, int ratingToAdd);

    List<Beer> getDrank(int userId);

    List<Beer> getWantToDrink(int userId);

    void removeFromWantToDrink(int userId, int beerId);

    void removeFromDrank(int userId, int beerId);

    User createUser(User userToCreate);
}
