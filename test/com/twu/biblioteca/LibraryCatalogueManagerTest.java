package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryCatalogueManagerTest {

    private ArrayList<Book> bookItems;
    private LibraryCatalogueManager library;

    @Before
    public void setUp() {
        bookItems = new ArrayList<>();
        bookItems.add(new Book("1984", "George Orwell", 1948));
        bookItems.add(new Book("Great Expectations", "Charles Dickens", 1861));

        library = new LibraryCatalogueManager(bookItems);
    }

    @Test
    public void getCatalogueReturnsTheListOfLibraryBooks() {
        ArrayList<Book> catalogue = library.getCatalogue();

        assertThat(catalogue.size(), is(2));
    }

    @Test
    public void listOfLibraryBooksShowsAllLibraryBooks() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        library.showFormattedLibraryCatalogue();

        assertThat(library.getCatalogue().size(), is(2));
    }

    @Test
    public void checkingOutAValidBookUpdatesTheCatalogue() {

        library.checkoutBook("1984");

        assertThat(library.getCatalogue().size(), is(1));
    }

    @Test
    public void checkingOutAnInvalidBookDoesNotUpdateTheCatalogue() {

        library.checkoutBook("James and the Giant Peach");

        assertThat(library.getCatalogue().size(), is(2));
    }

    @Test
    public void ASuccessfullyReturnedBookShouldUpdateTheLibraryCatalogue() {
        library.checkoutBook("Great Expectations");

        assertThat(library.getCatalogue().size(), is(1));

        library.returnBook("Great Expectations");

        assertThat(library.getCatalogue().size(), is(2));
    }

    @Test
    public void AnUnSuccessfullyReturnedBookShouldUpdateTheLibraryCatalogue() {
        library.checkoutBook("Great Expectations");

        assertThat(library.getCatalogue().size(), is(1));

        library.returnBook("Cheese cheese man");

        assertThat(library.getCatalogue().size(), is(1));
    }
}
