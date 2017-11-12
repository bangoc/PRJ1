package view;

import controller.LoginController;
import java.awt.Font;
import java.util.ResourceBundle;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.ConnectDatabase;



public class LoginView {
  private JFrame frame;
  private JTextField txtTaiKhoan;
  private JPasswordField txtMatKhau;
  private JCheckBox checkLuuMatKhau;
  
  public LoginView() {
    initialize();
  }

  public JFrame getFrame() {
    return frame;
  }

  public void setFrame(JFrame frame) {
    this.frame = frame;
  }
  
  public JTextField getTxtTaiKhoan() {
    return txtTaiKhoan;
  }

  public void setTxtTaiKhoan(JTextField txtTaiKhoan) {
    this.txtTaiKhoan = txtTaiKhoan;
  }

  public JPasswordField getTxtMatKhau() {
    return txtMatKhau;
  }

  public void setTxtMatKhau(JPasswordField txtMatKhau) {
    this.txtMatKhau = txtMatKhau;
  }
  
  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    frame = new JFrame();
    frame.setBounds(550, 300, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setTitle(b.getString("Login"));
    frame.setVisible(true);
    
    JLabel lblTaiKhoan = new JLabel(b.getString("UserName"));
    lblTaiKhoan.setBounds(40, 80, 100, 30);
    lblTaiKhoan.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblTaiKhoan);
    
    txtTaiKhoan = new JTextField();
    txtTaiKhoan.setBounds(150, 80, 180, 30);
    txtTaiKhoan.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(txtTaiKhoan);
    
    JLabel lblMatKhau = new JLabel(b.getString("Password"));
    lblMatKhau.setBounds(40, 130, 100, 30);
    lblMatKhau.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblMatKhau);
    
    txtMatKhau = new JPasswordField();
    txtMatKhau.addActionListener(new LoginController(this));
    txtMatKhau.setBounds(150, 130, 180, 30);
    txtMatKhau.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(txtMatKhau);
  
    
    JButton btnDangNhap = new JButton(b.getString("Login"));
    btnDangNhap.setBounds(40, 200, 130, 30);
    btnDangNhap.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(btnDangNhap);
    
    checkLuuMatKhau = new JCheckBox(b.getString("SavePassword"));
    checkLuuMatKhau.setBounds(201, 204, 150, 23);
    frame.getContentPane().add(checkLuuMatKhau);
    
    
    
    ConnectDatabase con = new ConnectDatabase();
    Vector<String> vector = con.getTaiKhoanMatKhau();
    if (vector.get(0).equals("1")) {
      txtTaiKhoan.setText(vector.get(1));
      txtMatKhau.setText(vector.get(2));
      checkLuuMatKhau.setSelected(true);
      
    }
    //Tao tin hieu gui den controller
    btnDangNhap.addActionListener(new LoginController(this));
    
    
  }

  public JCheckBox getCheckLuuMatKhau() {
    return checkLuuMatKhau;
  }

  public void setCheckLuuMatKhau(JCheckBox checkLuuMatKhau) {
    this.checkLuuMatKhau = checkLuuMatKhau;
  }
}
