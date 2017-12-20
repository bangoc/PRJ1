/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listview;

import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import model.connectDatabase.ConnectSupplier;
import model.employee.Manager;
import model.market.Supplier;

/**
 *
 * @author PhamThiDuyen
 */
public class ManageSupplierView extends javax.swing.JFrame {
    private ArrayList<Supplier> suppliers;
    private Manager manager;
    private boolean isInsert;
    String[] columnNames;
    /**
     * Creates new form FormQuanLyNCC
     */
    public ManageSupplierView(Manager manager) {
        this.manager = manager;
        initComponents();
        settingLanguage();
        this.setLocationRelativeTo(null);
        suppliers = ConnectSupplier.getSuppliers();
        isInsert = true;
        displaySuppliers();
        txtMaNCC.setEditable(false);
        txtMaNCC.setVisible(false);
        lblId.setVisible(false);
        
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
        txtQuanLyNCC = new javax.swing.JLabel();
        imgQuanLiNcc = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtMaNCC = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtTenNCC = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtSoDT = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnThemMoi = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(204, 204, 255))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtQuanLyNCC.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtQuanLyNCC.setForeground(new java.awt.Color(0, 102, 102));
        txtQuanLyNCC.setText("Manage Supplier");
        jPanel1.add(txtQuanLyNCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 50, -1, 38));

        imgQuanLiNcc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cargo-2-icon (1).png"))); // NOI18N
        jPanel1.add(imgQuanLiNcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 2, 148, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 970, 140));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 14), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(481, 250));

        lblId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblId.setText("Supplier ID");

        lblName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblName.setText("Supplier Name");

        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAddress.setText("Address");

        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        lblPhone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPhone.setText("Phone Contact");

        txtSoDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDTActionPerformed(evt);
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(153, 0, 0));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search-icon.png"))); // NOI18N
        btnTimKiem.setText("Search");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnThemMoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThemMoi.setForeground(new java.awt.Color(153, 0, 0));
        btnThemMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Button-Add-icon.png"))); // NOI18N
        btnThemMoi.setText("Add");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(153, 0, 0));
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Button-Upload-icon.png"))); // NOI18N
        btnCapNhat.setText("Refresh");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(153, 0, 0));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Close-2-icon.png"))); // NOI18N
        btnXoa.setText("Back");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        lblEmail.setText("Email Contact");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThemMoi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCapNhat)
                        .addGap(12, 12, 12)
                        .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimKiem))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(62, 62, 62)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenNCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmail)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThemMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Supplier List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 14), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(499, 300));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 960, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDTActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ManagerView(manager).setVisible(true);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        txtMaNCC.setVisible(false);
        lblId.setVisible(false);
        suppliers = ConnectSupplier.getSuppliers();
        displaySupplierInfo(null);
        displaySuppliers();
        isInsert = true;
        txtTimKiem.setText(null);
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        txtMaNCC.setVisible(true);
        lblId.setVisible(true);
        isInsert = false;
        displaySupplierInfo(suppliers.get(jTable1.getSelectedRow()));
    
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        // TODO add your handling code here:
   
        String name = txtTenNCC.getText();
        System.out.println("ok");
        if (name.equals("")) {
            System.out.println("ok1");
            JOptionPane.showMessageDialog(null, "Nhap ten nha cung cap");
            System.out.println("listView.FormQuanLyNCC.btnThemMoiActionPerformed()");
            return;
        }
        
        String address = txtDiaChi.getText();
        if (address.equals("")) {
            JOptionPane.showMessageDialog(null, "Nhap dia chi nha cung cap");
            return;
        }
        
        String phone = txtSoDT.getText();
        if (address.equals("")) {
            JOptionPane.showMessageDialog(null, "Nhap SDT nha cung cap");
            return;
        }
        
        String email = txtEmail.getText();
        if (address.equals("")) {
            JOptionPane.showMessageDialog(null, "Nhap dia chi nha cung cap");
            return;
        }
        Supplier supplier;
        if (isInsert) {
            supplier = new Supplier(name, address, email, phone);
            ConnectSupplier.saveNewSupplier(supplier);
            JOptionPane.showMessageDialog(null, "Them thanh cong");
            suppliers = ConnectSupplier.getSuppliers();
            displaySuppliers();
        } else {
            supplier = new Supplier(Integer.parseInt(txtMaNCC.getText()), name, address, email, phone);
            ConnectSupplier.saveChangedSupplier(supplier);
            JOptionPane.showMessageDialog(null, "Cap nhat thanh cong");
            suppliers = ConnectSupplier.getSuppliers();
            displaySuppliers();
        }
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        if (txtTimKiem.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nhap Ma ncc hoac Ten ncc!");
            return;
        }
        
        try {
            int id = Integer.parseInt(txtTimKiem.getText());
            suppliers = ConnectSupplier.getSupplierById(id);
            displaySuppliers();
        } catch (NumberFormatException ex) {
            String name = txtTimKiem.getText();
            suppliers = ConnectSupplier.getSupplierByName(name);
            displaySuppliers();
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed
    
    private void displaySuppliers() {
        
        MyModel model = new MyModel(columnNames);
        
        for (Supplier s : suppliers) {
            String[] row = {"" + s.getSupplierId(), s.getName()};
            model.addRow(row);
        }
        jTable1.setModel(model);
        displaySupplierInfo(null);
    }
    
    private void displaySupplierInfo(Supplier supplier) {
        if (supplier == null) {
            txtMaNCC.setText(null);
            txtTenNCC.setText(null);
            txtDiaChi.setText(null);
            txtSoDT.setText(null);
            txtEmail.setText(null);
            btnThemMoi.setText("Thêm mới");
        } else {
            txtMaNCC.setText("" + supplier.getSupplierId());
            txtTenNCC.setText(supplier.getName());
            txtDiaChi.setText(supplier.getAddress());
            txtSoDT.setText(supplier.getPhoneNumber());
            txtEmail.setText(supplier.getEmail());
            btnThemMoi.setText("Chỉnh sửa");
        }
    }
    
    private void settingLanguage() {
        ResourceBundle rb = ResourceBundle.getBundle("resourceBundle.Label");
        btnCapNhat.setText(rb.getString("Update"));
        btnThemMoi.setText(rb.getString("Add"));
        btnTimKiem.setText(rb.getString("Search"));
        lblId.setText(rb.getString("SupplierId"));
        lblName.setText(rb.getString("SupplierName"));
        lblAddress.setText(rb.getString("Address"));
        lblPhone.setText(rb.getString("Phone"));
        lblEmail.setText(rb.getString("Email"));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(rb.getString("SupplierList")));
        columnNames = new String[] {rb.getString("SupplierId"), rb.getString("SupplierName")};
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel imgQuanLiNcc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JLabel txtQuanLyNCC;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTenNCC;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
