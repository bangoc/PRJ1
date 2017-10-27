package view;

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
    
    JButton btnQuanLyNhan = new JButton("Quan Ly Nhan Vien");
    btnQuanLyNhan.addActionListener(new QuanLyNhanVienController(frame));

    btnQuanLyNhan.setBounds(54, 132, 187, 25);
    frame.getContentPane().add(btnQuanLyNhan);
    frame.setVisible(true);
  }
}
