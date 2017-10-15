package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel extends JPanel {
  private static final long serialVersionUID = 1L;
  private ArrayList<JLabel> labelList;
  private ArrayList<JTextField> textList;
  private String[] arrayName;
  private int width;
  private int height;
  private ActionListener action;
  

  /**
   * 
   * @param arrayName list label's text.
   * @param width panel's width
   * @param height panel's height
   */
  
  public MyPanel(String[] arrayName,int xx, int yy, int width, int height) {
    this.arrayName = arrayName;
    this.width = width;
    this.height = height;
    this.setBounds(xx, yy, width, height);
    this.setBackground(new Color(255));
    this.setComponent();
  }

  public ActionListener getAction() {
    return action;
  }

  public void setAction(ActionListener action) {
    this.action = action;
  }

  public ArrayList<JLabel> getLabelList() {
    return labelList;
  }

  public void setLabelList(ArrayList<JLabel> labelList) {
    this.labelList = labelList;
  }

  public ArrayList<JTextField> getTextList() {
    return textList;
  }

  public void setTextList(ArrayList<JTextField> textList) {
    this.textList = textList;
  }

  public String[] getArrayName() {
    return arrayName;
  }

  public void setArrayName(String[] arrayName) {
    this.arrayName = arrayName;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
  
  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
  
  private void setComponent() {
    int size = this.arrayName.length;
    int xy = height / (2 * size + 4);
    int labelWidth = (this.width - 4 * xy) / 3;
    int textWidth = 2 * labelWidth;
    this.labelList = new ArrayList<>();
    this.textList = new ArrayList<>();
    for (int i = 0; i < size; i ++) {
      JLabel label = new JLabel(this.arrayName[i]);
      JTextField text = new JTextField();
      label.setBounds(xy, (1 + i) * 2 * xy, labelWidth, xy);
      label.setFont(new Font("Dialog", Font.BOLD, (xy * 4) / 5));
      text.setBounds(2 * xy + labelWidth, (1 + i) * 2 * xy, textWidth, xy);
      text.setFont(new Font("Dialog", Font.BOLD, (xy * 4) / 5));
      this.add(label);
      this.add(text);
      this.labelList.add(label);
      this.textList.add(text);
    }
    
    JButton btnLogin = new JButton();
    btnLogin.setBounds(xy, (size + 1) * 2 * xy, 2 * labelWidth, xy);
    btnLogin.setText("Dang Nhap");
    btnLogin.setFont(new Font("Dialog", Font.BOLD, (xy * 4) / 5));
    this.add(btnLogin);
    
  }
}
