package view;

import javax.swing.JFrame;

public class View {
  private JFrame frame;

  public View() {
    initialize();
  }
  
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 1000, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    String[] array = {"Name", "Tuoi", "Gioi tinh", "Ngay sinh"};
    MyPanel myPanel = new MyPanel(array, 20, 20, 600, 300);
    frame.getContentPane().add(myPanel);
    myPanel.setLayout(null);
    
   
    frame.setVisible(true);
  }
}
