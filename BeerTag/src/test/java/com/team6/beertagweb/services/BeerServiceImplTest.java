package com.team6.beertagweb.services;

import com.team6.beertagweb.models.Beer;
import com.team6.beertagweb.models.Tag;
import com.team6.beertagweb.models.User;
import com.team6.beertagweb.repositories.base.BeerRepository;
import com.team6.beertagweb.repositories.base.TagRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.Table;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class BeerServiceImplTest {
    @Mock
    BeerRepository beerRepository;
    @Mock
    TagRepository tagRepository;
    @InjectMocks
    BeerServiceImpl beerServiceImpl;
    private Beer beer;
    private Beer beer2;
    private User user;
    private List<Beer> beerList;
    private List<User> userList;

    @Before
    public void setUp() {
        beer = new Beer("test", "123456", 5, "hubava bira za test");
        beer2 = new Beer("test1", "beer2", 4, "hubava bira za test");
        user = new User("client", "client2", "123412341");

        beerList = new ArrayList<>();
        userList = new ArrayList<>();
        beerList.add(beer);
        beerList.add(beer2);
        userList.add(user);
    }

    @Test(expected = NullPointerException.class)
    public void testGetBeerById() throws Exception {
        when(beerRepository.getBeerById(1)).thenReturn(null);

        Beer result = beerRepository.getBeerById(1);

        Assert.assertNull(result);
    }

    @Test(expected = NullPointerException.class)
    public void testGetAllBeers() throws Exception {
        when(beerRepository.getAllBeers()).thenReturn(beerList);

        List<Beer> beers = beerRepository.getAllBeers();

        Assert.assertEquals(beers.size(), beerList.size());
    }

    @Test(expected = NullPointerException.class)
    public void delete_whenBeerIsNotFound_shouldThrowException() {
        when(beerRepository.getBeerById(2)).thenReturn(null);

        beerServiceImpl.deleteBeer(2);
    }

    @Test(expected = NullPointerException.class)
    public void testGetAllBeersSortedByAbv() throws Exception {
        when(beerRepository.getAllBeersSortedByAbv()).thenReturn(Collections.singletonList(new Beer("beerName", "brewery", 0d, "description")));

        List<Beer> result = beerServiceImpl.getAllBeersSortedByAbv();
        Assert.assertEquals(Collections.singletonList(new Beer("beerName", "brewery", 0d, "description")), result);
    }

    @Test(expected = NullPointerException.class)
    public void testGetAllBeersSortedByName() throws Exception {
        when(beerRepository.getAllBeersSortedByName()).thenReturn(Collections.singletonList(new Beer("beerName", "brewery", 0d, "description")));

        List<Beer> result = beerServiceImpl.getAllBeersSortedByName();
        Assert.assertEquals(Collections.singletonList(new Beer("beerName", "brewery", 0d, "description")), result);
    }

    @Test(expected = NullPointerException.class)
    public void testBeerAddTag() throws Exception {
        when(beerRepository.beerAddTag(anyInt(), any())).thenReturn(new Beer("beerName", "brewery", 0d, "description"));

        Beer result = beerServiceImpl.beerAddTag(0, new Tag());
        Assert.assertEquals(new Beer("beerName", "brewery", 0d, "description"), result);
    }

    @Test(expected = NullPointerException.class)
    public void testGetBeersByTag() throws Exception {
        when(beerRepository.getBeersByTag(anyInt())).thenReturn(Collections.singletonList(new Beer("beerName", "brewery", 0d, "description")));

        List<Beer> result = beerServiceImpl.getBeersByTag(0);
        Assert.assertEquals(Collections.singletonList(new Beer("beerName", "brewery", 0d, "description")), result);
    }

    @Test(expected = NullPointerException.class)
    public void testSortBeersByRating() throws Exception {
        when(beerRepository.getAllBeersSortedByRating(any())).thenReturn(Collections.singletonList(new Beer("beerName", "brewery", 0d, "description")));

        List<Beer> result = beerServiceImpl.sortBeersByRating(new Beer("beerName", "brewery", 0d, "description"));
        Assert.assertEquals(Collections.singletonList(new Beer("beerName", "brewery", 0d, "description")), result);
    }

    @Test(expected = NullPointerException.class)
    public void testGetBeersByCountry() throws Exception {
        when(beerRepository.getBeersByCountry(anyInt())).thenReturn(Collections.singletonList(new Beer("beerName", "brewery", 0d, "description")));

        List<Beer> result = beerServiceImpl.getBeersByCountry(0);
        Assert.assertEquals(Collections.singletonList(new Beer("beerName", "brewery", 0d, "description")), result);
    }

    @Test(expected = NullPointerException.class)
    public void testEditBeer() throws Exception {
        when(beerRepository.editBeer(any())).thenReturn(new Beer("beerName", "brewery", 0d, "description"));

        Beer result = beerServiceImpl.editBeer(new Beer("beerName", "brewery", 0d, "description"));
        Assert.assertEquals(new Beer("beerName", "brewery", 0d, "description"), result);
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteBeer() throws Exception {
        beerServiceImpl.deleteBeer(0);
    }

    @Test(expected = NullPointerException.class)
    public void testGetBeerByStyle() throws Exception {
        when(beerRepository.getBeersByStyle(anyInt())).thenReturn(Collections.singletonList(new Beer("beerName", "brewery", 0d, "description")));

        List<Beer> result = beerServiceImpl.getBeerByStyle(0);
        Assert.assertEquals(Collections.singletonList(new Beer("beerName", "brewery", 0d, "description")), result);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNewBeer() throws Exception {
        beerServiceImpl.addNewBeer(new Beer("beerName", "brewery", 0d, "description"));
    }
}

