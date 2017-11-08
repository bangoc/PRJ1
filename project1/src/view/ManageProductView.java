package view;

import controller.DoubleClickProductController;
import controller.MakeNewImportReceiptViewController;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class ManageProductView {

  private JFrame frame;
  private MyTable panel;
  private JLabel lblName;
  private JTextField txtName;
  private JLabel lblProducer;
  private JTextField txtProducer;
  private JLabel lblRemainAmount;
  private JTextField txtRemainAmount;
  private JLabel lblSoldAmount;
  private JTextField txtSoldAmount;
  private JTextField txtCode;
  private JLabel lblCode;
  private JLabel lblProviderId;
  private JTextField txtProviderId;
  private JPanel infoPanel;
  
  public JLabel[] getListValueLabel() {
    return listValueLabel;
  }

  public void setListValueLabel(JLabel[] listValueLabel) {
    this.listValueLabel = listValueLabel;
  }

  private JLabel[] listValueLabel;
  
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
    frame = new JFrame();
    frame.setBounds(80, 40, 1500, 800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(20, 250, 810, 400);
    frame.getContentPane().add(scrollPane);
    
    String[] columnNames = {"No data"};
    panel = new MyTable(columnNames, 2, 2, 806, 396);
    panel.getTable().addMouseListener(new DoubleClickProductController(this));
    scrollPane.setViewportView(panel);
    
    JButton btnBack = new JButton("Back");
    btnBack.setBounds(750, 730, 100, 30);
    btnBack.setFont(new Font("Dialog", Font.BOLD, 15));
    btnBack.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
        new TaskManagerView();
      }
    
    });
    frame.getContentPane().add(btnBack);
    
    lblCode = new JLabel("Ma san pham");
    lblCode.setFont(new Font("Dialog", Font.BOLD, 15));
    lblCode.setBounds(30, 27, 150, 25);
    frame.getContentPane().add(lblCode);
    
    txtCode = new JTextField();
    txtCode.setBounds(200, 27, 200, 25);
    frame.getContentPane().add(txtCode);
    txtCode.setColumns(10);
    
    lblName = new JLabel("Ten san pham");
    lblName.setBounds(30, 75, 150, 25);
    lblName.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblName);
    
    txtName = new JTextField();
    txtName.setBounds(200, 75, 200, 25);
    txtName.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(txtName);
    
    lblProviderId = new JLabel("Ma nha cung cap");
    lblProviderId.setBounds(420, 27, 150, 25);
    lblProviderId.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblProviderId);
    
    txtProviderId = new JTextField();
    txtProviderId.setBounds(620, 27, 200, 25);
    txtProviderId.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(txtProviderId);
    
    lblProducer = new JLabel("Nha san xuat");
    lblProducer.setBounds(420, 75, 150, 25);
    lblProducer.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblProducer);
    
    txtProducer = new JTextField();
    txtProducer.setBounds(620, 75, 200, 25);
    txtProducer.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(txtProducer);
    
    lblRemainAmount = new JLabel("So luong hien co");
    lblRemainAmount.setBounds(30, 123, 150, 25);
    lblRemainAmount.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblRemainAmount);
    
    txtRemainAmount = new JTextField();
    txtRemainAmount.setBounds(200, 123, 200, 25);
    txtRemainAmount.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(txtRemainAmount);
    
    lblSoldAmount = new JLabel("So luong da ban");
    lblSoldAmount.setBounds(420, 123, 150, 25);
    lblSoldAmount.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(lblSoldAmount);
    
    txtSoldAmount = new JTextField();
    txtSoldAmount.setBounds(620, 123, 200, 25);
    txtSoldAmount.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(txtSoldAmount);
    
    JButton btnSearch = new JButton("Search");
    btnSearch.setBounds(30, 178, 150, 25);
    btnSearch.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(btnSearch);
    
    JButton btnMakeNewImportReceipt = new JButton("Add goods");
    btnMakeNewImportReceipt.setBounds(230, 178, 150, 25);
    btnMakeNewImportReceipt.setFont(new Font("Dialog", Font.BOLD, 15));
    btnMakeNewImportReceipt.addActionListener(new MakeNewImportReceiptViewController(this));
    frame.getContentPane().add(btnMakeNewImportReceipt);
    
    JButton btnInfo = new JButton("Info");
    btnInfo.setBounds(630, 178, 150, 25);
    btnInfo.setFont(new Font("Dialog", Font.BOLD, 15));
    frame.getContentPane().add(btnInfo);
    
    //all infoPanel's components below
    
    infoPanel = new JPanel();
    infoPanel.setBounds(880, 27, 600, 700);
    infoPanel.setLayout(null);
   
    frame.getContentPane().add(infoPanel);
    
    JLabel[] listKeyLabel = new JLabel[13];
    listValueLabel = new JLabel[13];
    String[] arrayText = {"ID Product", "Name", "Price", "Producer", "Produce Date", 
        "Expire Date", "Supplier Id", "Supplier Name", "Import Price", "Amount", "Import Date",
        "Importer Id", "Importer Name"};
    for (int i = 0; i < 13; i ++) {
      listValueLabel[i] = new JLabel("" + i);
      listKeyLabel[i] = new JLabel(arrayText[i]);
      listKeyLabel[i].setBounds(20, 2 + 50 * i, 200, 25);
      listValueLabel[i].setBounds(230, 2 + 50 * i, 300, 25);
      listKeyLabel[i].setFont(new Font("Dialog", Font.BOLD, 15));
      listValueLabel[i].setFont(new Font("Dialog", Font.BOLD, 15));
 
      infoPanel.add(listKeyLabel[i]);
      infoPanel.add(listValueLabel[i]);
    }
    
  
  }

  public JTextField getTxtProviderId() {
    return txtProviderId;
  }

  public void setTxtProviderId(JTextField txtProviderId) {
    this.txtProviderId = txtProviderId;
  }

  public JTextField getTxtCode() {
    return txtCode;
  }

  public void setTxtCode(JTextField txtCode) {
    this.txtCode = txtCode;
  }

  public JLabel getLblName() {
    return lblName;
  }

  public void setLblName(JLabel lblName) {
    this.lblName = lblName;
  }

  public JTextField getTxtName() {
    return txtName;
  }

  public void setTxtName(JTextField txtName) {
    this.txtName = txtName;
  }

  public JLabel getLblProducer() {
    return lblProducer;
  }

  public void setLblProducer(JLabel lblProducer) {
    this.lblProducer = lblProducer;
  }

  public JTextField getTxtProducer() {
    return txtProducer;
  }

  public void setTxtProducer(JTextField txtProducer) {
    this.txtProducer = txtProducer;
  }

  public JLabel getLblPrice() {
    return lblRemainAmount;
  }

  public void setLblPrice(JLabel lblPrice) {
    this.lblRemainAmount = lblPrice;
  }

  public JTextField getTxtRemainamount() {
    return txtRemainAmount;
  }

  public void setTxtPrice(JTextField txtPrice) {
    this.txtRemainAmount = txtPrice;
  }

  public JLabel getLblRemainAmount() {
    return lblSoldAmount;
  }

  public void setLblRemainAmount(JLabel lblRemainAmount) {
    this.lblSoldAmount = lblRemainAmount;
  }

  public JTextField getTxtSoldAmount() {
    return txtSoldAmount;
  }

  public void setTxtRemainAmount(JTextField txtRemainAmount) {
    this.txtSoldAmount = txtRemainAmount;
  }
}
