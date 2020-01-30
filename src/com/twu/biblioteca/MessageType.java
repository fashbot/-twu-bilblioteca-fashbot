package com.twu.biblioteca;

public enum MessageType{
    WELCOME_GREETING ("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"),
    BOOK_LIST_INTRO("Here are the list of books available: ");

    public final String message;

    MessageType(String message) {
        this.message = message;
    }
}
