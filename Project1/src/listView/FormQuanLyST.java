/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listView;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.connectDatabase.ConnectEmployee;
import model.employee.Employee;

/**
 *
 * @author PhamThiDuyen
 */
public class FormQuanLyST extends javax.swing.JFrame {

    /**
     * Creates new form FormDangNhap
     */
    public FormQuanLyST() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        btnDangXuat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnQuanLiNV = new javax.swing.JButton();
        btnCaiDat = new javax.swing.JButton();
        btnQuanLiSP = new javax.swing.JButton();
        btnQuanLiST = new javax.swing.JButton();
        imgQuanLiNhanVien = new javax.swing.JLabel();
        imgBanHang = new javax.swing.JLabel();
        imgCaiDat = new javax.swing.JLabel();
        imgQuanLySP = new javax.swing.JLabel();
        imgQuanLyST = new javax.swing.JLabel();
        btnQuanLyNCC = new javax.swing.JButton();
        imgNCC = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Chào Mừng Đến Với Hệ thống Quản Lí Siêu Thị");

        btnDangXuat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDangXuat.setText("Đăng Xuất");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(103, 103, 103)
                .addComponent(btnDangXuat)
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDangXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnQuanLiNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnQuanLiNV.setText("Quản Lí Nhân Viên");
        btnQuanLiNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLiNVActionPerformed(evt);
            }
        });

        btnCaiDat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCaiDat.setText("Cài Đặt");
        btnCaiDat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaiDatActionPerformed(evt);
            }
        });

        btnQuanLiSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnQuanLiSP.setText("Quản Lí Sản Phẩm");
        btnQuanLiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLiSPActionPerformed(evt);
            }
        });

        btnQuanLiST.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnQuanLiST.setText("Quản Lí Siêu Thị");
        btnQuanLiST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLiSTActionPerformed(evt);
            }
        });

        imgQuanLiNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/users-icon.png"))); // NOI18N

        imgCaiDat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Settings-icon.png"))); // NOI18N

        imgQuanLySP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Ecommerce-Product-icon.png"))); // NOI18N

        imgQuanLyST.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Picture-Manager-icon.png"))); // NOI18N

        btnQuanLyNCC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnQuanLyNCC.setText("Quản Lý Nhà Cung Cấp");
        btnQuanLyNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyNCCActionPerformed(evt);
            }
        });

        imgNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cargo-2-icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(imgQuanLiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnQuanLiNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(imgBanHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgCaiDat)
                            .addComponent(imgNCC))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnQuanLyNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCaiDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(176, 176, 176)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnQuanLiSP, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(btnQuanLiST, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imgQuanLySP)
                    .addComponent(imgQuanLyST))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuanLiNV)
                            .addComponent(btnQuanLiSP)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(imgQuanLiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(imgQuanLySP)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(imgQuanLyST))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imgCaiDat)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnQuanLiST)
                                .addComponent(imgBanHang)
                                .addComponent(btnCaiDat)))))
                .addGap(98, 98, 98)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuanLyNCC)
                    .addComponent(imgNCC))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuanLiSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLiSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLiSTActionPerformed

    private void btnQuanLiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLiSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLiSPActionPerformed

    private void btnCaiDatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaiDatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCaiDatActionPerformed

    private void btnQuanLiNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLiNVActionPerformed
        try {
            // TODO add your handling code here:
            this.dispose();
            ArrayList<Employee> employees = ConnectEmployee.getEmployees();
            new FormQuanLiNhanVien(employees).setVisible(true);
        } catch (IOException | ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(FormQuanLyST.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Loi he thong");
        }
    }//GEN-LAST:event_btnQuanLiNVActionPerformed

    private void btnQuanLyNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyNCCActionPerformed

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
            java.util.logging.Logger.getLogger(FormQuanLyST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQuanLyST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQuanLyST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQuanLyST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQuanLyST().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCaiDat;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnQuanLiNV;
    private javax.swing.JButton btnQuanLiSP;
    private javax.swing.JButton btnQuanLiST;
    private javax.swing.JButton btnQuanLyNCC;
    private javax.swing.JLabel imgBanHang;
    private javax.swing.JLabel imgCaiDat;
    private javax.swing.JLabel imgNCC;
    private javax.swing.JLabel imgQuanLiNhanVien;
    private javax.swing.JLabel imgQuanLySP;
    private javax.swing.JLabel imgQuanLyST;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
