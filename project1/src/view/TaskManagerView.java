package view;

import controller.NavigateToManageEmployeeViewController;
import controller.NavigateToManageProductViewController;
import model.Loader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;


public class TaskManagerView {
  private JFrame frame;

  public TaskManagerView() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    frame = new JFrame();
    frame.setBounds(400, 300, 800, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    JButton btnEmployeeTab = new JButton(b.getString("EmployeeTab"));
    btnEmployeeTab.addActionListener(new NavigateToManageEmployeeViewController(frame));
    btnEmployeeTab.setBounds(20, 160, 300, 30);
    frame.getContentPane().add(btnEmployeeTab);
    frame.setVisible(true);
    
    JButton btnProductTab = new JButton(b.getString("ProductTab"));
    btnProductTab.addActionListener(new NavigateToManageProductViewController(frame));
    btnProductTab.setBounds(380, 160, 300, 30);
    frame.getContentPane().add(btnProductTab);
    
    JButton btnExportTab = new JButton(b.getString("MakeExReceipt"));
    btnExportTab.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        new MakeNewExportReceiptView();
        frame.dispose();
        
      }
    });
    btnExportTab.setBounds(20, 220, 300, 30);
    frame.getContentPane().add(btnExportTab);
    
    JButton btnOther = new JButton(b.getString("SupermarketTab"));
    btnOther.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent arg0) {
        frame.dispose();
        new SupermarketInfoView();
      }
    });
    btnOther.setBounds(380, 220, 300, 30);
    frame.getContentPane().add(btnOther);
    
    JButton btnSetting = new JButton(b.getString("Setting"));
    btnSetting.setBounds(20, 280, 150, 30);
    btnSetting.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
        SettingView settingView = new SettingView();
        try {
          
          String importLink = Loader.loadLink(1);
          settingView.getTxtImportLocation().setText(importLink);
          String exportLink = Loader.loadLink(2);
          settingView.getTxtExportLocation().setText(exportLink);
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
      }
    });
    frame.getContentPane().add(btnSetting);
    
  }
}
