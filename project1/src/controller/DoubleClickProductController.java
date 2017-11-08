package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mdl.Product;
import model.Loader;
import view.ManageProductView;

public class DoubleClickProductController implements MouseListener {
  private ManageProductView manageProductView;
  
  public DoubleClickProductController(ManageProductView manageProductView) {
    this.manageProductView = manageProductView;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getClickCount() != 2) {
      return;
    } else {
      DefaultTableModel model = manageProductView.getPanel().getModel();
      JTable table = manageProductView.getPanel().getTable();
      int row = table.getSelectedRow();
      String s = (String) model.getValueAt(row, 0);
      int id = Integer.parseInt(s);
      JLabel[] listValueLabel = manageProductView.getListValueLabel();
      try {
        Product product = Loader.loadProductById(id);
        String[] data = product.toArrayString();
   
        for (int i = 0; i < data.length; i ++) {
          listValueLabel[i].setText(data[i]);
        }
      } catch (SQLException | ParseException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
  }

}
