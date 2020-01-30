package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    private Library library;

    public static void main(String[] args) {
        MessageManager messageManager = new MessageManager();

        ArrayList libraryBooks = new ArrayList();
        libraryBooks.add(new Book("1984", "George Orwell", 1984));
        libraryBooks.add(new Book("Great Expectations", "Charles Dickens", 1861));
        Library library = new Library(libraryBooks);

        messageManager.showMessage(MessageType.WELCOME_GREETING);
        messageManager.showLibraryCatalogue(library);
    }
}
