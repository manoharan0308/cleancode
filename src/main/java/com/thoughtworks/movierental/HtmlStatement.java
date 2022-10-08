package com.thoughtworks.movierental;

public class HtmlStatement {

     String generateFrom(String customerName, Rentals rentals) {
        return this.htmlHeader(customerName)
                .concat(this.htmlBody(rentals))
                .concat(this.htmlFooter(rentals));
    }

    private String htmlHeader(String cutomerName) {
        String header = "<h3>Rental Record for %s</h3>";
        return String.format(header, cutomerName);
    }

    private String htmlBody(Rentals rentals) {
        String result = "<p>";
        String body = "%s<b>%s</b><br/>";
        for (Rental rental : rentals) {
            result += String.format(body, rental.getMovie().getTitle(), rental.amount());
        }
        return result + "</p>";
    }

    private String htmlFooter(Rentals rentals) {
        String footer = "<p>Amount owed is <b>%s</b></p>" +
                "<p>You earned <b>%d</b> frequent renter points</p>";
        return String.format(footer, rentals.totalAmount(), rentals.totalFrequentRenterPoints());
    }

}
