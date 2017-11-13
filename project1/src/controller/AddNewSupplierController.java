package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import mdl.Supplier;
import model.Loader;
import model.Saver;
import view.AddNewSupplierView;

public class AddNewSupplierController implements ActionListener {
  private AddNewSupplierView view;
  
  public AddNewSupplierController(AddNewSupplierView addNewSupplierView) {
    this.view = addNewSupplierView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");
    String name = view.getTxtName().getText();
    if (name.equals("")) {
      JOptionPane.showMessageDialog(null, b.getString("nameRequired"));
      return;
    }
    String address = view.getTxtAddress().getText();
    if (address.equals("")) {
      JOptionPane.showMessageDialog(null, b.getString("addressRequired"));
      return;
    }
    String email = view.getTxtEmail().getText();
    if (email.equals("")) {
      JOptionPane.showMessageDialog(null, b.getString("addressRequired") + " email");
      return;
    }
    String phoneNo = view.getTxtPhoneNo().getText();
    if (phoneNo.equals("")) {
      JOptionPane.showMessageDialog(null, b.getString("phoneRequired"));
      return;
    }
    
    Supplier supplier = new Supplier();
    supplier.setName(name);
    supplier.setAddress(address);
    supplier.setEmail(email);
    supplier.setPhoneNumber(phoneNo);
    try {
      Saver.saveSupplier(supplier);
      JOptionPane.showMessageDialog(null, b.getString("successfull"));
    } catch (SQLException e1) {
      JOptionPane.showMessageDialog(null, b.getString("sqlError") 
          + ". " + b.getString("fail"));
      return;
    }
    JComboBox<String> comboBox = view.getComboBox();
    try {
      ArrayList<Supplier> supplierList = Loader.loadSupplier();
      int size = supplierList.size();
      String[] data = new String[size + 1];
      data[0] = b.getString("SelectSupplier");
      for (int i = 1; i < size + 1; i ++) {
        data[i] = "" + supplierList.get(i - 1).getIdNumber();
      }
      comboBox.setModel(new DefaultComboBoxModel<String>(data));
      view.getFrame().dispose();
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, b.getString("sqlError" 
          + ". " + b.getString("fail")));
    }
    view.getFrame().dispose();
   
  }

}
