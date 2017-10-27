package view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThongTinNhanVienView {

  private JFrame frame;
  private ArrayList<JLabel> listLabel;
  private ArrayList<JLabel> listText;
  

  public ThongTinNhanVienView() {
    initialize();
  }
  
  /**
   * Initialize the contents of the frame.
   * 
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(350, 50, 900, 800);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
    
    listLabel = new ArrayList<>();
    listText = new ArrayList<>();
    int i;
    Container con = frame.getContentPane();
    for (i = 0; i < 7; i ++) {
      JLabel lbl = new JLabel();
      lbl.setBounds(40, 20 + 50 * i, 150 , 25);
      lbl.setFont(new Font("Dialog", Font.BOLD, 15));
      listLabel.add(lbl);
      con.add(lbl);
      
      JLabel txt = new JLabel();
      txt.setBounds(200, 20 + 50 * i, 400, 25);
      txt.setFont(new Font("Dialog", Font.BOLD, 15));
      listText.add(txt);
      con.add(txt);
      
    }
   
    JButton btnBack = new JButton("Back");
    btnBack.setBounds(733, 720, 130, 30);
    btnBack.setFont(new Font("Dialog", Font.BOLD, 20));
    con.add(btnBack);
    btnBack.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();        
      }
    });
    
    JLabel lblLsLamViec = new JLabel("Lich su lam viec");
    lblLsLamViec.setBounds(40, 370, 200, 25);
    lblLsLamViec.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblLsLamViec);
    
  }

  public JFrame getFrame() {
    return frame;
  }

  public void setFrame(JFrame frame) {
    this.frame = frame;
  }

  public ArrayList<JLabel> getListLabel() {
    return listLabel;
  }

  public void setListLabel(ArrayList<JLabel> listLabel) {
    this.listLabel = listLabel;
  }

  public ArrayList<JLabel> getListText() {
    return listText;
  }

  public void setListText(ArrayList<JLabel> listText) {
    this.listText = listText;
  }

}
