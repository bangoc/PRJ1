package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import mdl.Product;
import model.Loader;
import view.ManageProductView;
import view.MyModel;

public class NavigateToManageProductViewController implements ActionListener {
  private JFrame frame;
  
  public NavigateToManageProductViewController(JFrame frame) {
    this.frame = frame;
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");
  
    String [] columnNames = {b.getString("ProductId"), b.getString("ProductName"), b.getString("Price"), 
        b.getString("Producer"), b.getString("ProduceDate"), b.getString("ExpireDate")};
    DefaultTableModel  model = new MyModel(columnNames);
    ManageProductView view = new ManageProductView();
    try {
      ArrayList<Product> productList = Loader.loadProduct();
      for (Product product : productList) {
        model.addRow(product.toArrayString());
      }
      view.getPanel().getTable().setModel(model);
      view.getPanel().setModel(model);
      frame.dispose();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "sqlError");
    } catch (ParseException ex) {
      JOptionPane.showMessageDialog(null, b.getString("parseError"));
    }
    
    
  }

}
