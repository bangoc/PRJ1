package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import view.MakeNewImportReceiptView;

public class InsertItemToImportReceiptController implements ActionListener {
  private MakeNewImportReceiptView view;
  
  public InsertItemToImportReceiptController(MakeNewImportReceiptView makeNewImportReceiptView) {
    this.view = makeNewImportReceiptView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      String name = view.getTxtName().getText();
      String price = view.getTxtPrice().getText();
      Integer.parseInt(price);
      String producer = view.getTxtProducer().getText();
      DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
      String produceDate = view.getTxtProduceDate().getText();
      df.parse(produceDate);
      String expireDate = view.getTxtExpireDate().getText();
      df.parse(expireDate);
      String amount = view.getTxtAmount().getText();
      Integer.parseInt(amount);
      String importPrice = view.getTxtImportPrice().getText();
      Integer.parseInt(importPrice);
      if (name.equals("") || producer.equals("")) {
        JOptionPane.showMessageDialog(null, "You must fill all field");
        return;
      }
      String[] array = {name, price, producer, produceDate, expireDate,amount, importPrice};
      DefaultTableModel model = view.getTable().getModel();
      model.addRow(array);
      view.getTable().getTable().setModel(model);
      view.getTable().setModel(model);
//      view.getTxtName().setText(null);
//      view.getTxtPrice().setText(null);
//      view.getTxtProducer().setText(null);
//      view.getTxtProduceDate().setText(null);
//      view.getTxtExpireDate().setText(null);
//      view.getTxtAmount().setText(null);
//      view.getTxtImportPrice().setText(null);
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(null, "Input number required!");
      return;
    } catch (ParseException ex ) {
      JOptionPane.showMessageDialog(null, "Date must be in dd/MM/yyyy format");
    }
    
  }

}
