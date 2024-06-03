package com.mycompany.mavenproject1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author funghu
 */
public class ManagerAuth {
    Connection conn = new JDBCPostgreSQLConnection().connect();
    PreparedStatement pstmt;
    public static boolean authenticated = false;
    public static String UserName = "John Doe";

    public ManagerAuth() {
        try {
            this.pstmt = conn.prepareStatement("SELECT * FROM public.manager WHERE \"FullName\" = ? AND \"Password\" = ?");
        } catch (SQLException ex) {
            Logger.getLogger(ManagerAuth.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean authenticate(String username, String password) throws SQLException {
        if (!authenticated) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                authenticated = true;
                UserName = username;
                return true;
            }
        } else {
            return true;
        }
        return false;
    }

    public void logout() {
        authenticated = false;
        UserName = "John Doe";
    }
}
