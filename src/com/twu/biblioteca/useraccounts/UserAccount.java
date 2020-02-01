package com.twu.biblioteca.useraccounts;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.movie.Movie;

import java.util.ArrayList;

public class UserAccount {

    public final static String USER_NAME_HEADER = "Orlando Bloom ";
    public final static String USER_EMAIL_HEADER = "orlando@bloom.com ";
    public final static String USER_PHONE_NUMBER_HEADER = "079 679 679 67 ";

    private String libraryNumber;
    private String password;
    private ArrayList<Movie> checkedOutMovies;
    private ArrayList<Book> checkedOutBook;

    public UserAccount(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.checkedOutMovies = new ArrayList<>();
        this.checkedOutBook = new ArrayList<>();
    }

    public void checkoutNewMovie(Movie movie) {
        checkedOutMovies.add(movie);
    }

    public void checkedOutNewBook(Book book) {
        checkedOutBook.add(book);
    }

    public ArrayList<Book> getCheckedOutBook() {
        return checkedOutBook;
    }

    public ArrayList<Movie> getCheckedOutMovies() {
        return checkedOutMovies;
    }

    public String getName() {
        return USER_NAME_HEADER;
    }

    public String getEmail() {
        return USER_EMAIL_HEADER;
    }

    public String getPhoneNumber() {
        return USER_PHONE_NUMBER_HEADER;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }
}
