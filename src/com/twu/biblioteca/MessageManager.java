package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.MessageType.BOOK_LIST_INTRO;


public class MessageManager {

    public void showMessage(MessageType type) {
        System.out.println(type.message);
        printDivider();
    }

    public void showLibraryCatalogue(Library library) {
        ArrayList<Book> list = library.getCatalogue();

        showMessage(BOOK_LIST_INTRO);
        for (int i = 0; i < list.size(); i++) {
            Book item = list.get(i);
            int listPosition = i + 1;

            System.out.println(listPosition + ". ");
            item.printBookInformation();
        }
    }

    private void printDivider() {
        System.out.println("=====================================");
    }


}
