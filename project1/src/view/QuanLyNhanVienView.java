package view;

import controller.CapNhapDsNhanVienController;
import controller.XemThongTinNhanVienController;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class QuanLyNhanVienView {

  private JFrame frame;
  private MyPanel bangNhanVienView;
 
  public MyPanel getBangNhanVienView() {
    return bangNhanVienView;
  }

  public void setBangNhanVienView(MyPanel bangNhanVienView) {
    this.bangNhanVienView = bangNhanVienView;
  }

  public QuanLyNhanVienView() {
    initialize();
  }
  
  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(350, 50, 900, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
    bangNhanVienView = new MyPanel();
    bangNhanVienView.setBounds(20, 20, 860, 365);
    frame.getContentPane().add(bangNhanVienView);
    
    Container contentPane = frame.getContentPane();
    JButton btnUpdate = new JButton("Update");
    btnUpdate.setBounds(20, 426, 117, 25);
    contentPane.add(btnUpdate);
    
    btnUpdate.addActionListener(new CapNhapDsNhanVienController(bangNhanVienView));
    
    JButton btnAdd = new JButton("Add");
    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        new ThemNhanVienView();
      }
    });
    btnAdd.setBounds(150, 426, 117, 25);
    contentPane.add(btnAdd);
    
    JButton btnInfo = new JButton("Info");
    btnInfo.setBounds(280, 426, 117, 25);
    contentPane.add(btnInfo);
    btnInfo.addActionListener(new XemThongTinNhanVienController(bangNhanVienView));
    
    JButton btnBack = new JButton("Back");
    btnBack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
        new QuanLyView();
      }
    });
    btnBack.setBounds(20, 492, 117, 25);
    frame.getContentPane().add(btnBack);
    
    
    
  }

  public JFrame getFrame() {
    return frame;
  }

  public void setFrame(JFrame frame) {
    this.frame = frame;
  }
}
