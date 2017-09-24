package view;

import controller.RegisterAccountController;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterView {
  private JFrame frame;
  private JTextField tetId;
  private JTextField txtAccountName;
  private JPasswordField txtPassword;
  
  public RegisterView() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
    JLabel lblTaiKhoan = new JLabel("Tai Khoan");
    lblTaiKhoan.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblTaiKhoan.setBounds(33, 98, 89, 17);
    frame.getContentPane().add(lblTaiKhoan);
    
    JLabel lblMatKhau = new JLabel("Mat Khau");
    lblMatKhau.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblMatKhau.setBounds(33, 141, 86, 17);
    frame.getContentPane().add(lblMatKhau);
    
    JLabel lblId = new JLabel("ID");
    lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblId.setBounds(33, 46, 86, 17);
    frame.getContentPane().add(lblId);
    
    tetId = new JTextField();
    tetId.setBounds(161, 46, 175, 20);
    frame.getContentPane().add(tetId);
    tetId.setColumns(10);
    
    txtAccountName = new JTextField();
    txtAccountName.setBounds(161, 98, 175, 20);
    frame.getContentPane().add(txtAccountName);
    txtAccountName.setColumns(10);
    
    JButton btnRegister = new JButton("Dang Ky");
    btnRegister.setFont(new Font("Tahoma", Font.BOLD, 14));
    btnRegister.setBounds(37, 195, 107, 23);
    frame.getContentPane().add(btnRegister);
    
    txtPassword = new JPasswordField();
    txtPassword.setBounds(161, 141, 175, 17);
    frame.getContentPane().add(txtPassword);
    
    btnRegister.addActionListener(new RegisterAccountController(
        frame, tetId, txtAccountName, txtPassword));
  }
}
