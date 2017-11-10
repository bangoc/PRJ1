package view;

import controller.ChooseFileSaveDestinationController;
import controller.CreateNewExportReceiptController;
import controller.DeleteItemFromExportReceiptController;
import controller.InsertItemToExportReceiptController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;




public class MakeNewExportReceiptView {

  private JFrame frame;
  private MyTable panel;
  private JTextField txtId;
  private JTextField txtAmount;
  private JTextField txtPrice;
  private JLabel lblTotalPrice;
  private JTextField txtLocation;

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

  public JTextField getTxtId() {
    return txtId;
  }

  public void setTxtId(JTextField txtId) {
    this.txtId = txtId;
  }

  public JTextField getTxtAmount() {
    return txtAmount;
  }

  public void setTxtAmount(JTextField txtAmount) {
    this.txtAmount = txtAmount;
  }

  public JTextField getTxtPrice() {
    return txtPrice;
  }

  public void setTxtPrice(JTextField txtPrice) {
    this.txtPrice = txtPrice;
  }

  
  public MakeNewExportReceiptView() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(80, 40, 1500, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
    JLabel lblImportReceipt = new JLabel("Export Receipt");
    lblImportReceipt.setHorizontalAlignment(SwingConstants.CENTER);
    lblImportReceipt.setFont(new Font("Tahoma", Font.BOLD, 34));
    lblImportReceipt.setBounds(189, 11, 806, 79);
    frame.getContentPane().add(lblImportReceipt);
    
    JLabel lblId = new JLabel("ID");
    lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblId.setBounds(88, 122, 120, 30);
    frame.getContentPane().add(lblId);
    
    JLabel lblAmount = new JLabel("AMOUNT");
    lblAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblAmount.setBounds(88, 204, 120, 30);
    frame.getContentPane().add(lblAmount);
    
    JLabel lblSellPrice = new JLabel("Sell Price");
    lblSellPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblSellPrice.setBounds(88, 288, 120, 30);
    frame.getContentPane().add(lblSellPrice);
    
    JLabel lblLocation = new JLabel("Location");
    lblLocation.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblLocation.setBounds(88, 372, 120, 30);
    frame.getContentPane().add(lblLocation);
    
    txtLocation = new JTextField();
    txtLocation.setFont(new Font("Tahoma", Font.BOLD, 15));
    txtLocation.setBounds(210, 372, 200, 30);
    txtLocation.setEditable(false);
    frame.getContentPane().add(txtLocation);
    
    JButton btnChoose = new JButton("New");
    btnChoose.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnChoose.setBounds(415, 372, 72, 30);
    btnChoose.addActionListener(new ChooseFileSaveDestinationController(this));
    frame.getContentPane().add(btnChoose);
    
    txtId = new JTextField();
    txtId.setBounds(210, 123, 277, 30);
    frame.getContentPane().add(txtId);
    txtId.setColumns(10);
    
    txtAmount = new JTextField();
    txtAmount.setColumns(10);
    txtAmount.setBounds(210, 206, 277, 30);
    frame.getContentPane().add(txtAmount);
    
    txtPrice = new JTextField();
    txtPrice.setColumns(10);
    txtPrice.setBounds(210, 290, 277, 30);
    frame.getContentPane().add(txtPrice);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(672, 125, 673, 415);
    frame.getContentPane().add(scrollPane);
    
    String[] columnNames = {"ID", "Name", "Amount", "Price"}; 
    panel = new MyTable(columnNames, 2, 2, 680, 430);
    scrollPane.setViewportView(panel);
    
    JButton btnInsert = new JButton("Insert");
    btnInsert.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnInsert.setBounds(88, 470, 163, 30);
    btnInsert.addActionListener(new InsertItemToExportReceiptController(this));
    frame.getContentPane().add(btnInsert);
    
    JButton btnDelete = new JButton("Delete");
    btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnDelete.setBounds(88, 580, 163, 30);
    btnDelete.addActionListener(new DeleteItemFromExportReceiptController(this));
    frame.getContentPane().add(btnDelete);
    
    JButton btnCreate = new JButton("Create");
    btnCreate.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnCreate.setBounds(669, 641, 141, 30);
    btnCreate.addActionListener(new CreateNewExportReceiptController(this));
    frame.getContentPane().add(btnCreate);
    
    JButton btnBack = new JButton("Back");
    btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnBack.setBounds(88, 690, 164, 30);
    btnBack.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
        new TaskManagerView();
      }
    });
    frame.getContentPane().add(btnBack);
    
    JLabel lblTotal = new JLabel("Total :");
    lblTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblTotal.setBounds(669, 565, 200, 40);
    frame.getContentPane().add(lblTotal);
    
    lblTotalPrice = new JLabel("0");
    lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
    lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblTotalPrice.setBounds(967, 565, 340, 40);;
    frame.getContentPane().add(lblTotalPrice);
    
    JLabel lblVnd = new JLabel("vnd");
    lblVnd.setHorizontalAlignment(SwingConstants.RIGHT);
    lblVnd.setFont(new Font("Tahoma", Font.BOLD, 15));
    lblVnd.setBounds(1308, 565, 37, 40);;
    frame.getContentPane().add(lblVnd);
  }

  public JTextField getTxtLocation() {
    return txtLocation;
  }

  public void setTxtLocation(JTextField txtLocation) {
    this.txtLocation = txtLocation;
  }

  public JLabel getLblTotalPrice() {
    return lblTotalPrice;
  }

  public void setLblTotalPrice(JLabel lblTotalPrice) {
    this.lblTotalPrice = lblTotalPrice;
  }

}
