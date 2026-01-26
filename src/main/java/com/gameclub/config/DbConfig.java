package com.gameclub.config;

public class DbConfig {

    // Default settings from the assignment:
    public static final String URL = "jdbc:postgresql://localhost:5432/assignment3";
    public static final String USER = "postgres";
    public static final String PASSWORD = "Sayat2008";

    private DbConfig() {
        // no instances
    }

    /*
     How to change user/password:
     - If your PostgreSQL user is different, change USER
     - If your password is different, change PASSWORD
     - If you created DB with another name, change URL (database name at the end)
    */
}
