package view;

import controller.SearchProductController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class ManageProductView {

  private JFrame frame;
  private MyTable panel;
  private JTextField txtInput;
  private JComboBox<String> comboBox;

  public JTextField getTxtInput() {
    return txtInput;
  }

  public void setTxtInput(JTextField txtInput) {
    this.txtInput = txtInput;
  }

  public JComboBox<String> getComboBox() {
    return comboBox;
  }

  public void setComboBox(JComboBox<String> comboBox) {
    this.comboBox = comboBox;
  }

  public JFrame getFrame() {
    return frame;
  }

  public void setFrame(JFrame frame) {
    this.frame = frame;
  }

  public MyTable getPanel() {
    return panel;
  }

  public void setPanel(MyTable panel) {
    this.panel = panel;
  }

  public ManageProductView() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    frame = new JFrame();
    frame.setBounds(80, 40, 1500, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(25, 150, 809, 500);
    frame.getContentPane().add(scrollPane);
    
    String [] columnNames = {b.getString("nodata")};
    panel = new MyTable(columnNames, 2, 2, 798, 496);
    scrollPane.setViewportView(panel);
    
    JButton btnBack = new JButton(b.getString("Back"));
    btnBack.setBounds(30, 730, 100, 30);
    btnBack.setFont(new Font("Dialog", Font.BOLD, 15));
    btnBack.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
        new TaskManagerView();
      }
    
    });
    frame.getContentPane().add(btnBack);
    
    JLabel lblSearch = new JLabel(b.getString("Search"));
    lblSearch.setBounds(30, 50 , 300, 30);
    lblSearch.setFont(new Font("Dialog", Font.BOLD, 25));
    frame.getContentPane().add(lblSearch);
    
    String[] array = {b.getString("ProductId"), b.getString("SupplierId"), b.getString("ImportReceipt"),
        b.getString("ExportReceipt")};
    comboBox = new JComboBox<>(new DefaultComboBoxModel<>(array));
    comboBox.setBounds(30, 100, 200, 25);
    comboBox.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(comboBox);
    
    txtInput = new JTextField();
    txtInput.setBounds(250, 100, 200, 25);
    txtInput.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(txtInput);
    
    JButton btnSearch = new JButton(b.getString("Search"));
    btnSearch.setBounds(460, 100, 150, 25);
    btnSearch.addActionListener(new SearchProductController(this));
    btnSearch.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(btnSearch);
   
  }

  
}
