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

public class MessageManagerTest {

    private MessageManager messageManager;

    @Before
    public void setUp(){
        messageManager = new MessageManager();
    }

    @Test
    public void welcomeMessageIsPrintedWhenCalled(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        messageManager.showMessage(WELCOME_GREETING);

        assertThat(outContent.toString(), is(WELCOME_GREETING.message+"\n"));
    }

    @Test
    public void listOfLibraryBooksIsPrintedWhenCalled(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        ArrayList libraryBooks = new ArrayList();
        libraryBooks.add(new Book("1984"));
        libraryBooks.add(new Book("Great Expectations"));

        Library library = new Library(libraryBooks);

        messageManager.showLibraryCatalogue(library);

        assertThat(outContent.toString(), containsString("1984"));
    }
}
