package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import mdl.ImportReceipt;
import mdl.Product;
import model.Loader;
import view.ManageProductView;
import view.MyModel;

public class SearchProductController implements ActionListener {
  private ManageProductView view;
  
  public SearchProductController(ManageProductView manageProductView) {
    this.view = manageProductView;
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");
    try {
      int input = Integer.parseInt(view.getTxtInput().getText());
      int index = view.getComboBox().getSelectedIndex();
     
      if (index == 0) {
        Product product = Loader.loadProductById(input);
        System.out.println(product.getName());
        if (product.getIdNumber() == 0) {
          JOptionPane.showMessageDialog(null, b.getString("ProductId") + " " + b.getString("Error"));
          return;
        }
        ArrayList<ImportReceipt> list = Loader.loadImportReceipt();
        for (ImportReceipt receipt : list) {
          
          if (receipt.containsProductId(product)) {
            String [] columnNames = {b.getString("ProductId"), b.getString("ProductName"), b.getString("Price"), 
                b.getString("Producer"), b.getString("ProduceDate"), b.getString("ExpireDate")};
            product = Loader.loadProductById(input);
            DefaultTableModel model = new MyModel(columnNames);
            model.addRow(product.toArrayString());
            view.getPanel().setModel(model);
            view.getPanel().getTable().setModel(model);
            return;
          } 
        }
      }
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, b.getString("numberRequired"));
      return;
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, b.getString("sqlError") );
      e.printStackTrace();
      return;
    } catch (ParseException e) {
      JOptionPane.showMessageDialog(null, b.getString("parseError"));
      return;
    }
  }
  
 
}
  

