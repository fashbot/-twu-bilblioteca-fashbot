package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static com.twu.biblioteca.MessageType.WELCOME_GREETING;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookTest {

    private Book book;

    @Before
    public void setUp() {
        book = new Book("1984", "George Orwell", 1948);
    }

    @Test
    public void welcomeMessageIsPrintedWhenCalled() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        book.printBookInformation();

        assertThat(outContent.toString(), containsString("1984"));
        assertThat(outContent.toString(), containsString("George Orwell"));
        assertThat(outContent.toString(), containsString("1948"));
    }
}
