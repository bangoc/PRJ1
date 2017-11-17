package view;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MyModel extends DefaultTableModel {
  public MyModel(String [] columnNames) {
    super(columnNames, 0);
  }
  
  @Override
  public boolean isCellEditable(int row, int column) {
    return false;
  }

}
