package com.twu.biblioteca;

import com.twu.biblioteca.loginManager.LoginManager;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LoginManagerTest {

    private LoginManager loginManager;

    @Before
    public void setUp() {

        loginManager = new LoginManager();
    }

    @Test
    public void isValidUserReturnsTrueIfUserExists(){

        boolean isValidUserCredentials = loginManager.isValidUser("333-3333", "Icecream");

        assertThat(isValidUserCredentials, is(true));
    }

    @Test
    public void isValidUserReturnsFalseifLibraryPasswordIsWrong(){

        boolean isValidUserCredentials = loginManager.isValidUser("333-3333", "Woah");

        assertThat(isValidUserCredentials, is(false));
    }

    @Test
    public void isValidUserReturnsFalseifLibraryUsernameIsWrong(){

        boolean isValidUserCredentials = loginManager.isValidUser("333-3g33", "Icecream");

        assertThat(isValidUserCredentials, is(false));
    }
}
