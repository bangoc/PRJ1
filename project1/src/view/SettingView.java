package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ResourceBundle;

import model.Saver;

public class SettingView {

  private JFrame frame;
  private JTextField txtImportLocation;
  private JTextField txtExportLocation;

  public SettingView() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    frame = new JFrame();
    frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 15));
    frame.getContentPane().setLayout(null);
    frame.setVisible(true);
    frame.setTitle(b.getString("Setting"));
    

    
    JLabel lblLanguage = new JLabel(b.getString("Language") + " : ");
    lblLanguage.setFont(new Font("Dialog", Font.BOLD, 20));
    lblLanguage.setBounds(33, 50, 138, 30);
    frame.getContentPane().add(lblLanguage);
    
    JComboBox<String> comboBox = new JComboBox<>();
    comboBox.setFont(new Font("Dialog", Font.BOLD, 15));
    comboBox.setModel(new DefaultComboBoxModel<String>(
        new String[] {b.getString("SelectLang"), b.getString("English"), b.getString("VietNamese") }));
    comboBox.setBounds(33, 100, 200, 25);
    frame.getContentPane().add(comboBox);
  
    
    JLabel lblImport = new JLabel(b.getString("Import") + " : ");
    lblImport.setBounds(33, 150, 400, 30);
    lblImport.setFont(new Font("Dialog", Font.BOLD, 20));
    frame.getContentPane().add(lblImport);
    
    txtImportLocation = new JTextField();
    txtImportLocation.setFont(new Font("Tahoma", Font.BOLD, 15));
    txtImportLocation.setBounds(33, 200, 350, 25);
    txtImportLocation.setEditable(false);
    frame.getContentPane().add(txtImportLocation);
    
    JButton btnImport = new JButton(b.getString("Browse"));
    btnImport.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnImport.setBounds(400, 200, 100, 25);
    btnImport.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
          String link = chooser.getSelectedFile().getAbsolutePath();
          txtImportLocation.setText(link);   
        } else {
          return;
        }
      }
    });
    frame.getContentPane().add(btnImport);
    
    JLabel lblExport = new JLabel(b.getString("Export") + " : ");
    lblExport.setBounds(33, 250, 400, 30);
    lblExport.setFont(new Font("Dialog", Font.BOLD, 20));
    frame.getContentPane().add(lblExport);
    
    txtExportLocation = new JTextField();
    txtExportLocation.setFont(new Font("Tahoma", Font.BOLD, 15));
    txtExportLocation.setBounds(33, 300, 350, 25);
    txtExportLocation.setEditable(false);
    frame.getContentPane().add(txtExportLocation);
    
    JButton btnExport = new JButton(b.getString("Browse"));
    btnExport.setFont(new Font("Tahoma", Font.BOLD, 15));
    btnExport.setBounds(400, 300, 100, 25);
    btnExport.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
          String link = chooser.getSelectedFile().getAbsolutePath();
          txtExportLocation.setText(link);
        } else {
          return;
        }
      }
    });
    frame.getContentPane().add(btnExport);
    
    JButton btnBack = new JButton(b.getString("Back"));
    btnBack.setBounds(150, 350, 100, 25);
    btnBack.setFont(new Font("Dialog", Font.BOLD, 15));
    btnBack.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
        new TaskManagerView();

        
      }
    });
    frame.getContentPane().add(btnBack);
    
    JButton btnSave = new JButton(b.getString("Save"));
    btnSave.setBounds(33, 350, 100, 25);
    btnSave.setFont(new Font("Dialog", Font.BOLD, 15));
    btnSave.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          Saver.saveLink(txtImportLocation.getText(), 1);
          Saver.saveLink(txtExportLocation.getText(), 2);
          int index = comboBox.getSelectedIndex();
          String language = "";
          if (index == 1) {
            language = "English";
            Saver.saveLink(language, 3);
          } else if (index == 2){
            language = "VietNamese";
            Saver.saveLink(language, 3);
          } else {
            return;
          }
          JOptionPane.showMessageDialog(null, "OK");
          frame.dispose();
          new TaskManagerView();
        } catch (SQLException e1) {
          JOptionPane.showMessageDialog(null, "Error");
        }

      }
    });
    frame.getContentPane().add(btnSave);
    
    frame.setBounds(500, 200, 600, 450);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  public JFrame getFrame() {
    return frame;
  }

  public void setFrame(JFrame frame) {
    this.frame = frame;
  }

  public JTextField getTxtImportLocation() {
    return txtImportLocation;
  }

  public void setTxtImportLocation(JTextField txtImportLocation) {
    this.txtImportLocation = txtImportLocation;
  }

  public JTextField getTxtExportLocation() {
    return txtExportLocation;
  }

  public void setTxtExportLocation(JTextField txtExportLocation) {
    this.txtExportLocation = txtExportLocation;
  }
  
}
