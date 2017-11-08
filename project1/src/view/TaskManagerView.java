package view;

import controller.NavigateToManageEmployeeViewController;
import controller.NavigateToManageProductViewController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    frame = new JFrame();
    frame.setBounds(400, 300, 800, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    JButton btnEmployeeTab = new JButton("Employee Management Tab");
    btnEmployeeTab.addActionListener(new NavigateToManageEmployeeViewController(frame));
    btnEmployeeTab.setBounds(20, 160, 300, 30);
    frame.getContentPane().add(btnEmployeeTab);
    frame.setVisible(true);
    
    JButton btnProductTab = new JButton("Product Management Tab");
    btnProductTab.addActionListener(new NavigateToManageProductViewController(frame));
    btnProductTab.setBounds(380, 160, 300, 30);
    frame.getContentPane().add(btnProductTab);
    
    JButton btnExportTab = new JButton("Make Export Receipt");
    btnExportTab.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        new MakeNewExportReceiptView();
        frame.dispose();
        
      }
    });
    btnExportTab.setBounds(20, 220, 300, 30);
    frame.getContentPane().add(btnExportTab);
    
    JButton btnOther = new JButton("Other");
    btnOther.addActionListener(new NavigateToManageProductViewController(frame));
    btnOther.setBounds(380, 220, 300, 30);
    frame.getContentPane().add(btnOther);
  }
}
