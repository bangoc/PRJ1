package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyPanel extends JPanel {

  /**
   * .
   */
  private static final long serialVersionUID = 1L;
  private JTable table;
  private DefaultTableModel model;
  
  public JTable getTable() {
    return table;
  }
  
  public void setTable(JTable table) {
    this.table = table;
  }
  
  public DefaultTableModel getModel() {
    return model;
  }
  
  public void setModel(DefaultTableModel model) {
    this.model = model;
  }
  
  public static long getSerialversionuid() {
    return serialVersionUID;
  }
  
  public MyPanel() {
    this.initalize();
  }
  
  /**
   * Khoi tao bang nhan vien.
   */
  
  public void initalize() {
  
    
    this.setLayout(null);
    
    JScrollPane scrollPane = new JScrollPane();
    this.setBounds(20, 400, 860, 365);
    scrollPane.setBounds(10, 10, 840, 300);
    this.add(scrollPane);
    
    table = new JTable();
    String [] columnNames = {"MSNV", "Ho va Ten", "Luong / ca", "So ca lam viec"};
    model = new MyModel(columnNames);
    table.setModel(model);
    scrollPane.setViewportView(table);
    
  }

}
