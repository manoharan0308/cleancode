package com.thoughtworks.movierental;

public class BlueRayMovieType extends MovieType {

    @Override
    double amountFor(int daysRented) {
        return daysRented * 4;
    }

    @Override
    int getPriceCode() {
        return Movie.BLUE_RAY;
    }

    @Override
    int frequentRenterPoints(int daysRented) {
        return 3;
    }
}
