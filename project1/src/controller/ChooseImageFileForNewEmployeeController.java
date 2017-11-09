package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import view.AddNewEmpployeeView;

public class ChooseImageFileForNewEmployeeController implements ActionListener {
  private AddNewEmpployeeView view;
  
  public ChooseImageFileForNewEmployeeController(AddNewEmpployeeView addNewEmployee) {
    this.view = addNewEmployee;
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    JFileChooser chooser = new JFileChooser();
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      String link = chooser.getSelectedFile().getAbsolutePath();
      view.getTxtLink().setText(link);
      JLabel lblImage = view.getLblImage();
      BufferedImage img;
      try {
        img = ImageIO.read(chooser.getSelectedFile());
        lblImage.setIcon(new ImageIcon(img));

      } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Access file error!");
        e.printStackTrace();
      }
     
      
    } else {
      return;
    }
  }

}
