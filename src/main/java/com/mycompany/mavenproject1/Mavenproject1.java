package com.mycompany.mavenproject1;
import com.mycompany.mavenproject1.ManagementLoginFrame;

import java.sql.Connection;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
//import com.managementLoginFrame;


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
            new ManagementLoginFrame().setVisible(true);
            }
        });

        
        
    }
}
