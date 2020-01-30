package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.MessageType.*;

public class UserInteractionsManager implements ICommandLineInteractionManager {

    private PrintUtil printUtil = new PrintUtil();

    private LibraryBookDatabaseManager bookDatabaseManager;

    Scanner scanner = new Scanner(System.in);

    public UserInteractionsManager(LibraryBookDatabaseManager bookDatabaseManager) {
        this.bookDatabaseManager = bookDatabaseManager;
    }

    @Override
    public void showLibraryCatalogue() {

        printUtil.showFormattedMessage(BOOK_LIST_INTRO);

        ArrayList<Book> bookList = bookDatabaseManager.getListOfBooks();

        for (int i = 0; i < bookList.size(); i++) {
            Book item = bookList.get(i);
            int listPosition = i + 1;

            System.out.println(listPosition + ". ");
            printUtil.printBookInformation(item);
        }
    }

    @Override
    public void showMenuOptions() {
        printUtil.print(SPACE);
        printUtil.print(CHOOSE_MENU_OPTION);

        printUtil.printDivider();

        for (var i = 0; i < MenuOptionsList.values().length; i++) {
            String position = (i + 1) + ") ";
            System.out.println(position + MenuOptionsList.values()[i].option);
        }

        printUtil.printDivider();
        printUtil.print(SPACE);
        printUtil.print(EXIT_APPLICATION);
    }

    @Override
    public void showCheckoutOption() {
        printUtil.print(CHECKOUT_INTRO);
        String bookTitle = scanner.nextLine();
        if (!bookDatabaseManager.isValidBookToCheckout(bookTitle)) {
            printUtil.print(CHECKOUT_FAILED);
        } else {
            printUtil.print(CHECKOUT_SUCCESS);
        }
    }


    @Override
    public void showReturnBookOption() {
        printUtil.print(RETURN_BOOK_INTRO);
        String titleOfBookToReturn = scanner.nextLine();
        if (bookDatabaseManager.isValidBookToReturn(titleOfBookToReturn)) {
            printUtil.print(RETURN_SUCCESS);

        } else {
            printUtil.print(RETURN_FAILED);
        }
    }
}
