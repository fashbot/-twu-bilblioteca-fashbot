package com.twu.biblioteca;

public class PrintUtil {

    public void showFormattedMessage(MessageType type) {
        System.out.println(" ");
        System.out.println(type.message);
        System.out.println(" ");
    }
    public void printSuccessCheckoutMessage(){
        System.out.println("Thank you! Enjoy the book.");
    }

    public void printFailedCheckoutMessage(){
        System.out.println("Sorry, that book is not available");
    }

    public void printSuccessReturnMessage(){
        System.out.println("Thank you for returning the book");
    }

    public void printFailedReturnMessage(){
        System.out.println("That is not a valid book to return");
    }
}



