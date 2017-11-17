package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import mdl.ExportReceipt;
import mdl.ImportReceipt;
import mdl.Product;
import mdl.Supplier;
import model.Loader;
import view.ManageProductView;
import view.MyModel;

public class SearchProductController implements ActionListener {
  private ManageProductView view;
  ResourceBundle b = ResourceBundle.getBundle("view.Label");
  String [] columnNames = {b.getString("ProductId"), b.getString("ProductName"), b.getString("Price"), 
      b.getString("Producer"), b.getString("ProduceDate"), b.getString("ExpireDate"), b.getString("Amount"), b.getString("ImportPrice")};
  
  public SearchProductController(ManageProductView manageProductView) {
    this.view = manageProductView;
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    int input = Integer.parseInt(view.getTxtInput().getText());
    int index = view.getComboBox().getSelectedIndex();

    try {
      if (index == 0) {
        first(input);
      } else if (index == 1) {
        second(input);
      } else if (index == 2) {
        third(input);
      } else if (index == 3) {
        fourth(input);
      }
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, b.getString("numberRequired"));
      return;
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, b.getString("sqlError") );
      return;
    } catch (ParseException e) {
      JOptionPane.showMessageDialog(null, b.getString("ID") + " " + b.getString("Error"));
      return;
    }
  }
  
  private void first(int input) throws SQLException, ParseException {
    ArrayList<ImportReceipt> list = Loader.loadImportReceipt();
  
    Product product = Loader.loadProductById(input);
    if (product.getIdNumber() == 0) {
      JOptionPane.showMessageDialog(null, b.getString("ProductId") + " " + b.getString("Error"));
      return;
    }
    
    for (ImportReceipt receipt : list) {
      if (receipt.containsProductId(product)) {
        DefaultTableModel model = new MyModel(columnNames);
        String[] data = product.toArrayString();
        String[] array = new String[8];
        for (int i = 0; i < 6; i ++) {
          array[i] = data[i];
        }
        Integer[] numbers = receipt.getAmountPrice(product);
        array[6] = "" + numbers[0];
        array[7] = "" + numbers[1];
        model.addRow(array);
        view.getPanel().setModel(model);
        view.getPanel().getTable().setModel(model);
        view.getTxtInput().setText(null);
        return;
      } 
    }

      
  }
  
  
  private void second(int input) throws SQLException, ParseException {
    Supplier supplier = Loader.loadSupplierById(input);
    if (supplier.getIdNumber() == 0) {
      JOptionPane.showMessageDialog(null, b.getString("SupplierId") + " " + b.getString("Error"));
      return;
    }
    ArrayList<ImportReceipt> list = Loader.loadImportReceipt();

    DefaultTableModel model = new MyModel(columnNames);
    String[] array = new String[8];
    String[] data;
    for (ImportReceipt receipt : list) {
      if (receipt.getSupplier().getIdNumber() == supplier.getIdNumber()) {
        LinkedHashMap<Product, Integer[]> map = receipt.getListItem();
        for (Map.Entry<Product, Integer[]> pair : map.entrySet()) {
          data = pair.getKey().toArrayString();
          for (int i = 0; i < 6; i ++) {
            array[i] = data[i];
          }
          array[6] = "" + pair.getValue()[0];
          array[7] = "" + pair.getValue()[1];
          model.addRow(array);
        
    
        }
      }
    }
    view.getPanel().setModel(model);
    view.getPanel().getTable().setModel(model);
  }
  
  private void third(int input) throws SQLException, ParseException {
    ImportReceipt receipt = Loader.loadImportReceiptById(input);
    LinkedHashMap<Product, Integer[]> map = receipt.getListItem();
    DefaultTableModel model = new MyModel(columnNames);
    String[] array = new String[8];
    String[] data;
    for (Map.Entry<Product, Integer[]> pair : map.entrySet()) {
      data = pair.getKey().toArrayString();
      for (int i = 0; i < 6; i ++) {
        array[i] = data[i];
      }
      array[6] = "" + pair.getValue()[0];
      array[7] = "" + pair.getValue()[1];
      model.addRow(array);

    }
    view.getPanel().setModel(model);
    view.getPanel().getTable().setModel(model);
  }
  
  
  private void fourth(int input) throws SQLException, ParseException {
    ExportReceipt receipt = Loader.loadExportReceiptById(input);
    LinkedHashMap<Product, Integer[]> map = receipt.getListItem();
    columnNames[7] = b.getString("SellPrice");
    DefaultTableModel model = new MyModel(columnNames);
    String[] array = new String[8];
    String[] data;
    for (Map.Entry<Product, Integer[]> pair : map.entrySet()) {
      data = pair.getKey().toArrayString();
      for (int i = 0; i < 6; i ++) {
        array[i] = data[i];
      }
      array[6] = "" + pair.getValue()[0];
      array[7] = "" + pair.getValue()[1];
      model.addRow(array);

    }
    view.getPanel().setModel(model);
    view.getPanel().getTable().setModel(model);
  }
 
}
  

