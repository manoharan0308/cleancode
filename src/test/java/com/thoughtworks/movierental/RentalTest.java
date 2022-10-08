package com.thoughtworks.movierental;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {

    @ParameterizedTest
    @MethodSource("movieArguments")
    void shouldReturnAmountAndFrequentRenterPointsForMovie(int priceCode, int daysRented, double expectedAmount, int expectedPoints) {
        Movie childrenMovie = new Movie("Movie1", priceCode);
        Rental rental1 = new Rental(childrenMovie, daysRented);

        assertEquals(expectedAmount, rental1.amount());
        assertEquals(expectedPoints, rental1.frequentRenterPoints());
    }

    @ParameterizedTest
    @MethodSource("movieArgumentsWithMovieType")
    void shouldReturnAmountAndFrequentRenterPointsForNewMovieType(MovieType movieType, int daysRented, double expectedAmount, int expectedPoints) {
        Movie movie = new Movie("PS1", movieType);
        Rental rental = new Rental(movie, daysRented);
        assertEquals(expectedAmount, rental.amount());
        assertEquals(expectedPoints, rental.frequentRenterPoints());
    }

    private static Stream<Arguments> movieArguments() {
        return Stream.of(
                Arguments.of(Movie.CHILDRENS, 5, 4.5, 1),
                Arguments.of(Movie.REGULAR, 10, 14.0, 1),
                Arguments.of(Movie.NEW_RELEASE, 7, 21.0, 2),
                Arguments.of(Movie.BLUE_RAY, 11, 44.0, 3)
        );
    }

    private static Stream<Arguments> movieArgumentsWithMovieType() {
        return Stream.of(
                Arguments.of(new ChildrenMovieType(), 5, 4.5, 1),
                Arguments.of(new RegularMovieType(), 10, 14.0, 1),
                Arguments.of(new NewReleaseMovieType(), 7, 21.0, 2),
                Arguments.of(new BlueRayMovieType(), 11, 44.0, 3)
        );
    }
}
