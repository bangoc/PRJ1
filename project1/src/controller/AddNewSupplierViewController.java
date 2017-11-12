package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
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
    AddNewSupplierView view = new AddNewSupplierView(comboBox);
    String[] columnNames = {"ID", "Name", "Address", "Email", "Phone Contact"};
    DefaultTableModel model = new MyModel(columnNames);
    try {
      ArrayList<Supplier> supplierList = Loader.loadSupplier();
      for (Supplier supplier : supplierList) {
        model.addRow(supplier.toArrayString());
      }
      view.getBangNhaCungCap().setModel(model);
      view.getBangNhaCungCap().getTable().setModel(model);
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
  }

}
