package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private Library library;

    public static void main(String[] args) {

        ArrayList libraryBooks = new ArrayList();
        libraryBooks.add(new Book("1984", "George Orwell", 1984));
        libraryBooks.add(new Book("Great Expectations", "Charles Dickens", 1861));
        Library library = new Library(libraryBooks);

        UserInteractionManager interactionManager = new UserInteractionManager(library);
        Scanner scanner = new Scanner(System.in);

        interactionManager.showMessage(MessageType.WELCOME_GREETING);
        interactionManager.showMenuOptions();
        String userSelectedOption = scanner.nextLine();
        interactionManager.handleSelectedOption(userSelectedOption);
    }
}
