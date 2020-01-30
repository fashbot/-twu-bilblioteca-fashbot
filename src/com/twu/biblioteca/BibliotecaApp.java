package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private LibraryCatalogueManager library;

    public static void main(String[] args) {


        ArrayList libraryBooks = new ArrayList();
        libraryBooks.add(new Book("1984", "George Orwell", 1984));
        libraryBooks.add(new Book("Great Expectations", "Charles Dickens", 1861));
        LibraryCatalogueManager libraryManager = new LibraryCatalogueManager(libraryBooks);

        MenuOptionsManager menuOptionsManager = new MenuOptionsManager(libraryManager);

        Scanner scanner = new Scanner(System.in);
        PrintUtil printFormatter = new PrintUtil();

        printFormatter.showFormattedMessage(MessageType.WELCOME_GREETING);

        boolean isInValidOptionSelected = true;

        while(isInValidOptionSelected) {
            menuOptionsManager.showMenuOptions();
            String userSelectedOption = scanner.nextLine();

            switch(userSelectedOption) {
                case "1":
                    libraryManager.showFormattedLibraryCatalogue();
                    break;

                case "2":
                   libraryManager.showCheckoutOption();
                    break;

                case "3":
                    libraryManager.showReturnBookOption();
                    break;
                case "QUIT":
                    System.out.println("GOODBYE!");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Please select a valid option!");
            }
        }

    }


}
