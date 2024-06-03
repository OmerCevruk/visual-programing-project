package com.mycompany.mavenproject1;
import com.mycompany.mavenproject1.JDBCPostgreSQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author ardacildan
 */
public class ParentAdderFrame extends javax.swing.JFrame {

    private final JDBCPostgreSQLConnection connect;
    
    public ParentAdderFrame() {
        initComponents();
        connect = new JDBCPostgreSQLConnection();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerLabel = new javax.swing.JLabel();
        studentDataPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        Fullname = new javax.swing.JTextField();
        EmailLabel = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JTextField();
        DOBLabel = new javax.swing.JLabel();
        DOBField = new javax.swing.JTextField();
        AdressLabel = new javax.swing.JLabel();
        Adress = new javax.swing.JTextField();
        CityidLabel = new javax.swing.JLabel();
        cityid = new javax.swing.JTextField();
        addParentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Parent Adder");

        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Add a parent");

        studentDataPanel.setLayout(new java.awt.GridLayout(6, 2, 0, 5));

        nameLabel.setText("Parent Name");
        studentDataPanel.add(nameLabel);

        Fullname.setText("enter Full Name");
        Fullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FullnameActionPerformed(evt);
            }
        });
        studentDataPanel.add(Fullname);

        EmailLabel.setText("Email");
        studentDataPanel.add(EmailLabel);

        email.setText("enter e-mail");
        studentDataPanel.add(email);

        passwordLabel.setText("Password");
        studentDataPanel.add(passwordLabel);

        PasswordField.setText("enter password");
        studentDataPanel.add(PasswordField);

        DOBLabel.setText("Date of birth");
        studentDataPanel.add(DOBLabel);

        DOBField.setText("enter date of birth");
        DOBField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOBFieldActionPerformed(evt);
            }
        });
        studentDataPanel.add(DOBField);

        AdressLabel.setText("Adress");
        studentDataPanel.add(AdressLabel);

        Adress.setText("enter adress");
        Adress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdressActionPerformed(evt);
            }
        });
        studentDataPanel.add(Adress);

        CityidLabel.setText("City ID");
        studentDataPanel.add(CityidLabel);

        cityid.setText("enter city id");
        studentDataPanel.add(cityid);

        addParentButton.setText("Add Parent");
        addParentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addParentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(headerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(studentDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addParentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(headerLabel)
                    .addGap(0, 0, 0)
                    .addComponent(studentDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(addParentButton)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FullnameActionPerformed

    private void DOBFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOBFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DOBFieldActionPerformed

    private void AdressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdressActionPerformed

    private void addParentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addParentButtonActionPerformed
        String fullNameValue = Fullname.getText();
        String emailValue = email.getText();
        String passwordValue = PasswordField.getText();             
        String dobValue = DOBField.getText();
        String addressValue = Adress.getText();
        int cityIDValue = Integer.parseInt(cityid.getText());

        // Date conversion
        java.sql.Date sqlDate = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = format.parse(dobValue);
            sqlDate = new java.sql.Date(parsedDate.getTime());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Error parsing date: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (Connection conn = connect.connect()) {
            String sql = "INSERT INTO public.parent(\"FullName\", \"Email\", \"Password\", \"DOB\", \"Address\", \"CityID\" ) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, fullNameValue);
            pstmt.setString(2, emailValue);
            pstmt.setString(3, passwordValue);
            pstmt.setDate(4, sqlDate);
            pstmt.setString(5, addressValue);
            pstmt.setInt(6, cityIDValue);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Parent added to system successfully");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addParentButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ParentAdderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParentAdderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParentAdderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParentAdderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParentAdderFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Adress;
    private javax.swing.JLabel AdressLabel;
    private javax.swing.JLabel CityidLabel;
    private javax.swing.JTextField DOBField;
    private javax.swing.JLabel DOBLabel;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField Fullname;
    private javax.swing.JTextField PasswordField;
    private javax.swing.JButton addParentButton;
    private javax.swing.JTextField cityid;
    private javax.swing.JTextField email;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPanel studentDataPanel;
    // End of variables declaration//GEN-END:variables
}
