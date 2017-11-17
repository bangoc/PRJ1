package mdl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkHistory {
  private Date paidTime;
  private int salary;
  
  public WorkHistory() {
    
  }

  public Date getPaidTime() {
    return paidTime;
  }

  public void setPaidTime(Date paidTime) {
    this.paidTime = paidTime;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }
  
  /**
   * Method convert attributes of an instance of WorkHistory Class to String[].
   * @return String[]
   */
  
  public String[] toArrayString() {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String[] array = {df.format(paidTime), "" + this.salary};
    return array;
  }
  
}
