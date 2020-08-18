package com.mechanitis.demo.junit5;

public class Shape {
    private final int numberOfSides;

    public Shape(int numberOfSides) {
        if (numberOfSides < 3 || numberOfSides == Integer.MAX_VALUE) {
            throw new IllegalArgumentException();
        }
        this.numberOfSides = numberOfSides;
    }

    public int numberOfSides() {
        return numberOfSides;
    }
}
