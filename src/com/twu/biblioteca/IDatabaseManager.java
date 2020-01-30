package com.twu.biblioteca;

interface IDatabaseManager {

    boolean isValidBookToCheckout(String givenBookTitle);

    boolean isValidBookToReturn(String givenBookTitle);

}
