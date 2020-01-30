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

public class MenuOptionsManagerTest {

    private MenuOptionsManager messageManager;
    private LibraryCatalogueManager library;
    private ArrayList<Book> libraryBooks = new ArrayList<>();

    @Before
    public void setUp(){
        libraryBooks.add(new Book("1984", "George Orwell", 1948));
        libraryBooks.add(new Book("Great Expectations", "Charles Dickens", 1861));
        library = new LibraryCatalogueManager(libraryBooks);
        messageManager = new MenuOptionsManager(library);
    }




    @Test
    public void showMenuOptions(){

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        messageManager.showMenuOptions();

        assertThat(outContent.toString(), containsString(MenuOptionsList.LIST_OF_BOOKS.option));
    }
}
