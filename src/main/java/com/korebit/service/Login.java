package com.korebit.service;

public class Login {

    public boolean startSession(String username, String password) {
        // For demonstration purposes, we will use hardcoded credentials.
        // In a real application, you would check these against a database.
        String hardcodedUsername = "admin";
        String hardcodedPassword = "admin";

        return username.equals(hardcodedUsername) && password.equals(hardcodedPassword);
    }
}
