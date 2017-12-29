package com.company.models.sweets;

import java.util.Objects;

public class Candy implements Sweet {

    private String name;

    public Candy(String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy candy = (Candy) o;
        return Objects.equals(name, candy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                '}';
    }
}
