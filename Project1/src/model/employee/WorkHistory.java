package model.employee;

import java.util.Date;

public class WorkHistory {
  private Date date;
  private int salary;
  
  public WorkHistory() {
    
  }

  public Date getPaidTime() {
    return date;
  }

  public void setPaidTime(Date paidTime) {
    this.date = paidTime;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  
}
