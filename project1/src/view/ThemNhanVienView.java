
package view;

import controller.ThemNhanVienController;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ThemNhanVienView {

  private JFrame frame;
  private JTextField txtTenNhanVien;
  private JTextField txtTuoi;
  private JTextField txtGioiTinh;
  private JTextField txtNgaySinh;
  private JTextField txtNgayVaoLam;
  private JTextField txtLuongCoBan;
  
  public ThemNhanVienView() {
    initialize();
  }
  
  public JFrame getFrame() {
    return frame;
  }

  public JTextField getTxtTenNhanVien() {
    return txtTenNhanVien;
  }

  public JTextField getTxtTuoi() {
    return txtTuoi;
  }

  public JTextField getTxtGioiTinh() {
    return txtGioiTinh;
  }

  public JTextField getTxtNgaySinh() {
    return txtNgaySinh;
  }

  public JTextField getTxtNgayVaoLam() {
    return txtNgayVaoLam;
  }

  public JTextField getTxtLuongCoBan() {
    return txtLuongCoBan;
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(450, 200, 700, 500);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
    Container container = frame.getContentPane();
    Font font = new Font("Dialog", Font.BOLD, 15);
    
    JLabel lblTenNhanVien = new JLabel("Ho va Ten");
    lblTenNhanVien.setBounds(50, 60, 120, 25);
    lblTenNhanVien.setFont(font);
    container.add(lblTenNhanVien);
    
    txtTenNhanVien = new JTextField();
    txtTenNhanVien.setBounds(210, 60, 350, 25);
    txtTenNhanVien.setFont(font);
    container.add(txtTenNhanVien);
    
    JLabel lblTuoi = new JLabel("Tuoi");
    lblTuoi.setBounds(50, 100, 120, 25);
    lblTuoi.setFont(font);
    container.add(lblTuoi);
    
    txtTuoi = new JTextField();
    txtTuoi.setBounds(210, 100, 350, 25);
    txtTuoi.setFont(font);
    container.add(txtTuoi);
    
    JLabel lblGioiTinh = new JLabel("Gioi Tinh");
    lblGioiTinh.setBounds(50, 140, 120, 25);
    lblGioiTinh.setFont(font);
    container.add(lblGioiTinh);
    
    txtGioiTinh = new JTextField();
    txtGioiTinh.setBounds(210, 140, 350, 25);
    txtGioiTinh.setFont(font);
    container.add(txtGioiTinh);
    
    JLabel lblNgaySinh = new JLabel("Ngay sinh");
    lblNgaySinh.setBounds(50, 180, 120, 25);
    lblNgaySinh.setFont(font);
    container.add(lblNgaySinh);
    
    txtNgaySinh = new JTextField();
    txtNgaySinh.setBounds(210, 180, 350, 25);
    txtNgaySinh.setFont(font);
    container.add(txtNgaySinh);
    
    JLabel lblNgayVaoLam = new JLabel("Ngay vao lam");
    lblNgayVaoLam.setBounds(50, 220, 120, 25);
    lblNgayVaoLam.setFont(font);
    container.add(lblNgayVaoLam);
    
    txtNgayVaoLam = new JTextField();
    txtNgayVaoLam.setBounds(210, 220, 350, 25);
    txtNgayVaoLam.setFont(font);
    container.add(txtNgayVaoLam);
    
    JLabel lblLuongCoBan = new JLabel("Luong co ban");
    lblLuongCoBan.setBounds(50, 260, 120, 25);
    lblLuongCoBan.setFont(font);
    container.add(lblLuongCoBan);
    
    txtLuongCoBan = new JTextField();
    txtLuongCoBan.setBounds(210, 260, 350, 25);
    txtLuongCoBan.setFont(font);
    container.add(txtLuongCoBan);
    
    JButton btnAdd = new JButton("Them nhan vien");
    btnAdd.setBounds(380, 300, 180, 30);
    btnAdd.setFont(font);
    container.add(btnAdd);
    
    btnAdd.addActionListener(new ThemNhanVienController(this));
  }

}
