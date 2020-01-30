package com.twu.biblioteca;

import java.util.Scanner;

import static com.twu.biblioteca.MessageType.GOOD_BYE;
import static com.twu.biblioteca.MessageType.MENU_OPTION_UNAVAILABLE;

public class BibliotecaApp {


    public static void main(String[] args) {

        ICommandLineInteractionManager libraryManager = LibraryCatalogueFactory.INSTANCE.getInstance();

        Scanner scanner = new Scanner(System.in);
        PrintUtil printUtil = new PrintUtil();

        printUtil.showFormattedMessage(MessageType.WELCOME_GREETING);

        while(true) {

            libraryManager.showMenuOptions();
            String userSelectedOption = scanner.nextLine();

            switch(userSelectedOption) {
                case "1":
                    libraryManager.showLibraryCatalogue();
                    break;

                case "2":
                   libraryManager.showCheckoutOption();
                    break;

                case "3":
                    libraryManager.showReturnBookOption();
                    break;
                case "QUIT": case "quit" :
                    printUtil.print(GOOD_BYE);
                    System.exit(1);
                    break;
                default:
                    printUtil.print(MENU_OPTION_UNAVAILABLE);
            }
        }

    }


}
