package com.thoughtworks.movierental;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int BLUE_RAY = 4;

    private String title;
    private MovieType movieType;

    @Deprecated
    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
    }

    public int getPriceCode() {
        return movieType.getPriceCode();
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                movieType = new RegularMovieType();
                break;
            case NEW_RELEASE:
                movieType = new NewReleaseMovieType();
                break;
            case CHILDRENS:
                movieType = new ChildrenMovieType();
                break;
            case BLUE_RAY:
                movieType = new BlueRayMovieType();
                break;
            default:
                movieType = new DefaultMovieType();
        }
    }

    public String getTitle() {
        return title;
    }

    public boolean isNewRelease() {
        return movieType instanceof NewReleaseMovieType;
    }

    public double rentAmountFor(int daysRented) {
        return movieType.amountFor(daysRented);
    }

}
