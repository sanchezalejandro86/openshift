package com.baufest.app1.model;

import javax.persistence.*;

@Entity
public class SimpleBean {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    public SimpleBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SimpleBean() {
    }

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
}
