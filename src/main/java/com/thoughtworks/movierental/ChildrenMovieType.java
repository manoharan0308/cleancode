package com.thoughtworks.movierental;

public class ChildrenMovieType extends MovieType {

    double amountFor(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }

    int getPriceCode() {
        return Movie.CHILDRENS;
    }
}
