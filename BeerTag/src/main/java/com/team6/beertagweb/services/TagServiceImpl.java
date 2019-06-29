package com.team6.beertagweb.services;

import com.team6.beertagweb.models.Tag;
import com.team6.beertagweb.repositories.base.TagRepository;
import com.team6.beertagweb.services.base.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag getTagById(int id) {
        return tagRepository.getTagById(id);
    }

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.getAllTags();
    }

    @Override
    public Tag addNewTag(Tag newTag) {
        return tagRepository.addNewTag(newTag);
    }

    @Override
    public void deleteTag(int id) {
        tagRepository.deleteTag(id);
    }
}
