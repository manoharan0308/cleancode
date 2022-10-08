package com.thoughtworks.movierental;

public class NewReleaseMovieType extends MovieType {

    double amountFor(int daysRented) {
        return daysRented * 3;
    }

    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    int frequentRenterPoints(int daysRented) {
        if(daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
