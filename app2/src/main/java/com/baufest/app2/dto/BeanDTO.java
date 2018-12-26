package com.baufest.app2.dto;

public class BeanDTO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean{ Name ='" + name + '\'' + " }";
    }
}
