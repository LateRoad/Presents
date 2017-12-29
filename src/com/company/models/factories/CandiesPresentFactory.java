package com.company.models.factories;

import com.company.models.presents.CandiesPresent;
import com.company.models.presents.Package;
import com.company.models.presents.Present;

public class CandiesPresentFactory implements PresentFactory {

    @Override
    public Present makePresent(Package box, String name, String[] sweetNames) throws Exception {
        CandiesPresent present = new CandiesPresent(box, name);
        for (String sweetName : sweetNames) {
            present.addSweet(sweetName);
        }
        return present;
    }
}
