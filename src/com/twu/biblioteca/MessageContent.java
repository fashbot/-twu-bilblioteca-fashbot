package com.twu.biblioteca;

public enum MessageContent {
    WELCOME_GREETING("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"),
    BOOK_LIST_INTRO("Here are the list of books available: "),
    MOVIE_LIST_INTRO("Here are the list of movies available: "),
    CHECKOUT_BOOK_INTRO("Enter the book you wish to checkout:"),
    CHECKOUT_MOVIE_INTRO("Enter the movie you wish to checkout:"),
    RETURN_BOOK_INTRO("Enter the book you wish to return:"),
    RETURN_MOVIE_INTRO("Enter the movie you wish to return:"),
    CHECKOUT_SUCCESS("Thank you! Enjoy the book."),
    CHECKOUT_FAILED("Sorry, that book is not available"),
    RETURN_SUCCESS("Thank you for returning the item"),
    RETURN_FAILED("That is not a valid item to return"),
    MENU_OPTION_UNAVAILABLE("Please select a valid option!"),
    GOOD_BYE("GOODBYE"),
    ENTER_LIBRARY_NUMBER("Enter your library number:"),
    ENTER_PASSWORD("Enter your password:"),
    EXIT_APPLICATION(("(To exit the application, type 'QUIT')")),
    CHOOSE_MENU_OPTION("CHOOSE THE APPROPRIATE NUMBER TO SELECT A MENU OPTION."),
    SPACE(" "),
    ACCESS_GRANTED("ACCESS GRANTED"),
    ACCESS_DENIED("ACCESS DENIED");

    public final String message;

    MessageContent(String message) {
        this.message = message;
    }
}
