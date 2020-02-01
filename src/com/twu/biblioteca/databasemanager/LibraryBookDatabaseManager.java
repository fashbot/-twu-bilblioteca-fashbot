package com.twu.biblioteca.databasemanager;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.databasemanager.IDatabaseManager;

import java.util.ArrayList;

public class LibraryBookDatabaseManager implements IDatabaseManager {

    public ArrayList<Book> bookItems;
    public ArrayList<Book> originalBookItems;

    public LibraryBookDatabaseManager(ArrayList<Book> bookItems) {
        this.bookItems = bookItems;
        this.originalBookItems = new ArrayList<>(bookItems);
    }

    public ArrayList<Book> getListOfBooks() {
        return bookItems;
    }

    @Override
    public boolean isItemValidToCheckout(String givenBookTitle) {
        for (Book book : bookItems) {
            if (book.getTitle().toUpperCase().equals(givenBookTitle.toUpperCase())) {
                bookItems.remove(book);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isItemValidToReturn(String givenBookTitle) {
        for (Book book : originalBookItems) {
            if (book.getTitle().toUpperCase().equals(givenBookTitle.toUpperCase())) {
                bookItems.add(book);
                return true;
            }
        }
        return false;
    }
}
