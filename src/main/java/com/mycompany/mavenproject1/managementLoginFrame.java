package com.mycompany.mavenproject1;


/*import javax.swing.SwingUtilities;



public class managementLoginFrame extends javax.swing.JFrame {
=======
import com.mycompany.mavenproject1.JDBCPostgreSQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ManagementLoginFrame extends javax.swing.JFrame {
>>>>>>> Stashed changes:src/main/java/managementLoginFrame.java

private final JDBCPostgreSQLConnection connect;

    public ManagementLoginFrame() {
        initComponents();
        connect = new JDBCPostgreSQLConnection();
    }
<<<<<<< Updated upstream:src/main/java/com/mycompany/mavenproject1/managementLoginFrame.java

    private void applyStyles() {
        // Load CSS
        StyleSheet styleSheet = new StyleSheet();
        styleSheet.importStyleSheet(getClass().getResource("/styles.css"));

        // Apply CSS to components
        SwingUtilities.updateComponentTreeUI(this);
    }

 
    
>>>>>>> Stashed changes:src/main/java/managementLoginFrame.java
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ManagementLogin = new javax.swing.JLabel();
        LoginContainer = new javax.swing.JPanel();
        FullNameLabel = new javax.swing.JLabel();
        FullName = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        Login = new javax.swing.JButton();
        PasswordLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout(0, 10));

        ManagementLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ManagementLogin.setText("Management Login");
        getContentPane().add(ManagementLogin, java.awt.BorderLayout.NORTH);

        FullNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        FullNameLabel.setText("Full Name");

        FullName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FullNameActionPerformed(evt);
            }
        });

        Password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });

        Login.setText("Login");
        Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        PasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PasswordLabel.setText("Password");

        javax.swing.GroupLayout LoginContainerLayout = new javax.swing.GroupLayout(LoginContainer);
        LoginContainer.setLayout(LoginContainerLayout);
        LoginContainerLayout.setHorizontalGroup(
            LoginContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginContainerLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addGroup(LoginContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FullName)
                    .addComponent(FullNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(184, 184, 184))
        );
        LoginContainerLayout.setVerticalGroup(
            LoginContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(PasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(Login)
                .addGap(39, 39, 39))
        );

        getContentPane().add(LoginContainer, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FullNameActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        String fullNameValue = FullName.getText();
        String passwordValue = new String(Password.getPassword());

        try (Connection conn = connect.connect()) {
            String sql = "INSERT INTO public.management(\"FullName\", \"Password\") VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, fullNameValue);
            pstmt.setString(2, passwordValue);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Successfully logged in");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordActionPerformed
    
    
    public static void main(String args[]) {
    

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagementLoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FullName;
    private javax.swing.JLabel FullNameLabel;
    private javax.swing.JButton Login;
    private javax.swing.JPanel LoginContainer;
    private javax.swing.JLabel ManagementLogin;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel PasswordLabel;
    // End of variables declaration//GEN-END:variables
}
*/