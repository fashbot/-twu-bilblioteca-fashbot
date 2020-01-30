package com.twu.biblioteca;

import java.util.ArrayList;

import static com.twu.biblioteca.MessageType.BOOK_LIST_INTRO;


public class UserInteractionManager {

    private Library library;

    public UserInteractionManager(Library library) {
        this.library = library;

    }

    public void showMessage(MessageType type) {
        System.out.println(" ");
        System.out.println(type.message);
        System.out.println(" ");
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

    public void showMenuOptions() {
        System.out.println(" ");
        System.out.println("CHOOSE THE APPROPRIATE NUMBER TO SELECT A MENU OPTION.");

        printDivider();

        for (var i = 0; i < MenuOptionsList.values().length; i++) {
            String position = (i + 1) + ") ";
            System.out.println(position + MenuOptionsList.values()[i].option);
        }

        printDivider();
    }

    public void handleSelectedOption(String string) {
        switch (Integer.parseInt(string)) {
            case 1:
                showLibraryCatalogue(library);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + string);
        }

    }


}
