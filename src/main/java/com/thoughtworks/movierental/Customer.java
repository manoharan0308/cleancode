package com.thoughtworks.movierental;

public class Customer {
    private final String name;

    private final Rentals rentals = new Rentals();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    String statement() {
        return new TextStatement().generateFrom(name, rentals);
    }

     String htmlStatement() {
        return new HtmlStatement().generateFrom(name, rentals);
    }
}
