package com.thoughtworks.movierental;

public class Rental {
    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double amount() {
        return movie.rentAmountFor(daysRented);
    }

    public int frequentRenterPoints() {
        if (isEligibleForExtraPoints()) {
            return 2;
        }
        return 1;
    }

    private boolean isEligibleForExtraPoints() {
        return movie.isNewRelease() && daysRented > 1;
    }
}
