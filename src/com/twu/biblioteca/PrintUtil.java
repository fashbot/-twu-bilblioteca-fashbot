package com.twu.biblioteca;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.movie.Movie;

public class PrintUtil {

    public final static String BOOK_TITLE_HEADER = "Title: ";
    public final static String BOOK_AUTHOR_HEADER = "Author: ";
    public final static String BOOK_PUBLICATION_YEAR_HEADER = "Publication year: ";
    public final static String MOVIE_NAME_HEADER = "Name: ";
    public final static String MOVIE_YEAR_HEADER = "Year: ";
    public final static String MOVIE_DIRECTOR_HEADER = "Director: ";
    public final static String MOVIE_RATING_HEADER = "Rating: ";

    public void showFormattedMessage(MessageContent type) {
        System.out.println(" ");
        System.out.println(type.message);
        System.out.println(" ");
    }

    public void print(MessageContent messageType){
        System.out.println(messageType.message);
    }

    public void printBookInformation(Book book){
        System.out.println(BOOK_TITLE_HEADER + book.getTitle());
        System.out.println(BOOK_AUTHOR_HEADER + book.getAuthor());
        System.out.println(BOOK_PUBLICATION_YEAR_HEADER + book.getPublicationYear());
        System.out.println(" ");
    }

    public void printMovieInformation(Movie movie){
        System.out.println(MOVIE_NAME_HEADER + movie.getName());
        System.out.println(MOVIE_YEAR_HEADER + movie.getYear());
        System.out.println(MOVIE_DIRECTOR_HEADER + movie.getDirector());
        System.out.println(MOVIE_RATING_HEADER + movie.getRating());
        System.out.println(" ");
    }

    public void printDivider() {
        System.out.println("=====================================");
    }

}



