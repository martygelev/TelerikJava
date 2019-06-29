package com.team6.beertagweb.repositories.base;

import com.team6.beertagweb.models.Tag;

import java.util.List;

public interface TagRepository {
    Tag getTagById(int id);

    List<Tag> getAllTags();

    Tag addNewTag(Tag newTag);

    void deleteTag(int id);
}
