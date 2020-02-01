package com.twu.biblioteca.loginManager;

import com.twu.biblioteca.useraccounts.UserAccount;

import java.util.ArrayList;

public class LoginManager {

    public UserAccount signedInUser;

    public boolean isValidUser(String libraryNumber, String password) {

        for (UserAccount account : getAllUserAccounts()) {

            boolean hasSameLibraryName = account.getLibraryNumber().equals(libraryNumber);
            boolean hasSamePassword = account.getPassword().equals(password);

            if (hasSameLibraryName && hasSamePassword) return true;
        }
        return false;
    }

    public ArrayList<UserAccount> getAllUserAccounts() {
        ArrayList<UserAccount> accounts = new ArrayList<>();
        accounts.add(new UserAccount("333-3333", "Icecream"));
        accounts.add(new UserAccount("333-3334", "Ice5cream"));
        return accounts;
    }

    public UserAccount updateCurrentUser(String libraryNumber, String password){

        for (UserAccount account : getAllUserAccounts()) {

            boolean hasSameLibraryName = account.getLibraryNumber().equals(libraryNumber);
            boolean hasSamePassword = account.getPassword().equals(password);

            if (hasSameLibraryName && hasSamePassword)
                signedInUser = account;
                return account;
        }
        return new UserAccount(null, null);
    }


}
