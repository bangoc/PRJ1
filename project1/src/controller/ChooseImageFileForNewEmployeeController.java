package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import view.AddNewEmployee;

public class ChooseImageFileForNewEmployeeController implements ActionListener {
  private AddNewEmployee view;
  
  public ChooseImageFileForNewEmployeeController(AddNewEmployee addNewEmployee) {
    this.view = addNewEmployee;
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    JFileChooser chooser = new JFileChooser();
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      String link = chooser.getSelectedFile().getAbsolutePath();
      view.getTxtLink().setText(link);
      JLabel lblImage = view.getLblImage();
      lblImage.setText(link);
    } else {
      return;
    }
  }

}
