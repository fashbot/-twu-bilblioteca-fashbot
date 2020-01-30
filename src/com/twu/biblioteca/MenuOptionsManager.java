package com.twu.biblioteca;

public class MenuOptionsManager {

    private LibraryCatalogueManager library;

    public MenuOptionsManager(LibraryCatalogueManager library) {
        this.library = library;

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
        System.out.println(" ");
        System.out.println("(To exit the application, type 'QUIT')");
    }

}
