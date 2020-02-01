package com.twu.biblioteca;

import com.twu.biblioteca.CommandLineInteraction.ICommandLineInteractionManager;
import com.twu.biblioteca.CommandLineInteraction.UserInteractionsManager;
import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.databasemanager.LibraryBookDatabaseManager;
import com.twu.biblioteca.databasemanager.MovieDatabaseManager;
import com.twu.biblioteca.movie.Movie;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class UserInteractionsManagerTest {

    private ICommandLineInteractionManager interactionManager;

    @Before
    public void setUp() {
        ArrayList<Book> bookItems = new ArrayList<>();
        ArrayList<Movie> movieList = new ArrayList<>();

        LibraryBookDatabaseManager bookDatabaseManager;
        MovieDatabaseManager movieDatabaseManager;

        bookItems.add(new Book("1984", "George Orwell", 1948));
        bookItems.add(new Book("Great Expectations", "Charles Dickens", 1861));

        movieList.add(new Movie("Movie One", 1992, "Scena Deo", 8));
        movieList.add(new Movie("Movie Two", 1994, "Scena Deo", 5));

        bookDatabaseManager = new LibraryBookDatabaseManager(bookItems);
        movieDatabaseManager = new MovieDatabaseManager(movieList);
        interactionManager = new UserInteractionsManager(bookDatabaseManager, movieDatabaseManager);
    }

    @Test
    public void showMenuOptionsPrintsMenuOptions() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        interactionManager.showMenuOptions();

        assertThat(outContent.toString(), containsString(MenuOptionsList.LIST_OF_BOOKS.option));
        assertThat(outContent.toString(), containsString(MenuOptionsList.CHECKOUT_A_BOOK.option));
        assertThat(outContent.toString(), containsString(MenuOptionsList.RETURN_A_BOOK.option));
        assertThat(outContent.toString(), containsString(MenuOptionsList.CHECKOUT_A_MOVIE.option));
        assertThat(outContent.toString(), containsString(MenuOptionsList.LIST_OF_MOVIES.option));
        assertThat(outContent.toString(), containsString(MenuOptionsList.RETURN_A_MOVIE.option));
    }

    @Test
    public void showBookLibraryCataloguePrintsFullBookLibraryCatalogue() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        interactionManager.showLibraryBookCatalogue();

        assertThat(outContent.toString(), containsString("1984"));
        assertThat(outContent.toString(), containsString("George Orwell"));
        assertThat(outContent.toString(), containsString("1948"));

        assertThat(outContent.toString(), containsString("Great Expectations"));
        assertThat(outContent.toString(), containsString("Charles Dickens"));
        assertThat(outContent.toString(), containsString("1861"));
    }

    @Test
    public void showMovieLibraryCataloguePrintsFullMovieLibraryCatalogue() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        interactionManager.showLibraryMovieCatalogue();

        assertThat(outContent.toString(), containsString("Movie One"));
        assertThat(outContent.toString(), containsString("1992"));
        assertThat(outContent.toString(), containsString("Scena Deo"));
        assertThat(outContent.toString(), containsString("8"));

        assertThat(outContent.toString(), containsString("Movie Two"));
        assertThat(outContent.toString(), containsString("1994"));
        assertThat(outContent.toString(), containsString("Scena Deo"));
        assertThat(outContent.toString(), containsString("5"));

    }
}
