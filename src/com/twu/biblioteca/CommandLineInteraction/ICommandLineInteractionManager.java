package com.twu.biblioteca.CommandLineInteraction;

public interface ICommandLineInteractionManager {

    void showLibraryBookCatalogue();

    void showBookCheckoutOption();

    void showBookReturnOption();

    void showLibraryMovieCatalogue();

    void showMovieCheckoutOption();

    void showMovieReturnOption();

    void showMenuOptions();

    boolean requestCredentials();

    void exit();

}
