package view;

import controller.KiemTraNhaCungCapController;
import controller.ThemHangHoaController;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ThemHangHoaView {

  private JFrame frame;
  private JTextField txtName;
  private JTextField txtProviderId;
  private JTextField txtPrice;
  private JTextField txtProducer;
  private JTextField txtProduceDate;
  private JTextField txtExpireDate;
  private JTextField txtAmount;

  public ThemHangHoaView() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(350, 50, 900, 800);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setVisible(true);
    Container contentPane = frame.getContentPane();
    contentPane.setLayout(null);
    Font font = new Font("Dialog", Font.BOLD, 15);
    
    JLabel lblName = new JLabel("Ten san pham");
    lblName.setFont(font);
    lblName.setBounds(80, 70, 150, 25);
    contentPane.add(lblName);
    
    JLabel lblProviderId = new JLabel("Ma nha cung cap");
    lblProviderId.setFont(font);
    lblProviderId.setBounds(80, 120, 150, 25);
    contentPane.add(lblProviderId);
    
    JLabel lblPrice = new JLabel("Gia tien");
    lblPrice.setFont(font);
    lblPrice.setBounds(80, 170, 150, 25);
    contentPane.add(lblPrice);
    
    JLabel lblProducer = new JLabel("Nha san xuat");
    lblProducer.setFont(font);
    lblProducer.setBounds(80, 220, 150, 25);
    contentPane.add(lblProducer);
    
    JLabel lblProduceDate = new JLabel("Ngay san xuat");
    lblProduceDate.setFont(font);
    lblProduceDate.setBounds(80, 270, 150, 25);
    contentPane.add(lblProduceDate);
    
    JLabel lblExpireDate = new JLabel("Ngay het han");
    lblExpireDate.setFont(font);
    lblExpireDate.setBounds(80, 320, 150, 25);
    contentPane.add(lblExpireDate);
    
    JLabel lblAmount = new JLabel("So luong");
    lblAmount.setFont(font);
    lblAmount.setBounds(80, 370, 150, 25);
    contentPane.add(lblAmount);
    
    txtName = new JTextField();
    txtName.setFont(font);
    txtName.setBounds(300, 70, 400, 25);
    contentPane.add(txtName);
    
    txtProviderId = new JTextField();
    txtProviderId.setFont(font);
    txtProviderId.setBounds(300, 120, 400, 25);
    contentPane.add(txtProviderId);
    
    JButton btnCheck = new JButton("Check");
    btnCheck.setFont(font);
    btnCheck.setBounds(720, 120, 100, 25);
    btnCheck.addActionListener(new KiemTraNhaCungCapController(txtProviderId, btnCheck));
    contentPane.add(btnCheck);
    
    txtPrice = new JTextField();
    txtPrice.setFont(font);
    txtPrice.setBounds(300, 170, 400, 25);
    contentPane.add(txtPrice);
    
    txtProducer = new JTextField();
    txtProducer.setFont(font);
    txtProducer.setBounds(300, 220, 400, 25);
    contentPane.add(txtProducer);
    
    txtProduceDate = new JTextField();
    txtProduceDate.setFont(font);
    txtProduceDate.setBounds(300, 270, 400, 25);
    contentPane.add(txtProduceDate);
    
    txtExpireDate = new JTextField();
    txtExpireDate.setFont(font);
    txtExpireDate.setBounds(300, 320, 400, 25);
    contentPane.add(txtExpireDate);
    
    txtAmount = new JTextField();
    txtAmount.setFont(font);
    txtAmount.setBounds(300, 370, 400, 25);
    contentPane.add(txtAmount);
    
    JButton btnAdd = new JButton("Add");
    btnAdd.setFont(font);
    btnAdd.setBounds(80, 450, 100, 25);
    btnAdd.addActionListener(new ThemHangHoaController(this));
    contentPane.add(btnAdd);
    
    JButton btnBack = new JButton("Back");
    btnBack.setFont(font);
    btnBack.setBounds(220, 450, 100, 25);
    btnBack.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent arg0) {
        frame.dispose();        
      }
    });
    contentPane.add(btnBack);
  }

  public JFrame getFrame() {
    return frame;
  }

  public void setFrame(JFrame frame) {
    this.frame = frame;
  }

  public JTextField getTxtName() {
    return txtName;
  }

  public void setTxtName(JTextField txtName) {
    this.txtName = txtName;
  }

  public JTextField getTxtProviderId() {
    return txtProviderId;
  }

  public void setTxtProviderId(JTextField txtProviderId) {
    this.txtProviderId = txtProviderId;
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

  public JTextField getTxtProduceDate() {
    return txtProduceDate;
  }

  public void setTxtProduceDate(JTextField txtProduceDate) {
    this.txtProduceDate = txtProduceDate;
  }

  public JTextField getTxtExpireDate() {
    return txtExpireDate;
  }

  public void setTxtExpireDate(JTextField txtExpireDate) {
    this.txtExpireDate = txtExpireDate;
  }

  public JTextField getTxtAmount() {
    return txtAmount;
  }

  public void setTxtAmount(JTextField txtAmount) {
    this.txtAmount = txtAmount;
  }

}
