package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.MessageType.BOOK_LIST_INTRO;

public class MessageManager {

    public void showMessage(MessageType type) {
        System.out.println(type.message);
    }

    public void showLibraryCatalogue(Library library) {
        ArrayList<Book> list = library.getCatalogue();

        showMessage(BOOK_LIST_INTRO);
        for (var item : list) {
            System.out.println(item.name);
        }
    }


}
