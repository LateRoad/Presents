package com.company.models.presents;

import java.util.Objects;

public class Package {

    private Integer width;
    private Integer height;

    public Package(String width, String height) throws Exception {
        Integer convertedWidth = 0;
        Integer convertedHeigth = 0;
        try {
            convertedWidth = Integer.valueOf(width);
            convertedHeigth = Integer.valueOf(width);
        } catch (NumberFormatException ex) {
            throw new WrongFormatException("Wrong package info format!");
        }
        if (convertedWidth <= 0 || convertedHeigth <= 0)
            throw new WrongFormatException("Width and height should be greater than zero!");
        this.width = convertedWidth;
        this.height = convertedHeigth;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return Objects.equals(width, aPackage.width) &&
                Objects.equals(height, aPackage.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "Package with" +
                "width=" + width +
                ", height=" + height;
    }
}
