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
import view.MakeNewImportReceiptView;
import view.ManageProductView;
import view.TaskManagerView;

public class MakeNewImportReceiptViewController implements ActionListener {
  private TaskManagerView view;
  
  public MakeNewImportReceiptViewController(TaskManagerView taskManagerView) {
    this.view = taskManagerView;
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    MakeNewImportReceiptView makeNewImportReceiptView = new MakeNewImportReceiptView();
    JComboBox<String> comboBox = makeNewImportReceiptView.getComboBox();
    
    try {
      ArrayList<Supplier> supplierList = Loader.loadSupplier();
      int size = supplierList.size();
      String[] data = new String[size + 1];
      data[0] = b.getString("SelectSupplier");
      for (int i = 1; i < size + 1; i ++) {
        data[i] = "" + supplierList.get(i - 1).getIdNumber();
      }
      comboBox.setModel(new DefaultComboBoxModel<String>(data));
      
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, b.getString("sqlError"));
      makeNewImportReceiptView.getFrame().dispose();
     
    }
   
    
  }

}
