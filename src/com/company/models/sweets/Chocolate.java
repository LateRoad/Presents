package com.company.models.sweets;

public class Chocolate implements Sweet {

    private String name;

    public Chocolate(String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
