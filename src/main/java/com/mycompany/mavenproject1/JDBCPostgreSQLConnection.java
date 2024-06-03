package com.mycompany.mavenproject1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCPostgreSQLConnection {
    private final String url = "jdbc:postgresql://localhost/VisualDB3"; //name of your database name
    private final String user = "postgres"; // user name of your postgre (default is postgres if havent changed)
    private final String password = "1234"; // password of your postgre

    
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                System.out.println("Connected to the PostgreSQL server successfully.");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

   
}
