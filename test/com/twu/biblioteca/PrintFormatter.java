package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.twu.biblioteca.MessageType.WELCOME_GREETING;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class PrintFormatter {

    private PrintUtil printUtil;

    @Before
    public void setUp() {
        printUtil = new PrintUtil();
    }

    @Test
    public void welcomeMessageIsPrintedWhenCalled() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        printUtil.showFormattedMessage(WELCOME_GREETING);
        assertThat(outContent.toString(), containsString(WELCOME_GREETING.message));
    }
}
