package com.team6.beertagweb.services.base;

import com.team6.beertagweb.models.Tag;

import java.util.List;

public interface TagService {
    Tag getTagById(int id);

    List<Tag> getAllTags();

    Tag addNewTag(Tag newTag);

    void deleteTag(int id);
}