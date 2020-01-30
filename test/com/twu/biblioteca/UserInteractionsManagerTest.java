package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserInteractionsManagerTest {

    private ArrayList<Book> bookItems;
    private LibraryBookDatabaseManager bookDatabaseManager;
    private ICommandLineInteractionManager interactionManager;

    @Before
    public void setUp() {
        bookItems = new ArrayList<>();
        bookItems.add(new Book("1984", "George Orwell", 1948));
        bookItems.add(new Book("Great Expectations", "Charles Dickens", 1861));

        bookDatabaseManager = new LibraryBookDatabaseManager(bookItems);

        interactionManager = new UserInteractionsManager(bookDatabaseManager);
    }

    @Test
    public void showMenuOptionsPrintsMenuOptions() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        interactionManager.showMenuOptions();

        assertThat(outContent.toString(), containsString(MenuOptionsList.LIST_OF_BOOKS.option));
        assertThat(outContent.toString(), containsString(MenuOptionsList.CHECKOUT_A_BOOK.option));
        assertThat(outContent.toString(), containsString(MenuOptionsList.RETURN_A_BOOK.option));
    }

    @Test
    public void showLibraryCataloguePrintsFullLibraryCatalogue() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        interactionManager.showLibraryCatalogue();

        assertThat(outContent.toString(), containsString("1984"));
        assertThat(outContent.toString(), containsString("George Orwell"));
        assertThat(outContent.toString(), containsString("1948"));

        assertThat(outContent.toString(), containsString("Great Expectations"));
        assertThat(outContent.toString(), containsString("Charles Dickens"));
        assertThat(outContent.toString(), containsString("1861"));
    }
}
