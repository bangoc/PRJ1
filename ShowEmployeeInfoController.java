package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import model.Employee;
import model.Manager;

public class ShowEmployeeInfoController implements ActionListener {
  private Employee employee;
  private JLabel[] lblGroup;
  /**
   * Constructor.
   * @param manager = manager
   * @param employee = employee
   * @param lblGroup = lblGroup
   */
  
  public ShowEmployeeInfoController(Manager manager, Employee employee, JLabel[] lblGroup) {
    // TODO Auto-generated constructor stub
    this.employee = employee;
    this.lblGroup = lblGroup;
  }
  
  @Override
  public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub
    lblGroup[0].setText(employee.getEmployeeInfo().getName());
    lblGroup[1].setText(String.valueOf(employee.getEmployeeInfo().getAges()));
    lblGroup[2].setText(employee.getEmployeeInfo().getSex());
    lblGroup[3].setText(employee.getEmployeeInfo().getDateOfBirth());
    lblGroup[4].setText(employee.getEmployeeInfo().getDateBeginWork());
    lblGroup[5].setText(employee.getEmployeeId());
    lblGroup[6].setText(String.valueOf(employee.getEmployeeInfo().getSalaryPerSession()));
    lblGroup[7].setText(String.valueOf(employee.getEmployeeTimework().getSessionCount()));
  }
}
