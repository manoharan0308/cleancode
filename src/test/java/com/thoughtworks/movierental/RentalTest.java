package com.thoughtworks.movierental;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {

    @ParameterizedTest
    @MethodSource("movieArguments")
    void shouldReturnAmountForChildrenMovie(int movieType, int daysRented, double expectedAmount, int expectedPoints) {
        Movie childrenMovie = new Movie("Movie1", movieType);
        Rental rental1 = new Rental(childrenMovie, daysRented);

        assertEquals(expectedAmount, rental1.amount());
        assertEquals(expectedPoints, rental1.frequentRenterPoints());
    }

    private static Stream<Arguments> movieArguments() {
        return Stream.of(
                Arguments.of(Movie.CHILDRENS, 5, 4.5, 1),
                Arguments.of(Movie.REGULAR, 10, 14.0, 1),
                Arguments.of(Movie.NEW_RELEASE, 7, 21.0, 2)
        );
    }
}
