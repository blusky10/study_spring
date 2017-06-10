package com.study.spring.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by SDS on 2017-06-09.
 */
@Entity
public class User {

    @Id
    private String id;
    private String name;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
