package model;

import java.util.ArrayList;

public class Manager extends Employee {
  public Manager() {}
  /**
   * This method creat new id for new employee.
   * @return new id
   */
  
  public String creatIdForNewEmployee() { 
    Account account = new Account();
    String newId = account.generateNewId();
    ConnDb.saveNewEmployeeId(account);;
    return newId;

  }
  
  public void importGoods(Goods goods) {
    ConnDb.saveGoodsAfterImported(goods);
  }
  
  public void setSalaryPerSessionForEmployee(Employee nv, int salaryPerSession) {
    nv.getEmployeeInfo().changeSalaryPerSession(salaryPerSession,nv.getEmployeeId());
  }
  
  public ArrayList<Employee> getEmpoyeeList() {
    return (new ConnDb().getEmployeeList());
  }
}
