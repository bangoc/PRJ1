
package view;

import controller.AddNewEmployeeController;
import controller.ChooseImageFileForNewEmployeeController;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ResourceBundle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class AddNewEmpployeeView {

  private JFrame frame;
  private JTextField txtName;
  private JTextField txtSex;
  private JTextField txtDateOfBirth;
  private JTextField txtAddress;
  private JTextField txtPhoneNo;
  private JTextField txtCoefficientSalary;
  private JComboBox<String> comboBox;
  private JLabel lblInput;
  private JTextField txtInput;
  private JTextField txtLink;
  private JLabel lblImage;
  
  public AddNewEmpployeeView() {
    initialize();
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


  public JTextField getTxtSex() {
    return txtSex;
  }


  public void setTxtSex(JTextField txtSex) {
    this.txtSex = txtSex;
  }


  public JTextField getTxtDateOfBirth() {
    return txtDateOfBirth;
  }


  public void setTxtDateOfBirth(JTextField txtDateOfBirth) {
    this.txtDateOfBirth = txtDateOfBirth;
  }


  public JTextField getTxtAddress() {
    return txtAddress;
  }


  public void setTxtAddress(JTextField txtAddress) {
    this.txtAddress = txtAddress;
  }


  public JTextField getTxtPhoneNo() {
    return txtPhoneNo;
  }


  public void setTxtPhoneNo(JTextField txtPhoneNo) {
    this.txtPhoneNo = txtPhoneNo;
  }


  public JTextField getTxtCoefficientSalary() {
    return txtCoefficientSalary;
  }


  public void setTxtCoefficientSalary(JTextField txtCoefficientSalary) {
    this.txtCoefficientSalary = txtCoefficientSalary;
  }


  public JComboBox<String> getComboBox() {
    return comboBox;
  }


  public void setComboBox(JComboBox<String> comboBox) {
    this.comboBox = comboBox;
  }


  public JTextField getTxtInput() {
    return txtInput;
  }


  public void setTxtInput(JTextField txtInput) {
    this.txtInput = txtInput;
  }


  public JTextField getTxtLink() {
    return txtLink;
  }


  public void setTxtLink(JTextField txtLink) {
    this.txtLink = txtLink;
  }


  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    frame = new JFrame();

    frame.setBounds(350, 100, 900, 700);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    
  
    
    Container container = frame.getContentPane();
    Font font = new Font("Dialog", Font.BOLD, 15);
    
    JLabel lblName = new JLabel(b.getString("Name"));
    lblName.setBounds(50, 60, 120, 25);
    lblName.setFont(font);
    container.add(lblName);
    
    txtName = new JTextField();
    txtName.setBounds(210, 60, 350, 25);
    txtName.setFont(font);
    container.add(txtName);
    
    JLabel lblSex = new JLabel(b.getString("Sex"));
    lblSex.setBounds(50, 100, 120, 25);
    lblSex.setFont(font);
    container.add(lblSex);
    
    txtSex = new JTextField();
    txtSex.setBounds(210, 100, 350, 25);
    txtSex.setFont(font);
    container.add(txtSex);
    
    JLabel lblDateOfBirth = new JLabel(b.getString("BirthDate"));
    lblDateOfBirth.setBounds(50, 140, 120, 25);
    lblDateOfBirth.setFont(font);
    container.add(lblDateOfBirth);
    
    lblInput = new JLabel();
    lblInput.setFont(font);
    lblInput.setBounds(50, 340, 150, 25);
    frame.getContentPane().add(lblInput);
    
    txtDateOfBirth = new JTextField();
    txtDateOfBirth.setBounds(210, 140, 350, 25);
    txtDateOfBirth.setFont(font);
    container.add(txtDateOfBirth);
    
    JLabel lblAddress = new JLabel(b.getString("Address"));
    lblAddress.setBounds(50, 180, 120, 25);
    lblAddress.setFont(font);
    container.add(lblAddress);
    
    txtAddress = new JTextField();
    txtAddress.setBounds(210, 180, 350, 25);
    txtAddress.setFont(font);
    container.add(txtAddress);
    
    JLabel lblPhoneNo = new JLabel(b.getString("PhoneNo"));
    lblPhoneNo.setBounds(50, 220, 120, 25);
    lblPhoneNo.setFont(font);
    container.add(lblPhoneNo);
    
    txtPhoneNo = new JTextField();
    txtPhoneNo.setBounds(210, 220, 350, 25);
    txtPhoneNo.setFont(font);
    container.add(txtPhoneNo);
    
    JLabel lblCoefficientSalary = new JLabel(b.getString("Coefficient"));
    lblCoefficientSalary.setBounds(50, 260, 120, 25);
    lblCoefficientSalary.setFont(font);
    container.add(lblCoefficientSalary);
    
    txtCoefficientSalary = new JTextField();
    txtCoefficientSalary.setBounds(210, 260, 350, 25);
    txtCoefficientSalary.setFont(font);
    container.add(txtCoefficientSalary);
    
    JLabel lblPosition = new JLabel(b.getString("Situation"));
    lblPosition.setFont(font);
    lblPosition.setBounds(50, 300, 150, 25);
    frame.getContentPane().add(lblPosition);
    
   
    
    txtInput = new JTextField();
    txtInput.setFont(font);
    txtInput.setBounds(210, 340, 200, 25);
    txtInput.setVisible(false);
    txtInput.setText("0");
    frame.getContentPane().add(txtInput);
    
    comboBox = new JComboBox<>();
    comboBox.setModel(new DefaultComboBoxModel<String>(
        new String[] {b.getString("Employee"), b.getString("Salesman"), b.getString("Manager")}));
    comboBox.setBounds(210, 300, 200, 25);
    comboBox.addItemListener(new ItemListener() {
      
      @Override
      public void itemStateChanged(ItemEvent e) {
        int index = comboBox.getSelectedIndex();
        if (index == 0) {
          lblInput.setText(null);
          txtInput.setVisible(false);
        } else if (index == 1) {
          lblInput.setText("Phu cap");
          txtInput.setVisible(true);
        } else if (index == 2) {
          lblInput.setText("Hoa hong");
          txtInput.setVisible(true);
        }
      }
    });
    frame.getContentPane().add(comboBox);
    
    lblImage = new JLabel();
    lblImage.setBounds(600, 60, 280, 370);
    frame.getContentPane().add(lblImage);
    
    txtLink = new JTextField();
    txtLink.setBounds(600, 465, 280, 25);
    txtLink.setFont(new Font("Dialog", Font.BOLD, 15));
    txtLink.setEditable(false);
    frame.getContentPane().add(txtLink);
    
    
    JButton btnBrowse = new JButton(b.getString("Browse"));
    btnBrowse.setBounds(600, 440, 280, 25);
    btnBrowse.setFont(new Font("Dialog", Font.BOLD, 15));
    btnBrowse.addActionListener(new ChooseImageFileForNewEmployeeController(this));
    frame.getContentPane().add(btnBrowse);
    
    JButton btnAdd = new JButton(b.getString("Add"));
    btnAdd.setBounds(50, 440, 150, 25);
    btnAdd.setFont(font);
    btnAdd.addActionListener(new AddNewEmployeeController(this));
    container.add(btnAdd);
    
    JButton btnBack = new JButton(b.getString("Back"));
    btnBack.setBounds(300, 440, 150, 25);
    btnBack.setFont(font);
    btnBack.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
        
      }
    });
    container.add(btnBack);
  }


  public JLabel getLblImage() {
    return lblImage;
  }


  public void setLblImage(JLabel lblImage) {
    this.lblImage = lblImage;
  }

}
