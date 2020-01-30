package com.twu.biblioteca;

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
                    userInteractionManager.showLibraryCatalogue();
                    TimeUnit.SECONDS.sleep(1);
                    break;

                case "2":
                   userInteractionManager.showCheckoutOption();
                    TimeUnit.SECONDS.sleep(1);
                    break;

                case "3":
                    userInteractionManager.showReturnBookOption();
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
