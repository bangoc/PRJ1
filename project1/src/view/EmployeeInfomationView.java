package view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EmployeeInfomationView {

  private JFrame frame;
  private ArrayList<JLabel> listLabel;
  private ArrayList<JLabel> listText;
  private MyTable myTable;
  private JLabel lblImage;
  

  public EmployeeInfomationView() {
    initialize();
  }
  
  /**
   * Initialize the contents of the frame.
   * 
   */
  private void initialize() {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    frame = new JFrame();
    frame.setBounds(80, 40, 1500, 800);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
    lblImage = new JLabel();
    lblImage.setBounds(1000, 10, 280, 370);
    frame.getContentPane().add(lblImage);
    
    listLabel = new ArrayList<>();
    listText = new ArrayList<>();
    int i;
    Container con = frame.getContentPane();
    String[] columnNames = {b.getString("ID"), b.getString("Name"), b.getString("Sex"), b.getString("BirthDate"), b.getString("Address"), 
        b.getString("PhoneNo"), b.getString("Coefficient")};
    for (i = 0; i < 7; i ++) {
      JLabel lbl = new JLabel();
      lbl.setBounds(40, 20 + 50 * i, 150 , 25);
      lbl.setFont(new Font("Dialog", Font.BOLD, 15));
      lbl.setText(columnNames[i]);
      listLabel.add(lbl);
      con.add(lbl);
      
      JLabel txt = new JLabel();
      txt.setBounds(200, 20 + 50 * i, 400, 25);
      txt.setFont(new Font("Dialog", Font.BOLD, 15));
      listText.add(txt);
      con.add(txt);
      
    }
    JButton btnBack = new JButton(b.getString("Back"));
    btnBack.setBounds(40, 720, 130, 30);
    btnBack.setFont(new Font("Dialog", Font.BOLD, 20));
    con.add(btnBack);
    btnBack.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();        
      }
    });
    
    JLabel lblLsLamViec = new JLabel(b.getString("WorkHistory"));
    lblLsLamViec.setBounds(40, 370, 200, 25);
    lblLsLamViec.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblLsLamViec);
    String[] columnNames1 = {b.getString("PaidTime"), b.getString("Total")};
    myTable = new MyTable(columnNames1, 20, 400, 1450, 300);
    con.add(myTable);
    
  }

  public JLabel getLblImage() {
    return lblImage;
  }

  public void setLblImage(JLabel lblImage) {
    this.lblImage = lblImage;
  }

  public MyTable getMyTable() {
    return myTable;
  }

  public void setMyTable(MyTable myTable) {
    this.myTable = myTable;
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
