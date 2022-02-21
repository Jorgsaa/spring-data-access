package com.example.springdataaccess.data_access.util;

public class SqliteConnectionHelper {
    public static String getURL() {
        return "jdbc:sqlite:src/main/resources/Chinook_Sqlite.sqlite";
    }
}