package com.team6.beertagweb.controller;

import com.team6.beertagweb.models.Beer;
import com.team6.beertagweb.models.Rating;
import com.team6.beertagweb.models.User;
import com.team6.beertagweb.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    private List<User> getAll() {
        return userService.getUsers();
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User userToCreate) {
        return userService.createUser(userToCreate);
    }

    @PutMapping("/update/{id}")
    private void updateUser(@Valid @RequestBody User user, @PathVariable int id) {
        userService.updateUser(user, id);
    }

    @GetMapping("/{id}")
    private User getById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/drank/{id}")
    public List<Beer> getDrankBeers(@PathVariable int id) {
        return userService.getDrank(id);
    }

    @GetMapping("/want/{id}")
    public List<Beer> getWantToDrinkBeers(@PathVariable int id) {
        return userService.getWantToDrink(id);
    }

    @PostMapping("/want/{id}/{beerId}")
    public void addToWant(@PathVariable int id, @PathVariable int beerId) {
        userService.addBeerToWantToDrink(id, beerId);
    }

    @PostMapping("/drank/{id}/{beerId}")
    public void addToDrank(@PathVariable int id, @PathVariable int beerId) {
        userService.addBeerToDrank(id, beerId);
    }

    @DeleteMapping("/want/{id}/{beerId}")
    public void removeFromWantToDrink(@PathVariable int id, @PathVariable int beerId) {
        userService.removeFromWantToDrink(id, beerId);
    }

    @DeleteMapping("/drank/{id}/{beerId}")
    public void removeFromDrank(@PathVariable int id, @PathVariable int beerId) {
        userService.removeFromDrank(id, beerId);
    }

    @PutMapping("/rate/{userId}/{beerId}/{ratingToAdd}")
    public Rating rateBeer(@PathVariable int userId, @PathVariable int beerId, @PathVariable int ratingToAdd) {
        return userService.rateBeer(userId, beerId, ratingToAdd);
    }

    // @DeleteMapping("/{id}")
    // private String deleteUser(@PathVariable int id){ TODO
    //     return userService.delete(id);
    // }
}
