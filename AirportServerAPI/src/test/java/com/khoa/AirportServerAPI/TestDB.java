package com.khoa.AirportServerAPI;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDB {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/airport_api_db?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "Loan1973.";
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connected successfully!");
        conn.close();
    }
}

