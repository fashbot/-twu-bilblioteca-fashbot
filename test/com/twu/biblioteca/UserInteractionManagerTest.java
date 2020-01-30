package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static com.twu.biblioteca.MessageType.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserInteractionManagerTest {

    private UserInteractionManager messageManager;

    @Before
    public void setUp(){
        messageManager = new UserInteractionManager();
    }

    @Test
    public void welcomeMessageIsPrintedWhenCalled(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        messageManager.showMessage(WELCOME_GREETING);

        assertThat(outContent.toString(), containsString(WELCOME_GREETING.message));
    }

    @Test
    public void listOfLibraryBooksShowsAllLibraryBooks(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ArrayList libraryBooks = new ArrayList();
        libraryBooks.add(new Book("1984", "George Orwell", 1948));
        libraryBooks.add(new Book("Great Expectations", "Charles Dickens", 1861));

        Library library = new Library(libraryBooks);

        messageManager.showLibraryCatalogue(library);

        assertThat(libraryBooks.size(), is(2));
    }

    @Test
    public void showMenuOptions(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        messageManager.showMenuOptions();

        assertThat(outContent.toString(), containsString(MenuOptionsList.LIST_OF_BOOKS.option));
    }
}
