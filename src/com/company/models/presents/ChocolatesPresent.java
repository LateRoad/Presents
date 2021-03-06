package com.company.models.presents;

import com.company.models.sweets.Chocolate;
import com.company.models.sweets.Sweet;

import java.util.ArrayList;

public class ChocolatesPresent implements Present {

    private ArrayList<Sweet> sweets;
    private Package aPackage;
    private String name;

    public ChocolatesPresent(Package aPackage, String name) throws Exception {
        if (name.isEmpty())
            throw new WrongFormatException("Empty present name");
        this.aPackage = aPackage;
        this.name = name;
        sweets = new ArrayList<>();
    }

    @Override
    public String open() {
        return "Opened present with " + toString();
    }

    @Override
    public void addSweet(String sweetName) {
        if (SweetNameValidator.validate(sweetName)) {
            sweets.add(new Chocolate(sweetName));
        }
    }

    @Override
    public ArrayList<Sweet> getSweets() {
        return sweets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPackage(Package packageObject) {
        aPackage = packageObject;
    }

    @Override
    public Package getPackage() {
        return aPackage;
    }

    @Override
    public String toString() {
        StringBuilder sweetsDescription = new StringBuilder();
        sweets
                .stream()
                .map(o -> o.getName() + ", ")
                .forEach(sweetsDescription::append);
        return "Present " + name + " with\n" +
                "Chocolate Sweets = [" + sweetsDescription + "]\n in a Package = [" + aPackage.toString() + "]";
    }
}
