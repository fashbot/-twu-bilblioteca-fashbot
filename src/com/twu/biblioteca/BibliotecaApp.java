package com.twu.biblioteca;


import com.twu.biblioteca.CommandLineInteraction.ICommandLineInteractionManager;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.twu.biblioteca.MessageContent.GOOD_BYE;
import static com.twu.biblioteca.MessageContent.MENU_OPTION_UNAVAILABLE;

public class BibliotecaApp {


    public static void main(String[] args) throws InterruptedException {

        ICommandLineInteractionManager userInteractionManager = LibraryCatalogueFactory.INSTANCE.getInstance();

        Scanner scanner = new Scanner(System.in);
        PrintUtil printUtil = new PrintUtil();

        printUtil.showFormattedMessage(MessageContent.WELCOME_GREETING);

        while (true) {

            TimeUnit.SECONDS.sleep(2);

            boolean isAccessGranted = userInteractionManager.requestCredentials();

            if (isAccessGranted) {

                userInteractionManager.showMenuOptions();
                String userSelectedOption = scanner.nextLine();


                TimeUnit.SECONDS.sleep(1);

                switch (userSelectedOption) {
                    case "1":
                        userInteractionManager.showLibraryBookCatalogue();
                        break;

                    case "2":
                        userInteractionManager.showBookCheckoutOption();
                        break;

                    case "3":
                        userInteractionManager.showBookReturnOption();
                        break;

                    case "4":
                        userInteractionManager.showLibraryMovieCatalogue();
                        break;

                    case "5":
                        userInteractionManager.showMovieCheckoutOption();
                        break;

                    case "6":
                        userInteractionManager.showMovieReturnOption();
                        break;

                    case "QUIT":
                    case "quit":
                       userInteractionManager.exit();
                        break;
                    default:
                        printUtil.print(MENU_OPTION_UNAVAILABLE);
                }
                TimeUnit.SECONDS.sleep(1);

            }
        }

    }


}
