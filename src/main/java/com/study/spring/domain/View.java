package com.study.spring.domain;

import javax.persistence.*;

@Entity
public class View {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String viewName;

    private String viewDesc;

    @Column(nullable = false)
    private boolean isEnable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getViewDesc() {
        return viewDesc;
    }

    public void setViewDesc(String viewDesc) {
        this.viewDesc = viewDesc;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }
}
