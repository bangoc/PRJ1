package view;

import controller.DoubleClickEmployee;
import controller.UpdateEmployeeListViewController;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ManageEmployeeView {

  private JFrame frame;
  private MyTable bangNhanVienView;
 
  public MyTable getBangNhanVienView() {
    return bangNhanVienView;
  }

  public void setBangNhanVienView(MyTable bangNhanVienView) {
    this.bangNhanVienView = bangNhanVienView;
  }

  public ManageEmployeeView() {
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
    
    String[] columnNames = {"No data"};
    bangNhanVienView = new MyTable(columnNames, 20, 20, 1450, 365);
    bangNhanVienView.getTable().addMouseListener(new DoubleClickEmployee(bangNhanVienView));
    frame.getContentPane().add(bangNhanVienView);
    
    Container contentPane = frame.getContentPane();
    JButton btnUpdate = new JButton(b.getString("Update"));
    btnUpdate.addActionListener(new UpdateEmployeeListViewController(this));
    btnUpdate.setBounds(20, 426, 117, 25);
    contentPane.add(btnUpdate);
    
    
    JButton btnAdd = new JButton(b.getString("Add"));
    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        new AddNewEmpployeeView();
      }
    });
    btnAdd.setBounds(150, 426, 117, 25);
    contentPane.add(btnAdd);
    
    
    JButton btnPaySalary = new JButton(b.getString("PaySalary"));
    btnPaySalary.setBounds(410, 426, 117, 25);
    contentPane.add(btnPaySalary);
    
    JButton btnBack = new JButton(b.getString("Back"));
    btnBack.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame.dispose();
        new TaskManagerView();
      }
    });
    btnBack.setBounds(20, 492, 117, 25);
    frame.getContentPane().add(btnBack);
    
    
    
  }

  public JFrame getFrame() {
    return frame;
  }

  public void setFrame(JFrame frame) {
    this.frame = frame;
  }
}
