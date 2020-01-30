package com.twu.biblioteca;

import java.util.ArrayList;

public class Library{

    public ArrayList<Book> bookItems;

    public Library(ArrayList<Book> bookItems){
        this.bookItems = bookItems;
    }

    public ArrayList<Book> getCatalogue(){
        return bookItems;
    }

}
