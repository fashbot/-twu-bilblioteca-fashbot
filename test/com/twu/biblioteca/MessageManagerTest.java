package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.MessageType.*;
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
}
