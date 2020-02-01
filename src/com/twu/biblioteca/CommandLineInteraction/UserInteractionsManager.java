package com.twu.biblioteca.CommandLineInteraction;

import com.twu.biblioteca.MenuOptionsList;
import com.twu.biblioteca.loginManager.LoginManager;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.PrintUtil;
import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.databasemanager.LibraryBookDatabaseManager;
import com.twu.biblioteca.databasemanager.MovieDatabaseManager;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.twu.biblioteca.MessageContent.*;

public class UserInteractionsManager implements ICommandLineInteractionManager {

    private PrintUtil printUtil = new PrintUtil();

    private LibraryBookDatabaseManager bookDatabaseManager;
    private MovieDatabaseManager movieDatabaseManager;
    private LoginManager loginManager;

    Scanner scanner = new Scanner(System.in);

    public UserInteractionsManager(
            LibraryBookDatabaseManager bookDatabaseManager,
            MovieDatabaseManager movieDatabaseManager,
            LoginManager loginManager
    ) {
        this.bookDatabaseManager = bookDatabaseManager;
        this.movieDatabaseManager = movieDatabaseManager;
        this.loginManager = loginManager;
    }

    @Override
    public void showLibraryBookCatalogue() {

        printUtil.showFormattedMessage(BOOK_LIST_INTRO);

        ArrayList<Book> bookList = bookDatabaseManager.getListOfBooks();

        showListOfBooks(bookList);
    }

    private void showListOfBooks(ArrayList<Book> bookList) {
        System.out.println("BOOKS: ");

        for (int i = 0; i < bookList.size(); i++) {
            Book item = bookList.get(i);
            int listPosition = i + 1;

            System.out.println(listPosition + ". ");
            printUtil.printBookInformation(item);
        }
    }

    private void showListOfMovies(ArrayList<Movie> moviesList) {
        for (int i = 0; i < moviesList.size(); i++) {
            Movie item = moviesList.get(i);
            int listPosition = i + 1;

            System.out.println(listPosition + ". ");
            printUtil.printMovieInformation(item);
        }
    }

    @Override
    public void showMenuOptions() {
        printUtil.print(SPACE);
        printUtil.print(CHOOSE_MENU_OPTION);

        printUtil.printDivider();

        for (var i = 0; i < MenuOptionsList.values().length; i++) {
            String position = (i + 1) + ") ";
            System.out.println(position + MenuOptionsList.values()[i].option);
        }

        printUtil.printDivider();
        printUtil.print(SPACE);
        printUtil.print(EXIT_APPLICATION);
    }

    @Override
    public void showBookCheckoutOption() {
        printUtil.print(CHECKOUT_BOOK_INTRO);
        String itemTitle = scanner.nextLine();

        if (!bookDatabaseManager.isItemValidToCheckout(itemTitle)) {
            printUtil.print(CHECKOUT_FAILED);
        } else {
            printUtil.print(CHECKOUT_SUCCESS);
        }
    }

    @Override
    public void showMovieCheckoutOption() {
        printUtil.print(CHECKOUT_MOVIE_INTRO);
        String itemTitle = scanner.nextLine();

        if (!movieDatabaseManager.isItemValidToCheckout(itemTitle)) {
            printUtil.print(CHECKOUT_FAILED);
        } else {
            printUtil.print(CHECKOUT_SUCCESS);
        }
    }


    @Override
    public void showBookReturnOption() {
        printUtil.print(RETURN_BOOK_INTRO);
        String itemTitle = scanner.nextLine();

        if (bookDatabaseManager.isItemValidToReturn(itemTitle)) {
            printUtil.print(RETURN_SUCCESS);

        } else {
            printUtil.print(RETURN_FAILED);
        }
    }

    @Override
    public boolean requestCredentials() {

        printUtil.print(ENTER_LIBRARY_NUMBER);
        String libraryNumber = scanner.nextLine();
        printUtil.print(ENTER_PASSWORD);
        String password = scanner.nextLine();


        if (loginManager.isValidUser(libraryNumber, password)) {
            printUtil.print(ACCESS_GRANTED);
            return true;
        }

        printUtil.print(ACCESS_DENIED);
        return false;

    }

    @Override
    public void exit(){
        printUtil.print(GOOD_BYE);
        System.exit(1);
    }

    @Override
    public void showMovieReturnOption() {
        printUtil.print(RETURN_MOVIE_INTRO);
        String itemTitle = scanner.nextLine();

        if (movieDatabaseManager.isItemValidToReturn(itemTitle)) {
            printUtil.print(RETURN_SUCCESS);

        } else {
            printUtil.print(RETURN_FAILED);
        }
    }

    @Override
    public void showLibraryMovieCatalogue() {
        printUtil.showFormattedMessage(MOVIE_LIST_INTRO);

        ArrayList<Movie> movieList = movieDatabaseManager.getListOfMovies();

        showListOfMovies(movieList);
    }
}
