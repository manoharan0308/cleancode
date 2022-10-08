package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return header().concat(body()).concat(footer());
    }

    public String htmlStatement() {
        String header = "<h3>Rental Record for %s</h3>";
        String footer = "<p>Amount owed is <b>%s</b></p>" +
                "<p>You earned <b>%d</b> frequent renter points</p>";

        return String.format(header, getName())
                .concat(htmlBody())
                .concat(String.format(footer, totalAmount(), totalFrequentRenterPoints()));
    }

    private String htmlBody() {
        String result = "<p>";
        String body = "%s<b>%s</b><br/>";
        for (Rental rental : rentals) {
            result += String.format(body, rental.getMovie().getTitle(), rental.amount());
        }
        return result + "</p>";
    }


    private String body() {
        String result = "";
        for (Rental rental : rentals) {
            result += detailsOf(rental);
        }
        return result;
    }

    private int totalFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::frequentRenterPoints).sum();
    }

    private double totalAmount() {
        return rentals.stream().mapToDouble(Rental::amount).sum();
    }

    private String header() {
        return "Rental Record for " + getName() + "\n";
    }

    private String detailsOf(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" +
                rental.amount() + "\n";
    }

    private String footer() {
        return totalAmountText(totalAmount()) + totalFrequentRenterPointsText(totalFrequentRenterPoints());
    }

    private String totalFrequentRenterPointsText(int totalFrequentRenterPoints) {
        return "You earned " + totalFrequentRenterPoints
                + " frequent renter points";
    }

    private String totalAmountText(double totalAmount) {
        return "Amount owed is " + totalAmount + "\n";
    }
}
