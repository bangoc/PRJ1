package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MakeNewExportReceiptView;

public class DeleteItemFromExportReceiptController implements ActionListener {
  private MakeNewExportReceiptView view;
  
  public DeleteItemFromExportReceiptController(MakeNewExportReceiptView makeNewExportReceiptView) {
    this.view = makeNewExportReceiptView;
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    try {
      view.getPanel().getModel().removeRow(
          view.getPanel().getTable().getSelectedRow());
      if (view.getPanel().getTable().getModel().getRowCount() == 0) {
        view.getLblTotalPrice().setText("0");
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      return;
    }
  }

}
