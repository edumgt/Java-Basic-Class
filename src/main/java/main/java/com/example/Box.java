package com.example;

public class Box {

    public double LENGTH;

    private double width;

    private double height = 50;

    private double length;
    public double getLength() {
        return length;
    }
    public void setLength(double length, String test) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width, String test) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height, String test) {
        this.height = height;
    }

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public Box() {

    }

    private void setLength(double length) {
        sideValidation(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        sideValidation(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        sideValidation(height, "Height");
        this.height = height;
    }

    private void sideValidation(double side, String sideName) {
        if (side <= 5) {
            throw new IllegalArgumentException(sideName + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        return (2 * length * width) + (2 * length * height) + (2 * width * height);
    }

    public double calculateLateralSurfaceArea() {
        return (2 * length * height) + (2 * width * height);

    }

    public double calculateVolume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f",
                this.calculateSurfaceArea(), this.calculateLateralSurfaceArea(),
                this.calculateVolume());
    }

}
