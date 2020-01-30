package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.MessageType.BOOK_LIST_INTRO;

public class LibraryCatalogueManager {


    public ArrayList<Book> bookItems;
    public ArrayList<Book> originalBookItems;
    private PrintUtil printUtil = new PrintUtil();

    Scanner scanner = new Scanner(System.in);

    public LibraryCatalogueManager(ArrayList<Book> bookItems) {
        this.bookItems = bookItems;
        this.originalBookItems = new ArrayList<>(bookItems);
    }

    public ArrayList<Book> getCatalogue() {
        return bookItems;
    }

    public void showFormattedLibraryCatalogue() {

        printUtil.showFormattedMessage(BOOK_LIST_INTRO);

        for (int i = 0; i < bookItems.size(); i++) {
            Book item = bookItems.get(i);
            int listPosition = i + 1;

            System.out.println(listPosition + ". ");
            item.printBookInformation();
        }
    }

    public void checkoutBook(String enteredTitle) {
        bookItems.removeIf(book -> enteredTitle.toUpperCase().equals(book.title.toUpperCase()));
    }

    private void addBookToCatalogue(Book book) {
        bookItems.add(book);
    }

    private boolean isValidBookTitle(String givenBookTitle) {
        for (Book book : bookItems) {
            if (book.title.toUpperCase().equals(givenBookTitle.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public void showCheckoutOption() {
        System.out.println("Enter the title of the book to checkout");
        String bookTitle = scanner.nextLine();
        if (isValidBookTitle(bookTitle)) {
            checkoutBook(bookTitle);
            printUtil.printSuccessCheckoutMessage();
        } else {
            printUtil.printFailedCheckoutMessage();
        }
    }

    public void showReturnBookOption() {
        System.out.println("Enter the title of the book you would like to return");
        String titleOfBookToReturn = scanner.nextLine();
        returnBook(titleOfBookToReturn);
    }

    private boolean isValidBookToReturn(String givenBookTitle) {
        for (Book book : originalBookItems) {
            if (book.title.toUpperCase().equals(givenBookTitle.toUpperCase())) {
                addBookToCatalogue(book);
                return true;
            }
        }
        return false;
    }

    public void returnBook(String titleOfBookToReturn) {
            if (isValidBookToReturn(titleOfBookToReturn)) {
                printUtil.printSuccessReturnMessage();
            } else {
                printUtil.printFailedReturnMessage();
            }
    }


}
