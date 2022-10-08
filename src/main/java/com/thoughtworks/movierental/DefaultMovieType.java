package com.thoughtworks.movierental;

public class DefaultMovieType extends MovieType{
    @Override
    double amountFor(int daysRented) {
        return 0;
    }

    @Override
    int getPriceCode() {
        return 0;
    }

    @Override
    int frequentRenterPoints(int daysRented) {
        return  0;
    }
}
