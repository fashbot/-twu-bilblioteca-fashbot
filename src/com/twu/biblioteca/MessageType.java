package com.twu.biblioteca;

public enum MessageType{
    WELCOME_GREETING ("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

    public final String message;

    MessageType(String message) {
        this.message = message;
    }
}
