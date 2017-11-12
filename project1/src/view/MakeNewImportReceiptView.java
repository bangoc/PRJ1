package view;

import controller.AddNewSupplierViewController;
import controller.CancelMakingNewImportReceiptController;
import controller.CreateImportReceiptController;
import controller.InsertItemToImportReceiptController;

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
import javax.swing.SwingConstants;


public class MakeNewImportReceiptView {

  private JFrame frame;
  private JTextField txtName;
  private JTextField txtPrice;
  private JTextField txtProducer;
  private JTextField txtImportPrice;
  private JTextField txtExpireDate;
  private JTextField txtProduceDate;
  private JTextField txtAmount;
  private JComboBox<String> comboBox;
  private MyTable table;

  public MakeNewImportReceiptView() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    frame = new JFrame();
    frame.setBounds(80, 40, 1500, 800);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
    JLabel lblNewLabel = new JLabel(b.getString("ImportReceipt"));
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(96, 11, 719, 44);
    frame.getContentPane().add(lblNewLabel);
    
    JLabel lblName = new JLabel(b.getString("ProductName"));
    lblName.setBounds(65, 99, 150, 22);
    frame.getContentPane().add(lblName);
    
    txtName = new JTextField("Banh Keo");
    txtName.setBounds(265, 99, 420, 22);
    frame.getContentPane().add(txtName);
    txtName.setColumns(10);
    
    JButton btnInsert = new JButton(b.getString("Insert"));
    btnInsert.setEnabled(false);
    btnInsert.addActionListener(new InsertItemToImportReceiptController(this));
    btnInsert.setBounds(65, 231, 89, 23);
    frame.getContentPane().add(btnInsert);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(65, 265, 1295, 306);
    frame.getContentPane().add(scrollPane);
    String[] columnNames =  {b.getString("ProductName"), b.getString("Price"), b.getString("Producer"), b.getString("ProduceDate"), b.getString("ExpireDate"), 
        b.getString("Amount"), b.getString("ImportPrice")};
    table = new MyTable(columnNames, 65, 265, 1295, 306);
    scrollPane.setViewportView(table);
    
    JLabel lblSelectSupplier = new JLabel(b.getString("SelectSupplier"));
    lblSelectSupplier.setHorizontalAlignment(SwingConstants.LEFT);
    lblSelectSupplier.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblSelectSupplier.setBounds(65, 582, 567, 33);
    frame.getContentPane().add(lblSelectSupplier);
    
    comboBox = new JComboBox<>();
    comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"No data"}));
    comboBox.setBounds(65, 626, 488, 22);
    frame.getContentPane().add(comboBox);
    
    JButton btnNewButton = new JButton("+");
    btnNewButton.addActionListener(new AddNewSupplierViewController(comboBox));
    btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
    btnNewButton.setBounds(585, 626, 89, 23);
    frame.getContentPane().add(btnNewButton);
    
    btnInsert.setEnabled(true);
    
    JButton btnCreate = new JButton(b.getString("Print"));
    btnCreate.addActionListener(new CreateImportReceiptController(this));
    btnCreate.setBounds(65, 670, 120, 23);
    frame.getContentPane().add(btnCreate);
    
    txtPrice = new JTextField("10");
    txtPrice.setColumns(10);
    txtPrice.setBounds(940, 99, 420, 22);
    frame.getContentPane().add(txtPrice);
    
    JLabel lblPrice = new JLabel(b.getString("Price"));
    lblPrice.setBounds(729, 99, 150, 22);
    frame.getContentPane().add(lblPrice);
    
    JLabel lblProducer = new JLabel(b.getString("Producer"));
    lblProducer.setBounds(65, 132, 150, 22);
    frame.getContentPane().add(lblProducer);
    
    JLabel lblImportPrice = new JLabel(b.getString("ImportPrice"));
    lblImportPrice.setBounds(65, 165, 150, 22);
    frame.getContentPane().add(lblImportPrice);
    
    txtProducer = new JTextField("Ha noi");
    txtProducer.setColumns(10);
    txtProducer.setBounds(265, 132, 420, 22);
    frame.getContentPane().add(txtProducer);
    
    txtImportPrice = new JTextField("10000");
    txtImportPrice.setColumns(10);
    txtImportPrice.setBounds(265, 165, 420, 22);
    frame.getContentPane().add(txtImportPrice);
    
    JLabel lblProducerDate = new JLabel(b.getString("ProduceDate"));
    lblProducerDate.setBounds(729, 132, 150, 22);
    frame.getContentPane().add(lblProducerDate);
    
    JLabel lblExpireDate = new JLabel(b.getString("ExpireDate"));
    lblExpireDate.setBounds(729, 165, 150, 22);
    frame.getContentPane().add(lblExpireDate);
    
    txtExpireDate = new JTextField("20/11/2019");
    txtExpireDate.setToolTipText("dd/mm/yyyy");
    txtExpireDate.setColumns(10);
    txtExpireDate.setBounds(940, 165, 420, 22);
    frame.getContentPane().add(txtExpireDate);
    
    txtProduceDate = new JTextField("20/11/2017");
    txtProduceDate.setToolTipText("dd/mm/yyyy");
    txtProduceDate.setColumns(10);
    txtProduceDate.setBounds(940, 132, 420, 22);
    frame.getContentPane().add(txtProduceDate);
    
    JLabel lblAmount = new JLabel(b.getString("Amount"));
    lblAmount.setBounds(65, 198, 150, 22);
    frame.getContentPane().add(lblAmount);
    
    txtAmount = new JTextField("20");
    txtAmount.setColumns(10);
    txtAmount.setBounds(265, 198, 420, 22);
    frame.getContentPane().add(txtAmount);
    
    JLabel lblInputProductsInformation = new JLabel(b.getString("InputInfoProduct"));
    lblInputProductsInformation.setFont(new Font("Tahoma", Font.PLAIN, 15));
    lblInputProductsInformation.setBounds(65, 66, 700, 22);
    frame.getContentPane().add(lblInputProductsInformation);
    
    JButton btnCancel = new JButton(b.getString("Back"));
    btnCancel.setBounds(65, 710, 120, 23);
    btnCancel.addActionListener(new CancelMakingNewImportReceiptController(frame));
    frame.getContentPane().add(btnCancel);
    
    
  }

  public JFrame getFrame() {
    return frame;
  }

  public void setFrame(JFrame frame) {
    this.frame = frame;
  }

  public JComboBox<String> getComboBox() {
    return comboBox;
  }

  public void setComboBox(JComboBox<String> comboBox) {
    this.comboBox = comboBox;
  }

  public JTextField getTxtName() {
    return txtName;
  }

  public void setTxtName(JTextField txtName) {
    this.txtName = txtName;
  }

  public JTextField getTxtPrice() {
    return txtPrice;
  }

  public void setTxtPrice(JTextField txtPrice) {
    this.txtPrice = txtPrice;
  }

  public JTextField getTxtProducer() {
    return txtProducer;
  }

  public void setTxtProducer(JTextField txtProducer) {
    this.txtProducer = txtProducer;
  }

  public JTextField getTxtImportPrice() {
    return txtImportPrice;
  }

  public void setTxtImportPrice(JTextField txtImportPrice) {
    this.txtImportPrice = txtImportPrice;
  }

  public JTextField getTxtExpireDate() {
    return txtExpireDate;
  }

  public void setTxtExpireDate(JTextField txtExpireDate) {
    this.txtExpireDate = txtExpireDate;
  }

  public JTextField getTxtProduceDate() {
    return txtProduceDate;
  }

  public void setTxtProduceDate(JTextField txtProduceDate) {
    this.txtProduceDate = txtProduceDate;
  }

  public JTextField getTxtAmount() {
    return txtAmount;
  }

  public void setTxtAmount(JTextField txtAmount) {
    this.txtAmount = txtAmount;
  }

  public MyTable getTable() {
    return table;
  }

  public void setTable(MyTable table) {
    this.table = table;
  }
}