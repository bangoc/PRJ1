package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.Saver;
import view.MakeNewExportReceiptView;

public class ChooseFileSaveDestinationController implements ActionListener {
  private MakeNewExportReceiptView view;
  
  public ChooseFileSaveDestinationController(MakeNewExportReceiptView makeNewExportReceiptView) {
    this.view = makeNewExportReceiptView;
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      String link = chooser.getSelectedFile().getAbsolutePath();
      view.getTxtLocation().setText(link);
      try {
        Saver.saveLinkPathForExportReceipt(link);
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Sava path error!");
      }
    } else {
      return;
    }
  }

}
