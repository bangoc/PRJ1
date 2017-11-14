package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import view.ManageProductView;


public class NavigateToManageProductViewController implements ActionListener {
  private JFrame frame;
  
  public NavigateToManageProductViewController(JFrame frame) {
    this.frame = frame;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    frame.dispose();
    new ManageProductView();
  }

}
