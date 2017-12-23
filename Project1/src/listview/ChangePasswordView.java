/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listview;

import javax.swing.JOptionPane;
import model.connectDatabase.ConnectAccount;
import model.employee.Account;
import model.employee.Employee;

/**
 *
 * @author leo
 */
public class ChangePasswordView extends javax.swing.JFrame {
    public static final int CHECK_ACCOUNT = 1;
    public static final int SAVE_ACCOUNT = 2;
    private Employee salesman;
    /**
     * Creates new form ChangePasswordView
     */

    
    public ChangePasswordView(Employee salesman, int option) {
        initComponents();
        setLocationRelativeTo(null);
        System.out.println(salesman);
        this.salesman = salesman;
        if (option == CHECK_ACCOUNT) {
            setCheckAccountView();
        } else if (option == SAVE_ACCOUNT) {
            setSaveAccountView();
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblSecondPwd = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        pfFirstPwd = new javax.swing.JPasswordField();
        pfSecondPwd = new javax.swing.JPasswordField();
        lblInfo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change account's info");

        jLabel1.setText("Username");

        txtUsername.setPreferredSize(new java.awt.Dimension(150, 28));
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        jLabel2.setText("Password");

        lblSecondPwd.setText("Password");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        pfFirstPwd.setPreferredSize(new java.awt.Dimension(150, 28));
        pfFirstPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfFirstPwdActionPerformed(evt);
            }
        });

        pfSecondPwd.setPreferredSize(new java.awt.Dimension(150, 28));
        pfSecondPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfSecondPwdActionPerformed(evt);
            }
        });

        lblInfo.setText("Retype your's account' info.");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSecondPwd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pfFirstPwd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pfSecondPwd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfFirstPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSecondPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfSecondPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(jButton1))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pfSecondPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfSecondPwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfSecondPwdActionPerformed

    private void pfFirstPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfFirstPwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfFirstPwdActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (txtUsername.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Input username");
            return;
        }
        
        if (pfFirstPwd.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Input password");
            return;
        }
        
        if (salesman.getAccount().equals(new Account(txtUsername.getText(), pfFirstPwd.getText()))) {
            this.dispose();
            new ChangePasswordView(salesman, ChangePasswordView.SAVE_ACCOUNT).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Account's info's invalid");
        }
         
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (txtUsername.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Input username");
            return;
        }
        
        if (pfFirstPwd.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Input password");
            return;
        }
        
        if (pfSecondPwd.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ReInput password");
            return;
        }
        
        if (pfFirstPwd.getText().equals(pfSecondPwd.getText())) {
            Account newAccount = new Account(txtUsername.getText(), pfFirstPwd.getText());
            salesman.setAccount(newAccount);
            ConnectAccount.saveChangedAccount(newAccount, salesman.getEmployeeId());
            JOptionPane.showMessageDialog(null, "OK");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Two password not like each other");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblSecondPwd;
    private javax.swing.JPasswordField pfFirstPwd;
    private javax.swing.JPasswordField pfSecondPwd;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void setCheckAccountView() {
        btnSave.setVisible(false);
        lblSecondPwd.setVisible(false);
        pfSecondPwd.setVisible(false);
        
    }

    private void setSaveAccountView() {
        btnSave.setVisible(true);
        jButton1.setVisible(false);
        lblSecondPwd.setVisible(true);
        pfSecondPwd.setVisible(true);
        
        lblInfo.setText("Input new Account' info");
    }
}