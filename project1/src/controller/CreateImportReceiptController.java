package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import mdl.ImportReceipt;
import mdl.Manager;
import mdl.Product;
import mdl.Supplier;
import model.Loader;
import model.Saver;
import view.MakeNewImportReceiptView;

public class CreateImportReceiptController implements ActionListener{
  private MakeNewImportReceiptView view;
  
  public CreateImportReceiptController(MakeNewImportReceiptView makeNewImportReceiptView) {
    this.view = makeNewImportReceiptView;
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    int index = view.getComboBox().getSelectedIndex();
    if (index == 0) {
      JOptionPane.showMessageDialog(null, "You must select supplier's id");
      return;
    }
    DefaultTableModel model = view.getTable().getModel();
    LinkedHashMap<Product, Integer[]> itemList = new LinkedHashMap<>();
    if (model.getRowCount() == 0) {
      JOptionPane.showMessageDialog(null, "Empty receipt");
      return;
    }
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    try {
      for (int i = 0; i < model.getRowCount(); i ++) {
  
        Product product = new Product();
        
        product.setName(
            (String) model.getValueAt(i, 0));
        
        product.setPrice(
            Integer.parseInt((String) model.getValueAt(i, 1)));
        
        product.setProducer( 
            (String) model.getValueAt(i, 2));
        
        product.setProduceTime(df.parse(
            (String) model.getValueAt(i, 3)));
        
        product.setExpireTime(df.parse(
            (String) model.getValueAt(i, 4)));
        
        Integer[] array = {
            Integer.parseInt(
                (String) model.getValueAt(i, 5)),
            Integer.parseInt(
                (String) model.getValueAt(i, 6))
        };
        itemList.put(product, array);
        
      }
      Manager manager = Loader.loadManagerById(8);
      Supplier supplier = Loader.loadSupplierById(index);
      
      ImportReceipt receipt = manager.makeImportReceipt(supplier, itemList);
      Saver.saveImportReceipt(receipt);
      JOptionPane.showMessageDialog(null, "Receipt created successfull");
    } catch (ParseException ex) {
      JOptionPane.showMessageDialog(null, "Error");
      return;
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Database access error");
    }
    
  }
  
}
