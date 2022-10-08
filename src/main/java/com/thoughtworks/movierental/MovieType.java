package com.thoughtworks.movierental;

public abstract class MovieType {

    abstract double amountFor(int daysRented);

    abstract int getPriceCode();

    int frequentRenterPoints(int daysRented) {
        return  1;
    }
}
