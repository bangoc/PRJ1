package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import mdl.Supplier;
import model.Loader;
import view.AddNewSupplierView;
import view.MyModel;

public class AddNewSupplierViewController implements ActionListener {
  private JComboBox<String> comboBox;
  
  public AddNewSupplierViewController(JComboBox<String> comboBox) {
    this.comboBox = comboBox;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");
    AddNewSupplierView view = new AddNewSupplierView(comboBox);
    String[] columnNames = {b.getString("SupplierId"), b.getString("SupplierName"), b.getString("Address"), b.getString("Email"), b.getString("PhoneNo")};
    DefaultTableModel model = new MyModel(columnNames);
    try {
      ArrayList<Supplier> supplierList = Loader.loadSupplier();
      for (Supplier supplier : supplierList) {
        model.addRow(supplier.toArrayString());
      }
      view.getBangNhaCungCap().setModel(model);
      view.getBangNhaCungCap().getTable().setModel(model);
    } catch (SQLException e1) {
      JOptionPane.showMessageDialog(null, b.getString("sqlError"));
    }
  }

}
