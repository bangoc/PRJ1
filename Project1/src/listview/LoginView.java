/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listview;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.MyUtils.ObjectWithFile;
import model.connectDatabase.ConnectAccount;
import model.connectDatabase.ConnectMarket;
import model.employee.Account;
import model.employee.Importer;
import model.employee.Manager;
import model.employee.Salesman;

/**
 *
 * @author PhamThiDuyen
 */
public class LoginView extends javax.swing.JFrame {

    
    public LoginView() {
        initComponents();
        displaySavedAccount();
        setLanguage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        txtTaiKhoan = new javax.swing.JTextField();
        pfMatKhau = new javax.swing.JPasswordField();
        btnDangNhap = new javax.swing.JButton();
        cbLuuMK = new javax.swing.JCheckBox();
        lblTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        img = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblUser.setText("Username");

        lblPass.setText("Password");

        txtTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTaiKhoanActionPerformed(evt);
            }
        });
        txtTaiKhoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTaiKhoanKeyReleased(evt);
            }
        });

        pfMatKhau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pfMatKhauKeyReleased(evt);
            }
        });

        btnDangNhap.setText("Log in");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        cbLuuMK.setSelected(true);
        cbLuuMK.setText("Save");

        lblTitle.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 102, 102));
        lblTitle.setText("Supermarket Management System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDangNhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbLuuMK))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser)
                            .addComponent(lblPass))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(pfMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangNhap)
                    .addComponent(cbLuuMK))
                .addGap(41, 41, 41))
        );

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed

        if (txtTaiKhoan.getText().equals("") || pfMatKhau.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nhap du tai khoan mat khau vao");
            return;
        }      
        
        Account account = new Account(txtTaiKhoan.getText(), pfMatKhau.getText());
        Object object = ConnectAccount.createLogin(account);
        if (object instanceof Importer) {
            this.dispose();
            
            new ImporterView((Importer) object, ConnectMarket.getSuppliers()).setVisible(true);
            processSavedAccount(account);
        } else if (object instanceof Manager) {
            this.dispose();
            new ManagerView((Manager) object).setVisible(true);
            processSavedAccount(account);
        } else if (object instanceof Salesman) {
            this.dispose();
            new SalesmanView((Salesman) object).setVisible(true);
            processSavedAccount(account);
        } else {
            JOptionPane.showMessageDialog(null, "Tai khoan khong hop le");
            
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void txtTaiKhoanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTaiKhoanKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)pfMatKhau.requestFocus();
    }//GEN-LAST:event_txtTaiKhoanKeyReleased

    private void pfMatKhauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfMatKhauKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)btnDangNhap.doClick();
    }//GEN-LAST:event_pfMatKhauKeyReleased

    private void txtTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:

        this.dispose();
        new ManageEmployeeView().setVisible(true);
    }                                           

                                               


    private void processSavedAccount(Account account) {
        try {
            if (cbLuuMK.isSelected()) {
                ObjectWithFile.saveAccountToFile(account);
            } else {
                ObjectWithFile.saveAccountToFile(new Account("", ""));
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */

       
    }
    
    private void displaySavedAccount() {
        try {
            Account account = ObjectWithFile.getAccountFromFile();
            if (account.getUsername().equals("") && account.getPassword().equals("")) {
                cbLuuMK.setSelected(false);
            } else {
                txtTaiKhoan.setText(account.getUsername());
                pfMatKhau.setText(account.getPassword());

            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setLanguage() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resourceBundle.Label");
        btnDangNhap.setText(resourceBundle.getString("Login"));
        cbLuuMK.setText(resourceBundle.getString("Save"));
        lblUser.setText(resourceBundle.getString("Username"));
        lblPass.setText(resourceBundle.getString("Password"));
        lblTitle.setText(resourceBundle.getString("SMS"));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JCheckBox cbLuuMK;
    private javax.swing.JLabel img;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField pfMatKhau;
    private javax.swing.JTextField txtTaiKhoan;
    // End of variables declaration//GEN-END:variables
}