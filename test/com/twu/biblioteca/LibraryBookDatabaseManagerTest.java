package com.twu.biblioteca;

import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.databasemanager.LibraryBookDatabaseManager;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryBookDatabaseManagerTest {

    private ArrayList<Book> bookItems;
    private LibraryBookDatabaseManager bookDatabaseManager;

    @Before
    public void setUp() {
        bookItems = new ArrayList<>();
        bookItems.add(new Book("1984", "George Orwell", 1948));
        bookItems.add(new Book("Great Expectations", "Charles Dickens", 1861));

        bookDatabaseManager = new LibraryBookDatabaseManager(bookItems);
    }

    @Test
    public void getCatalogueReturnsTheListOfLibraryBooks() {
        ArrayList<Book> catalogue = bookDatabaseManager.getListOfBooks();

        assertThat(catalogue.size(), is(2));
    }

    @Test
    public void ifBookExistsValidBookToCheckoutReturnsTrue() {

        boolean hasBookBeenCheckout = bookDatabaseManager.isItemValidToCheckout("1984");

        assertThat(hasBookBeenCheckout, is(true));
    }

    @Test
    public void ifBookDoesNotExistsValidBookToCheckoutReturnsFalse() {

        boolean hasBookBeenCheckout = bookDatabaseManager.isItemValidToCheckout("Oliver Twist");

        assertThat(hasBookBeenCheckout, is(false));
    }

    @Test
    public void ifBookExistsValidBookToReturnReturnsTrue() {

        bookDatabaseManager.isItemValidToCheckout("1984");

        boolean hasBookBeenReturned = bookDatabaseManager.isItemValidToReturn("1984");

        assertThat(hasBookBeenReturned, is(true));
    }

    @Test
    public void ifBookDoesNotExistsValidBookToReturnReturnsFalse() {

        bookDatabaseManager.isItemValidToCheckout("1984");

        boolean hasBookBeenReturned = bookDatabaseManager.isItemValidToReturn("Oliver Twist");

        assertThat(bookItems.size(), is(1));
    }

    @Test
    public void ifBookDoesNotExistsDatabaseIsNotUpdatedOnReturn() {

        bookDatabaseManager.isItemValidToCheckout("1984");

        bookDatabaseManager.isItemValidToReturn("Oliver Twist");

        assertThat(bookItems.size(), is(1));
    }

    @Test
    public void ifBookDoesExistsDatabaseIsUpdatedOnReturn() {

        bookDatabaseManager.isItemValidToCheckout("1984");

        bookDatabaseManager.isItemValidToReturn("1984");

        assertThat(bookItems.size(), is(2));
    }

    @Test
    public void ifBookDoesNotExistsDatabaseIsNotUpdatedOnCheckout() {

        bookDatabaseManager.isItemValidToCheckout("cheese man");

        assertThat(bookItems.size(), is(2));
    }

    @Test
    public void ifBookDoesExistsDatabaseIsUpdatedOnCheckout() {

        bookDatabaseManager.isItemValidToCheckout("1984");

        assertThat(bookItems.size(), is(1));
    }

}
