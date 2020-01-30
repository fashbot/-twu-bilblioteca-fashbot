package com.twu.biblioteca;

public class MessageManager {

    public void showMessage(MessageType type) {
        switch (type) {
            case WELCOME_GREETING:
                System.out.println(type.message);
                break;
            default:
        }
    }
}
