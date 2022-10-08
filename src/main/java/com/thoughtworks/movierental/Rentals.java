package com.thoughtworks.movierental;

import java.util.ArrayList;

public class Rentals extends ArrayList<Rental> {

    public int totalFrequentRenterPoints() {
        return this.stream().mapToInt(Rental::frequentRenterPoints).sum();
    }

    public double totalAmount() {
        return this.stream().mapToDouble(Rental::amount).sum();
    }
}
