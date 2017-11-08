package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import mdl.Supplier;
import model.Loader;
import view.MakeNewImportReceiptView;
import view.ManageProductView;

public class MakeNewImportReceiptViewController implements ActionListener {
  private ManageProductView view;
  
  public MakeNewImportReceiptViewController(ManageProductView manageProductView) {
    this.view = manageProductView;
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    MakeNewImportReceiptView makeNewImportReceiptView = new MakeNewImportReceiptView();
    JComboBox<String> comboBox = makeNewImportReceiptView.getComboBox();
    try {
      ArrayList<Supplier> supplierList = Loader.loadSupplier();
      int size = supplierList.size();
      String[] data = new String[size];
      for (int i = 0; i < size; i ++) {
        data[i] = "" + supplierList.get(i).getIdNumber();
      }
      comboBox.setModel(new DefaultComboBoxModel<String>(data));
      view.getFrame().dispose();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "Something wrong!");
      makeNewImportReceiptView.getFrame().dispose();
      e.printStackTrace();
    }
   
    
  }

}
