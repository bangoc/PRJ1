package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mdl.ExportReceipt;
import mdl.Product;
import mdl.SalesPerson;
import model.Loader;
import model.Saver;
import view.MakeNewExportReceiptView;

public class CreateNewExportReceiptController implements ActionListener {
  private MakeNewExportReceiptView makeNewExportReceiptView;
  
  public CreateNewExportReceiptController(MakeNewExportReceiptView makeNewExportReceiptView) {
    this.makeNewExportReceiptView = makeNewExportReceiptView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    DefaultTableModel model = makeNewExportReceiptView.getPanel().getModel();
    LinkedHashMap<Product, Integer[]> itemList = new LinkedHashMap<>();
    if (model.getRowCount() == 0) {
      JOptionPane.showMessageDialog(null, "Empty receipt");
      return;
    }
    for (int i = 0; i < model.getRowCount(); i ++) {
      try {
        Product product = Loader.loadProductById(
            Integer.parseInt(
                (String) model.getValueAt(i, 0)));
        
        Integer[] array = {
            Integer.parseInt(
                (String) model.getValueAt(i, 2)),
            Integer.parseInt(
                (String) model.getValueAt(i, 3))
        };
        itemList.put(product, array);
      } catch (NumberFormatException | SQLException | ParseException e1) {
        e1.printStackTrace();
      }
    }
    try {
      SalesPerson salesman = Loader.loadSalesPersonById(2);
      ExportReceipt receipt = new ExportReceipt();
      receipt.setListItem(itemList);
      receipt.setSalesPerson(salesman);
      receipt.setTime(new Date());
      Saver.saveExportReceipt(receipt);
      JOptionPane.showMessageDialog(null, "Ok");
      makeNewExportReceiptView.getLblTotalPrice().setText("0");
    } catch (SQLException | ParseException e1) {
      JOptionPane.showMessageDialog(null, "Error!");
    }
    
    
  }

}
