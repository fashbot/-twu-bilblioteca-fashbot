package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

import static com.twu.biblioteca.MessageType.BOOK_LIST_INTRO;

public class LibraryCatalogueManager {


    public ArrayList<Book> bookItems;
    private PrintUtil printUtil  = new PrintUtil();
    Scanner scanner = new Scanner(System.in);

    public LibraryCatalogueManager(ArrayList<Book> bookItems){
        this.bookItems = bookItems;
    }

    public ArrayList<Book> getCatalogue(){
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

    public void checkoutBook(String enteredTitle){
        bookItems.removeIf( book -> enteredTitle.toUpperCase().equals(book.title.toUpperCase()));
    }

    private boolean isValidBookTitle(String givenBookTitle){
        for (Book book: bookItems){
            if(book.title.toUpperCase().equals(givenBookTitle.toUpperCase())){
                return true;
            }
        }
        return false;
    }

    public void showCheckoutOption(){
        System.out.println("Enter the title of the book to checkout");
        String bookTitle = scanner.nextLine();
        if(isValidBookTitle(bookTitle)){
            checkoutBook(bookTitle);
            printUtil.printSuccessCheckoutMessage();
        } else {
            printUtil.printFailedCheckoutMessage();
        }
    }


}
