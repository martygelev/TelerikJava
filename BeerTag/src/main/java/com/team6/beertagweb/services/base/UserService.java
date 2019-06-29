package com.team6.beertagweb.services.base;

import com.team6.beertagweb.models.Beer;
import com.team6.beertagweb.models.Rating;
import com.team6.beertagweb.models.User;

import java.util.List;

public interface UserService {
    User createUser(User userToCreate);

    User getUserById(int userId);

    void updateUser(User userToUpdate, int userId);

    List<User> getUsers();

    void addBeerToDrank(int userId, int beerId);

    void addBeerToWantToDrink(int userId, int beerId);

    Rating rateBeer(int userId, int beerId, int ratingToAdd);

    void removeFromWantToDrink(int userId, int beerId);

    void removeFromDrank(int userId, int beerId);

    List<Beer> getDrank(int userId);

    List<Beer> getWantToDrink(int userId);
}
