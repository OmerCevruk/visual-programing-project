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
public class ParentAuth {
    Connection conn = new JDBCPostgreSQLConnection().connect();
    PreparedStatement pstmt;
    public static boolean authenticated = false;
    public static String  userName = "John Doe";
    public static int parentId = 0;

    public ParentAuth() {
        try {
            this.pstmt = conn.prepareStatement("SELECT * FROM public.parent WHERE \"FullName\" = ? AND \"Password\" = ?");
        } catch (SQLException ex) {
            Logger.getLogger(ParentAuth.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean authenticate(String username, String password) throws SQLException {
        if(!authenticated){
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                this.authenticated = true;
                this.userName = username;
                return true;
            }
        }else{
            return true;
        }
        return false;
    } 
}
