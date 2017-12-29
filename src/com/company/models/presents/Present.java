package com.company.models.presents;

import com.company.models.sweets.Sweet;

import java.util.ArrayList;

public interface Present {

    void addSweet(String sweetName);

    ArrayList<Sweet> getSweets();

    String getName();

    void setName(String name);

    void setPackage(Package packageObject);

    Package getPackage();

    String open();

}
