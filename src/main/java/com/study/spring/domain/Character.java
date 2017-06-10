package com.study.spring.domain;

import javax.persistence.*;

/**
 * Created by SDS on 2017-06-10.
 */
@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long characterId;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "storyId", insertable = false, updatable = false)
    private Story story;

    public Long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;
    }
}
