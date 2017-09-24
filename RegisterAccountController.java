package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Account;
import model.ConnDb;

public class RegisterAccountController implements ActionListener {
  private JTextField txtId;
  private JTextField txtAccountName;
  private JPasswordField txtPassword;
  private JFrame frame;
  /**
   * Constructor.
   * @param frame = frame
   * @param txtId = txtId
   * @param txtAccountName = txtAccountName
   * @param txtPassword = txtPassword
   */
  
  public RegisterAccountController(JFrame frame, JTextField txtId, JTextField txtAccountName, 
      JPasswordField txtPassword) {
    // TODO Auto-generated constructor stub
    this.txtId = txtId;
    this.txtAccountName = txtAccountName;
    this.txtPassword = txtPassword;
    this.frame = frame;
  }

  @SuppressWarnings("deprecation")
  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    Account account = new Account();
    account.setAccountName(txtAccountName.getText());
    account.setEmployeeId(txtId.getText());
    account.setPassword(txtPassword.getText());
    if (ConnDb.isLegalIdToRegister(account)) {
      if (ConnDb.isLegalAccountName(account)) {
        ConnDb.savaAccountInfo(account);;
        JOptionPane.showMessageDialog(null, "Dang ky thanh cong");
        frame.dispose();
      } else {
        JOptionPane.showMessageDialog(null, "Ten tai khoan khong hop le!");
      }
    } else {
      JOptionPane.showMessageDialog(null, "ID khong hop le!");
    }
  }
}
