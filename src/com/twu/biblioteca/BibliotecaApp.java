package com.twu.biblioteca;


import com.twu.biblioteca.CommandLineInteraction.ICommandLineInteractionManager;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static com.twu.biblioteca.MessageType.GOOD_BYE;
import static com.twu.biblioteca.MessageType.MENU_OPTION_UNAVAILABLE;

public class BibliotecaApp {


    public static void main(String[] args) throws InterruptedException {

        ICommandLineInteractionManager userInteractionManager = LibraryCatalogueFactory.INSTANCE.getInstance();

        Scanner scanner = new Scanner(System.in);
        PrintUtil printUtil = new PrintUtil();

        printUtil.showFormattedMessage(MessageType.WELCOME_GREETING);

        while(true) {

            TimeUnit.SECONDS.sleep(2);

            userInteractionManager.showMenuOptions();
            String userSelectedOption = scanner.nextLine();


            TimeUnit.SECONDS.sleep(1);

            switch(userSelectedOption) {
                case "1":
                    userInteractionManager.showLibraryBookCatalogue();
                    TimeUnit.SECONDS.sleep(1);
                    break;

                case "2":
                   userInteractionManager.showBookCheckoutOption();
                    TimeUnit.SECONDS.sleep(1);
                    break;

                case "3":
                    userInteractionManager.showBookReturnOption();
                    TimeUnit.SECONDS.sleep(1);
                    break;

                case "4":
                    userInteractionManager.showLibraryMovieCatalogue();
                    TimeUnit.SECONDS.sleep(1);
                    break;

                case "5":
                    userInteractionManager.showMovieCheckoutOption();
                    TimeUnit.SECONDS.sleep(1);
                    break;

                case "6":
                    userInteractionManager.showMovieReturnOption();
                    TimeUnit.SECONDS.sleep(1);
                    break;

                case "QUIT": case "quit" :
                    printUtil.print(GOOD_BYE);
                    TimeUnit.SECONDS.sleep(1);
                    System.exit(1);
                    break;
                default:
                    printUtil.print(MENU_OPTION_UNAVAILABLE);
            }
        }

    }


}
