package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import view.TaskManagerView;

public class CancelMakingNewImportReceiptController implements ActionListener {
  private JFrame frame;
  
  public CancelMakingNewImportReceiptController(JFrame frame) {
    this.frame = frame;
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    frame.dispose();
    new TaskManagerView();
    
    
  }

}
