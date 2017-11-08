package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import mdl.Product;
import model.Loader;
import view.MakeNewExportReceiptView;

public class InsertItemToExportReceiptController implements ActionListener {
  private MakeNewExportReceiptView makeNewExportReceiptView;
  
  public InsertItemToExportReceiptController(MakeNewExportReceiptView makeNewExportReceiptView) {
    this.makeNewExportReceiptView = makeNewExportReceiptView;
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    JTextField txtId = makeNewExportReceiptView.getTxtId();
    JTextField txtAmount = makeNewExportReceiptView.getTxtAmount();
    JTextField txtPrice = makeNewExportReceiptView.getTxtPrice();
    JLabel lblTotal = makeNewExportReceiptView.getLblTotalPrice();
    try {
      int idProduct = Integer.parseInt(txtId.getText());
      int amount = Integer.parseInt(txtAmount.getText());
      int price = Integer.parseInt(txtPrice.getText());
      Product product = Loader.loadProductById(idProduct);
      if (product.getIdNumber() == 0) {
        JOptionPane.showMessageDialog(null, "Invalid id");
        txtId.setText(null);
        txtAmount.setText(null);
        txtPrice.setText(null);
        return;
      }
      String[] array = {"" + product.getIdNumber(), product.getName(), "" + amount, ""
          + price};
      DefaultTableModel model = makeNewExportReceiptView.getPanel().getModel();
      model.addRow(array);
      makeNewExportReceiptView.getPanel().setModel(model);
      makeNewExportReceiptView.getPanel().getTable().setModel(model);
      int currentTotal = Integer.parseInt(lblTotal.getText());
      currentTotal += amount * price;
      lblTotal.setText("" + currentTotal);
      txtId.setText(null);
      txtAmount.setText(null);
      txtPrice.setText(null);
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(null, "Input number");
      return;
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, "Database error!");
      return;
    } catch (ParseException e) {
      JOptionPane.showMessageDialog(null, "Error!");
      return;
    }
  }

}
