package com.company.models.factories;

import com.company.models.presents.ChocolatesPresent;
import com.company.models.presents.Package;
import com.company.models.presents.Present;

public class ChocolatesPresentFactory implements PresentFactory {

    @Override
    public Present makePresent(Package box, String name, String[] sweetNames) throws Exception {
        ChocolatesPresent present = new ChocolatesPresent(box, name);
        for (String sweetName : sweetNames) {
            present.addSweet(sweetName);
        }
        return present;
    }

}
