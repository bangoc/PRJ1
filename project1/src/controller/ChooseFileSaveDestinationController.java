package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import view.MakeNewExportReceiptView;

public class ChooseFileSaveDestinationController implements ActionListener {
  private MakeNewExportReceiptView view;
  
  public ChooseFileSaveDestinationController(MakeNewExportReceiptView makeNewExportReceiptView) {
    this.view = makeNewExportReceiptView;
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    JFileChooser chooser = new JFileChooser();
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
      view.getTxtLocation().setText(chooser.getSelectedFile().getParent());
    } else {
      return;
    }
  }

}
