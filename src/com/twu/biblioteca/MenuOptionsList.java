package com.twu.biblioteca;

public enum MenuOptionsList {
    LIST_OF_BOOKS ("List of books"),
    CHECKOUT_A_BOOK ("Checkout a book"),
    RETURN_A_BOOK ("Return a book"),
    LIST_OF_MOVIES ("List of movies"),
    CHECKOUT_A_MOVIE ("Checkout a movie"),
    RETURN_A_MOVIE ("Return a movie"),
    GET_USER_DETAILS ("See your details");

    public final String option;

    MenuOptionsList(String option) {
        this.option = option;
    }
}
