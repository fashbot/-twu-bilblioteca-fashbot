package com.twu.biblioteca.databasemanager;

import com.twu.biblioteca.movie.Movie;

import java.util.ArrayList;

public class MovieDatabaseManager implements IDatabaseManager {

    private ArrayList<Movie> movieItems;
    private ArrayList<Movie> originalMovieItems;

    public MovieDatabaseManager(ArrayList<Movie> bookItems) {
        this.movieItems = bookItems;
        this.originalMovieItems = new ArrayList<>(bookItems);
    }

    public ArrayList<Movie> getListOfMovies() {
        return movieItems;
    }

    @Override
    public boolean isItemValidToCheckout(String movieName) {
        for (Movie movie : movieItems) {
            if (movie.getName().toUpperCase().equals(movieName.toUpperCase())) {
                movieItems.remove(movie);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isItemValidToReturn(String movieName) {
        for (Movie movie : originalMovieItems) {
            if (movie.getName().toUpperCase().equals(movieName.toUpperCase())) {
                movieItems.add(movie);
                return true;
            }
        }
        return false;
    }
}
