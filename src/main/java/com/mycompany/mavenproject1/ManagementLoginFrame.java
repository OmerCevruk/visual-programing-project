package com.mycompany.mavenproject1;

import com.mycompany.mavenproject1.JDBCPostgreSQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ManagementLoginFrame extends javax.swing.JFrame {

private final JDBCPostgreSQLConnection connect;

    public ManagementLoginFrame() {
        initComponents();
        connect = new JDBCPostgreSQLConnection();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JButton();
        PasswordLabel = new javax.swing.JLabel();
        FullNameLabel = new javax.swing.JLabel();
        FullName = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        ManagementLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Login.setText("Login");
        Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        PasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PasswordLabel.setText("Password");

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

        ManagementLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ManagementLogin.setText("Management Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FullName)
                    .addComponent(FullNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Password, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(PasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(183, 183, 183))
            .addGroup(layout.createSequentialGroup()
                .addComponent(ManagementLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(ManagementLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(FullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(PasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(Login)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
         String fullNameValue = FullName.getText();
        String passwordValue = new String(Password.getPassword());

        try (Connection conn = connect.connect()) {
            
            String sql = "SELECT * FROM public.manager WHERE \"FullName\" = ? AND \"Password\" = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, fullNameValue);
            pstmt.setString(2, passwordValue);
            
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()){
                JOptionPane.showMessageDialog(this, "Successfully logged in");
            }else{
                // Login failed
                JOptionPane.showMessageDialog(this, "Login failed. Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void FullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FullNameActionPerformed

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
    private javax.swing.JLabel ManagementLogin;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel PasswordLabel;
    // End of variables declaration//GEN-END:variables
}
