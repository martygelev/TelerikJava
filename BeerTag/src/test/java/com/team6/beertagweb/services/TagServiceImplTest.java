package com.team6.beertagweb.services;

import com.team6.beertagweb.models.Tag;
import com.team6.beertagweb.models.User;
import com.team6.beertagweb.repositories.base.TagRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class TagServiceImplTest {
    @Mock
    TagRepository tagRepository;
    @InjectMocks
    TagServiceImpl tagServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTagById() throws Exception {
        int id = 12;
        Tag expected = new Tag();
        when(tagRepository.getTagById(id)).thenReturn(expected);
        Tag tag = tagRepository.getTagById(id);
        assertSame(expected, tag);
    }

    @Test
    public void testGetAllTags() throws Exception {
        // ARRANGE
        List<Tag> expected =
                Arrays.asList(
                        new Tag(),
                        new Tag(),
                        new Tag()
                );
        // ACT
        when(tagRepository.getAllTags()).thenReturn(expected);
        List<Tag> users = tagRepository.getAllTags();
        assertSame(expected, users);
    }

    @Test
    public void testAddNewTag() throws Exception {
        tagRepository.addNewTag(new Tag());
    }

    @Test
    public void testDeleteTag() throws Exception {
        tagServiceImpl.deleteTag(0);
    }
}

