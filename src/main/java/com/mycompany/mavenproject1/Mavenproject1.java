/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author funghu
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        JDBCPostgreSQLConnection connect = new JDBCPostgreSQLConnection();
        Connection conn = connect.connect();
        
        
    }
}
