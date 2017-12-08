package model.employee;

public class Manager extends Employee {
  private int commission;
  
  public Manager() {
    
  }
  
  
  public int getCommission() {
    return commission;
  }

  public void setCommission(int commission) {
    if (commission > 100) {
      this.commission = 0;
    } else {
      this.commission = commission;
    }
  }
  
  
}
