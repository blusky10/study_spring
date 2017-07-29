package com.study.spring.domain;

import javax.persistence.*;

@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int possibleToCreate;

    @Column(nullable = false)
    private int possibleToRead;

    @Column(nullable = false)
    private int possibleToUpdate;

    @Column(nullable = false)
    private int possibleToDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPossibleToCreate() {
        return possibleToCreate;
    }

    public void setPossibleToCreate(int possibleToCreate) {
        this.possibleToCreate = possibleToCreate;
    }

    public int getPossibleToRead() {
        return possibleToRead;
    }

    public void setPossibleToRead(int possibleToRead) {
        this.possibleToRead = possibleToRead;
    }

    public int getPossibleToUpdate() {
        return possibleToUpdate;
    }

    public void setPossibleToUpdate(int possibleToUpdate) {
        this.possibleToUpdate = possibleToUpdate;
    }

    public int getPossibleToDelete() {
        return possibleToDelete;
    }

    public void setPossibleToDelete(int possibleToDelete) {
        this.possibleToDelete = possibleToDelete;
    }
}
