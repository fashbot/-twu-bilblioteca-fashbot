package com.twu.biblioteca;

import java.util.ArrayList;

public enum LibraryCatalogueFactory {
    INSTANCE;

    private static LibraryCatalogueFactory instance = null;

    private ArrayList<Book> generateOriginalBookList() {
        ArrayList<Book> libraryBooks = new ArrayList<>();
        libraryBooks.add(new Book("1984", "George Orwell", 1984));
        libraryBooks.add(new Book("Great Expectations", "Charles Dickens", 1861));
        return libraryBooks;
    }

    public ICommandLineInteractionManager getInstance() {
        ArrayList<Book> bookList = generateOriginalBookList();
       return new UserInteractionsManager(new LibraryBookDatabaseManager(bookList));
    }

}
