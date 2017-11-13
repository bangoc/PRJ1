package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

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
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    DefaultTableModel model = makeNewExportReceiptView.getPanel().getModel();
    LinkedHashMap<Product, Integer[]> itemList = new LinkedHashMap<>();
    if (model.getRowCount() == 0) {
      JOptionPane.showMessageDialog(null, b.getString("emptyReceipt"));
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
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null, "Error");
        return;
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "sqlError");
        return;
      } catch (ParseException ex) {
        JOptionPane.showMessageDialog(null, "parseError");
        return;
      }
    }
    try {
      SalesPerson salesman = Loader.loadSalesPersonById(9);
      ExportReceipt receipt = salesman.makeExportReceipt(itemList);
      Saver.saveExportReceipt(receipt);
      JOptionPane.showMessageDialog(null, b.getString("successfull"));
      model.setRowCount(0);
      makeNewExportReceiptView.getLblTotalPrice().setText("0");
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, b.getString("sqlError"));
      return;
    } catch (ParseException ex) {
      JOptionPane.showMessageDialog(null, b.getString("parseError"));
      return;
    }
    
    
  }

}
