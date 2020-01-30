package com.twu.biblioteca;

public enum MenuOptionsList {
    LIST_OF_BOOKS ("List of books"),
    CHECKOUT_A_BOOK ("Checkout a book"),
    RETURN_A_BOOK ("Return a book");

    public final String option;

    MenuOptionsList(String option) {
        this.option = option;
    }
}
