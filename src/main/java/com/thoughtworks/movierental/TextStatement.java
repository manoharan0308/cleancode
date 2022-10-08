package com.thoughtworks.movierental;

public class TextStatement {


    String generateFrom(String cutomerName, Rentals rentals) {
        return header(cutomerName).concat(body(rentals)).concat(footer(rentals));
    }

    private String header(String cutomerName) {
        return "Rental Record for " + cutomerName + "\n";
    }

    private String body(Rentals rentals) {
        String result = "";
        for (Rental rental : rentals) {
            result += detailsOf(rental);
        }
        return result;
    }

    private String footer(Rentals rentals) {
        return totalAmountText(rentals.totalAmount()) + totalFrequentRenterPointsText(rentals.totalFrequentRenterPoints());
    }


    private String detailsOf(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" +
                rental.amount() + "\n";
    }

    private String totalFrequentRenterPointsText(int totalFrequentRenterPoints) {
        return "You earned " + totalFrequentRenterPoints
                + " frequent renter points";
    }

    private String totalAmountText(double totalAmount) {
        return "Amount owed is " + totalAmount + "\n";
    }

}
