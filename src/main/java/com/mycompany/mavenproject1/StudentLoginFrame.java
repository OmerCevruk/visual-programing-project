package com.mycompany.mavenproject1;
import com.mycompany.mavenproject1.JDBCPostgreSQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.*;

public class StudentLoginFrame extends javax.swing.JFrame {

    private final JDBCPostgreSQLConnection connect;
    public StudentLoginFrame() {
        initComponents();
        connect = new JDBCPostgreSQLConnection();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StudentLoginLabel = new javax.swing.JLabel();
        StudentIDLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        studentIDField = new javax.swing.JTextField();
        LoginButton = new javax.swing.JScrollPane();
        loginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        StudentLoginLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        StudentLoginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StudentLoginLabel.setText("Student Login");

        StudentIDLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        StudentIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StudentIDLabel.setText("Student ID");

        PasswordLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        PasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PasswordLabel.setText("Password");

        passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        studentIDField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        studentIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentIDFieldActionPerformed(evt);
            }
        });

        loginButton.setText("Log in");
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        LoginButton.setViewportView(loginButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 204, Short.MAX_VALUE)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(StudentLoginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StudentIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PasswordLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(studentIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(StudentLoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(StudentIDLabel)
                .addGap(12, 12, 12)
                .addComponent(studentIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void studentIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIDFieldActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String studentID = studentIDField.getText();
        String password = new String(passwordField.getPassword());
        
        if (studentID.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both student ID and password.");
            return;
        }
        
        try (Connection conn = connect.connect()) {
            String sql = "SELECT \"ChildID\", \"FullName\"  FROM child WHERE \"ChildID\" = ? AND \"Password\" = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(studentID));
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                // Retrieve the student's full name
                int childID = rs.getInt("ChildID");
                String fullName = rs.getString("Fullname");

                // Redirect to student dashboard
                new StudentDashboardFrame(childID, fullName).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid student ID or password.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error logging in.");
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentLoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane LoginButton;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel StudentIDLabel;
    private javax.swing.JLabel StudentLoginLabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField studentIDField;
    // End of variables declaration//GEN-END:variables
}
