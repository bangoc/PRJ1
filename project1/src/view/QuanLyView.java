package view;

import controller.QuanLyHangHoaCotroller;
import controller.QuanLyNhanVienController;

import javax.swing.JButton;
import javax.swing.JFrame;


public class QuanLyView {
  private JFrame frame;

  public QuanLyView() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(400, 300, 631, 359);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    JButton btnQuanLyNhanVien = new JButton("Quan Ly Nhan Vien");
    btnQuanLyNhanVien.addActionListener(new QuanLyNhanVienController(frame));
    btnQuanLyNhanVien.setBounds(54, 132, 187, 25);
    frame.getContentPane().add(btnQuanLyNhanVien);
    frame.setVisible(true);
    
    JButton btnQuanLyHangHoa = new JButton("Quan Ly Hang Hoa");
    btnQuanLyHangHoa.addActionListener(new QuanLyHangHoaCotroller(frame));
    btnQuanLyHangHoa.setBounds(250, 132, 187, 25);
    frame.getContentPane().add(btnQuanLyHangHoa);
  }
}
