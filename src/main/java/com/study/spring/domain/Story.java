package com.study.spring.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storyId;

    private String title;

    @ManyToOne
    @JoinColumn(name = "bookId", insertable = false, updatable = false)
    private Book book;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "storyId")
    private List<Character> characters = new ArrayList<>();

    public Long getStoryId() {
        return storyId;
    }

    public void setStoryId(Long storyId) {
        this.storyId = storyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }
}
