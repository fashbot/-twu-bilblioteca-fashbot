package com.twu.biblioteca;

import com.twu.biblioteca.databasemanager.MovieDatabaseManager;
import com.twu.biblioteca.movie.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryMovieDatabaseManagerTest {

    private ArrayList<Movie> movieList;
    private MovieDatabaseManager movieDatabase;

    @Before
    public void setUp() {
        movieList = new ArrayList<Movie>();
      
        movieList.add(new Movie("Movie One", 1992, "Scena Deo", 8));
        movieList.add(new Movie("Movie Two", 1994, "Scena Deo", 5));
        movieList.add(new Movie("Movie Three", 1997, "Scena Deo", 4));
        
        movieDatabase = new MovieDatabaseManager(movieList);
    }

    @Test
    public void getCatalogueReturnsTheListOfLibraryMovies() {
        ArrayList<Movie> catalogue = movieDatabase.getListOfMovies();

        assertThat(catalogue.size(), is(3));
    }

    @Test
    public void ifMovieExistsValidMovieToCheckoutReturnsTrue() {

        boolean hasBeenCheckout = movieDatabase.isItemValidToCheckout("Movie One");

        assertThat(hasBeenCheckout, is(true));
    }

    @Test
    public void ifMovieDoesNotExistsValidMovieToCheckoutReturnsFalse() {

        boolean hasBeenCheckout = movieDatabase.isItemValidToCheckout("Oliver Twist");

        assertThat(hasBeenCheckout, is(false));
    }

    @Test
    public void ifMovieExistsValidMovieToReturnGivesTrue() {

       movieDatabase.isItemValidToCheckout("Movie Two");

        boolean hasBeenReturned = movieDatabase.isItemValidToReturn("Movie Two");

        assertThat(hasBeenReturned, is(true));
    }

    @Test
    public void ifMovieDoesNotExistsValidMovieToReturnReturnsFalse() {

        movieDatabase.isItemValidToCheckout("1984");

        boolean hasBeenReturned = movieDatabase.isItemValidToReturn("1984");

        assertThat(movieList.size(), is(3));
    }

    @Test
    public void ifMovieDoesNotExistsDatabaseIsNotUpdatedOnReturn() {

        movieDatabase.isItemValidToCheckout("1984");

        movieDatabase.isItemValidToReturn("Oliver Twist");

        assertThat(movieList.size(), is(3));
    }

    @Test
    public void ifMovieDoesExistsDatabaseIsUpdatedOnReturn() {

        movieDatabase.isItemValidToCheckout("Movie One");

        assertThat(movieList.size(), is(2));

        movieDatabase.isItemValidToReturn("Movie One");

        assertThat(movieList.size(), is(3));
    }

    @Test
    public void ifMovieDoesNotExistsDatabaseIsNotUpdatedOnCheckout() {

        movieDatabase.isItemValidToCheckout("cheese man");

        assertThat(movieList.size(), is(3));
    }

    @Test
    public void ifMovieDoesExistsDatabaseIsUpdatedOnCheckout() {

        movieDatabase.isItemValidToCheckout("Movie Three");

        assertThat(movieList.size(), is(2));
    }

}
