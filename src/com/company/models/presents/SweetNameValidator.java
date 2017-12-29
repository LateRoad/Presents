package com.company.models.presents;

public class SweetNameValidator {

    public static boolean validate(String name) {
        return !name.isEmpty() && name.matches("(\\p{Alpha}\\s?)+");
    }
}
