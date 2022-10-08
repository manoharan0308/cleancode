package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    @Test
    public void shouldGetRentalStatementForCustomer() {
        Customer customer = new Customer("John");

        Movie childrenMovie = new Movie("Movie1", Movie.CHILDRENS);
        Rental rental1 = new Rental(childrenMovie, 5);

        Movie regularMovie = new Movie("Movie2", Movie.REGULAR);
        Rental rental2 = new Rental(regularMovie, 5);

        customer.addRental(rental1);
        customer.addRental(rental2);

        String expectedStatement = "Rental Record for John\n" +
                "\tMovie1\t4.5\n" +
                "\tMovie2\t6.5\n" +
                "Amount owed is 11.0\n" +
                "You earned 2 frequent renter points";

        String actualStatement = customer.statement();

        assertEquals(expectedStatement, actualStatement);
    }

    @Test
    public void shouldGetRentalStatementForCustomerWithBonusRentalPoints() {
        Customer customer = new Customer("John");

        Movie newReleaseMovie = new Movie("Movie1", Movie.NEW_RELEASE);
        Rental rental1 = new Rental(newReleaseMovie, 5);

        Movie childrenMovie = new Movie("Movie2", Movie.CHILDRENS);
        Rental rental2 = new Rental(childrenMovie, 5);

        Movie regularMovie = new Movie("Movie3", Movie.REGULAR);
        Rental rental3 = new Rental(regularMovie, 5);

        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);

        String expectedStatement = "Rental Record for John\n" +
                "\tMovie1\t15.0\n" +
                "\tMovie2\t4.5\n" +
                "\tMovie3\t6.5\n" +
                "Amount owed is 26.0\n" +
                "You earned 4 frequent renter points";

        String actualStatement = customer.statement();

        assertEquals(expectedStatement, actualStatement);
    }

    @Test
    void shouldGetProperStatementWhenCustomerHasNoRentals() {
        Customer customer = new Customer("John");

        String actualStatement = "Rental Record for John\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";

        String expectedStatement = customer.statement();

        assertEquals(expectedStatement, actualStatement);
    }

    @Test
    public void shouldGetRentalStatementForCustomerWithRegularMovieRentalForOneDay() {
        Customer customer = new Customer("John");

        Movie regularMovie = new Movie("Movie1", Movie.REGULAR);
        Rental rental1 = new Rental(regularMovie, 1);

        customer.addRental(rental1);

        String expectedStatement = "Rental Record for John\n" +
                "\tMovie1\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";

        String actualStatement = customer.statement();

        assertEquals(expectedStatement, actualStatement);
    }

    @Test
    public void shouldGetRentalStatementForCustomerWithRegularMovieRentalForMoreThanTwoDays() {
        Customer customer = new Customer("John");

        Movie regularMovie = new Movie("Movie1", Movie.REGULAR);
        Rental rental1 = new Rental(regularMovie, 3);

        customer.addRental(rental1);

        String expectedStatement = "Rental Record for John\n" +
                "\tMovie1\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";

        String actualStatement = customer.statement();

        assertEquals(expectedStatement, actualStatement);
    }

    @Test


    public void shouldGenerateHtmlStatement() {


        Customer customer = new Customer("John Doe");






        customer.addRental(new Rental(new Movie("Jumanji", Movie.CHILDRENS), 2));


        customer.addRental(new Rental(new Movie("3 idiots", Movie.REGULAR), 4));


        customer.addRental(new Rental(new Movie("Avengers", Movie.NEW_RELEASE), 15));






        String statement = customer.htmlStatement();






        assertEquals(statement, "<h3>Rental Record for John Doe</h3>" +


                "<p>Jumanji<b>1.5</b><br/>" +


                "3 idiots<b>5.0</b><br/>" +


                "Avengers<b>45.0</b><br/></p>" +


                "<p>Amount owed is <b>51.5</b></p>" +


                "<p>You earned <b>4</b> frequent renter points</p>");


    }
}
