package com.thoughtworks.movierental;

public class HtmlStatement {

     String generateFrom(String cutomerName, Rentals rentals) {
        String header = "<h3>Rental Record for %s</h3>";
        String footer = "<p>Amount owed is <b>%s</b></p>" +
                "<p>You earned <b>%d</b> frequent renter points</p>";

        return String.format(header, cutomerName)
                .concat(htmlBody(rentals))
                .concat(String.format(footer, rentals.totalAmount(), rentals.totalFrequentRenterPoints()));
    }

    private String htmlBody(Rentals rentals) {
        String result = "<p>";
        String body = "%s<b>%s</b><br/>";
        for (Rental rental : rentals) {
            result += String.format(body, rental.getMovie().getTitle(), rental.amount());
        }
        return result + "</p>";
    }
}
