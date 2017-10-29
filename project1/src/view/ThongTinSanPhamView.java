package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThongTinSanPhamView {

  private JFrame frame;
  private ArrayList<JLabel> listInfo;
  private ArrayList<JLabel> listNcc;
  
  public JFrame getFrame() {
    return frame;
  }

  public void setFrame(JFrame frame) {
    this.frame = frame;
  }

  public ArrayList<JLabel> getListInfo() {
    return listInfo;
  }

  public void setListInfo(ArrayList<JLabel> listInfo) {
    this.listInfo = listInfo;
  }

  public ArrayList<JLabel> getListNcc() {
    return listNcc;
  }

  public void setListNcc(ArrayList<JLabel> listNcc) {
    this.listNcc = listNcc;
  }

  
  public ThongTinSanPhamView() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(350, 50, 900, 800);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
    JLabel lblInfo = new JLabel("Thong tin san pham");
    lblInfo.setBounds(20, 20, 400, 30);
    lblInfo.setFont(new Font("Dialog", Font.BOLD, 25));
    frame.getContentPane().add(lblInfo);
    
    listInfo = new ArrayList<>();
    for (int i = 0; i < 9; i ++) {
      JLabel lbl = new JLabel("ok");
      lbl.setBounds(40, 80 + 40 * i, 700, 25);
      lbl.setFont(new Font("Dialog", Font.BOLD, 15));
      frame.getContentPane().add(lbl);
      listInfo.add(lbl);
    }
    
    JLabel lblNccInfo = new JLabel("Thong tin nha cung cap");
    lblNccInfo.setBounds(20, 480, 400, 30);
    lblNccInfo.setFont(new Font("Dialog", Font.BOLD, 25));
    frame.getContentPane().add(lblNccInfo);
    
    listNcc = new ArrayList<>();
    for (int i = 0; i < 4; i ++) {
      JLabel lbl = new JLabel("ok");
      lbl.setBounds(40, 550 + 40 * i, 700, 15);
      lbl.setFont(new Font("Dialog", Font.BOLD, 15));
      frame.getContentPane().add(lbl);
      listNcc.add(lbl);
    }
    
    JButton btnBack = new JButton("Back");
    btnBack.setBounds(750, 730 , 100 , 25);
    btnBack.setFont(new Font("Dialog", Font.BOLD, 15));
    btnBack.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
      }
    });
    frame.getContentPane().add(btnBack);
  }

}
