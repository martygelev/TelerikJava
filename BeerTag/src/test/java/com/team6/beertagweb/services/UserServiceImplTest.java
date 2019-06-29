package com.team6.beertagweb.services;

import com.team6.beertagweb.models.Beer;
import com.team6.beertagweb.models.Rating;
import com.team6.beertagweb.models.User;
import com.team6.beertagweb.repositories.base.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserById() throws Exception {
        int id = 12;
        User expected = new User();
        when(userRepository.getUserById(id)).thenReturn(expected);
        User user = userRepository.getUserById(id);
        assertSame(expected, user);
    }

    @Test
    public void testUpdateUser() throws Exception {
        userServiceImpl.updateUser(new User(), 0);
    }

    @Test
    public void testGetUsers() {
        // ARRANGE
        List<User> expected =
                Arrays.asList(
                        new User(),
                        new User(),
                        new User()
                );
        // ACT
        when(userRepository.getUsers()).thenReturn(expected);
        List<User> users = userRepository.getUsers();
        assertSame(expected, users);

    }
    @Test
    public void testAddBeerToDrank() throws Exception {
        userServiceImpl.addBeerToDrank(0, 0);
    }

    @Test
    public void testAddBeerToWantToDrink() throws Exception {
        userServiceImpl.addBeerToWantToDrink(0, 0);
    }

    @Test
    public void testRemoveFromWantToDrink() throws Exception {
        userServiceImpl.removeFromWantToDrink(0, 0);
    }

    @Test
    public void testRemoveFromDrank() throws Exception {
        userServiceImpl.removeFromDrank(0, 0);
    }


}

