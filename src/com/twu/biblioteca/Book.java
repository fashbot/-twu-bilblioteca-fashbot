package com.twu.biblioteca;

public class Book {

    public String title;
    public String author;
    public int publicationYear;

    public final static String BOOK_TITLE_HEADER = "Title: ";
    public final static String BOOK_AUTHOR_HEADER = "Author: ";
    public final static String BOOK_PUBLICATION_YEAR_HEADER = "Publication year: ";

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public void printBookInformation(){
        System.out.println(BOOK_TITLE_HEADER + title);
        System.out.println(BOOK_AUTHOR_HEADER + author);
        System.out.println(BOOK_PUBLICATION_YEAR_HEADER + publicationYear);
        System.out.println(" ");
    }

}
