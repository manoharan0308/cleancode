package com.thoughtworks.movierental;

public class RegularMovieType extends MovieType {

    double amountFor(int daysRented) {
        double amount = 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }

    int getPriceCode() {
        return Movie.REGULAR;
    }
}
