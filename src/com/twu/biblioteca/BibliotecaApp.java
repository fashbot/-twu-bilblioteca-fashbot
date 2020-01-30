package com.twu.biblioteca;

public class BibliotecaApp {

    private MessageManager messageManager;

    public static void main(String[] args) {
        MessageManager messageManager = new MessageManager();
        messageManager.showMessage(MessageType.WELCOME_GREETING);
    }
}
