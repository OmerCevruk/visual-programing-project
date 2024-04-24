/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import com.managementLoginFrame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author funghu
 */
public class Mavenproject1 {
    
    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
                        
        System.out.println("Hello World!");
        JDBCPostgreSQLConnection connect = new JDBCPostgreSQLConnection();
        Connection conn = connect.connect();
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create and display the GUI
                new managementLoginFrame().setVisible(true);
            }
        });

        
        
    }
}
