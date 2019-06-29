package com.team6.beertagweb.controller;

import com.team6.beertagweb.models.Tag;
import com.team6.beertagweb.services.base.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tag")
public class TagRestController {

    private final TagService tagService;

    @Autowired
    public TagRestController(TagService tagService){
        this.tagService=tagService;
    }

    @GetMapping
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @PostMapping
    public Tag addNewTag(@RequestBody @Valid Tag newTag) {
        return tagService.addNewTag(newTag);
    }

    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable int id) {
        return tagService.getTagById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable(value = "id") @Valid int id) {
        tagService.deleteTag(id);
    }

}
