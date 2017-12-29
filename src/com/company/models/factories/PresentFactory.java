package com.company.models.factories;

import com.company.models.presents.Package;
import com.company.models.presents.Present;

public interface PresentFactory {
    Present makePresent(Package box, String name, String[] sweetNames) throws Exception;
}
