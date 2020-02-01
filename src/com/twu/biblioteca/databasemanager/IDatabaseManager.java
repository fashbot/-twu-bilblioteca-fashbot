package com.twu.biblioteca.databasemanager;

interface IDatabaseManager {

    boolean isItemValidToCheckout(String itemTitle);

    boolean isItemValidToReturn(String itemTitle);

}
