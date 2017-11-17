package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class MyTable extends JPanel {

  /**
   * .
   */
  private JTable table;
  private DefaultTableModel model;
  private String[] columnNames;
  private int coordinateX;
  private int coordinateY;
  private int width;
  private int height;

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
 
  
  /**
   * Create new table's contained in a JPanel.
   * @param columnNames String[] contains names of column
   * @param coordinateX coordinate x
   * @param coordinateY coordinate y
   * @param width width
   * @param height height
   */
  
  public MyTable(String[] columnNames, int coordinateX, int coordinateY, int width, int height) {
    this.columnNames = columnNames;
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
    this.width = width;
    this.height = height;
    this.initalize();
    
  }
  
  /**
   * Khoi tao bang nhan vien.
   */
  
  public void initalize() {
  
    
    this.setLayout(null);
    
    JScrollPane scrollPane = new JScrollPane();
    this.setBounds(coordinateX, coordinateY, width, height);
    scrollPane.setBounds(5, 5, width - 5, height - 5);
    this.add(scrollPane);
    table = new JTable();
    model = new MyModel(this.columnNames);
    table.setModel(model);
    scrollPane.setViewportView(table);
    System.out.println("okkd");
  }

}
