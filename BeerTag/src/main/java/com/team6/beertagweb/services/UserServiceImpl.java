package com.team6.beertagweb.services;

import com.team6.beertagweb.models.Beer;
import com.team6.beertagweb.models.Rating;
import com.team6.beertagweb.models.User;
import com.team6.beertagweb.repositories.base.UserRepository;
import com.team6.beertagweb.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User userToCreate) {
        return userRepository.createUser(userToCreate);
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public void updateUser(User userToUpdate, int userId) {
        userRepository.updateUser(userToUpdate, userId);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public void addBeerToDrank(int userId, int beerId) {
        userRepository.addBeerToDrank(userId, beerId);
    }

    @Override
    public void addBeerToWantToDrink(int userId, int beerId) {
        userRepository.addBeerToWantToDrink(userId, beerId);

    }

    @Override
    public Rating rateBeer(int userId, int beerId, int ratingToAdd) {
        return userRepository.rateBeer(userId, beerId, ratingToAdd);
    }

    @Override
    public void removeFromWantToDrink(int userId, int beerId) {
        userRepository.removeFromWantToDrink(userId, beerId);

    }

    @Override
    public void removeFromDrank(int userId, int beerId) {
        userRepository.removeFromDrank(userId, beerId);

    }

    @Override
    public List<Beer> getDrank(int userId) {
        return userRepository.getDrank(userId);

    }

    @Override
    public List<Beer> getWantToDrink(int userId) {

        return userRepository.getWantToDrink(userId);
    }
}
