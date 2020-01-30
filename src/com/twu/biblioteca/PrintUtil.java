package com.twu.biblioteca;

public class PrintUtil {

    public final static String BOOK_TITLE_HEADER = "Title: ";
    public final static String BOOK_AUTHOR_HEADER = "Author: ";
    public final static String BOOK_PUBLICATION_YEAR_HEADER = "Publication year: ";

    public void showFormattedMessage(MessageType type) {
        System.out.println(" ");
        System.out.println(type.message);
        System.out.println(" ");
    }

    public void print(MessageType messageType){
        System.out.println(messageType.message);
    }

    public void printBookInformation(Book book){
        System.out.println(BOOK_TITLE_HEADER + book.title);
        System.out.println(BOOK_AUTHOR_HEADER + book.author);
        System.out.println(BOOK_PUBLICATION_YEAR_HEADER + book.publicationYear);
        System.out.println(" ");
    }

    public void printDivider() {
        System.out.println("=====================================");
    }

}



