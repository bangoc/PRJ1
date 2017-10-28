package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.NhaCungCap;

public class KiemTraNhaCungCapController implements ActionListener {
  private JTextField txtProviderId;
  private JButton btnCheck;
  
  public KiemTraNhaCungCapController(JTextField txtProviderId, JButton btnCheck) {
    this.txtProviderId = txtProviderId;
    this.btnCheck = btnCheck;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (txtProviderId.getText().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao Ma nha cung cap");
      return;
    }
    NhaCungCap nhaCungCap = new NhaCungCap();
    try {
      nhaCungCap.setMaNhaCungCap(Integer.parseInt(txtProviderId.getText()));
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null, "Ban phai nhap vao so");
    }
    nhaCungCap.loadNhaCungCap();
    
    try {
      if (nhaCungCap.isValid()) {
        btnCheck.setText("Ok");
      }
   
    } catch (NullPointerException ex) {
      JOptionPane.showMessageDialog(null, "Ma nha cung cap khong ton tai");
    }
  }

}
