package view;

import javax.swing.JFrame;

public class QuanLySieuThiView {

  private JFrame frame;
  
  public QuanLySieuThiView() {
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
  }

}
