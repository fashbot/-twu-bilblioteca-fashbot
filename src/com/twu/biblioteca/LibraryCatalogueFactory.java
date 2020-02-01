package com.twu.biblioteca;

import com.twu.biblioteca.CommandLineInteraction.ICommandLineInteractionManager;
import com.twu.biblioteca.CommandLineInteraction.UserInteractionsManager;
import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.databasemanager.LibraryBookDatabaseManager;
import com.twu.biblioteca.databasemanager.MovieDatabaseManager;
import com.twu.biblioteca.loginManager.LoginManager;
import com.twu.biblioteca.movie.Movie;

import java.util.ArrayList;

public enum LibraryCatalogueFactory {
    INSTANCE;

    private static LibraryCatalogueFactory instance = null;

    public ICommandLineInteractionManager getInstance() {
        ArrayList<Book> bookList = generateOriginalBookList();
        ArrayList<Movie> movieList = generateOriginalMovieList();
       return new UserInteractionsManager(
               new LibraryBookDatabaseManager(bookList),
               new MovieDatabaseManager(movieList),
               new LoginManager()
       );
    }

    private ArrayList<Book> generateOriginalBookList() {
        ArrayList<Book> libraryBooks = new ArrayList<>();
        libraryBooks.add(new Book("1984", "George Orwell", 1984));
        libraryBooks.add(new Book("Great Expectations", "Charles Dickens", 1861));
        return libraryBooks;
    }

    private ArrayList<Movie> generateOriginalMovieList() {
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Movie One", 1992, "Scena Deo", 8));
        movieList.add(new Movie("Movie Two", 1994, "Scena Deo", 5));
        movieList.add(new Movie("Movie Three", 1997, "Scena Deo", 4));
        return movieList;
    }

}
