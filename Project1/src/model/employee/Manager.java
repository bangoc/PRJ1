package model.employee;

import java.util.Date;
import javax.swing.ImageIcon;

public class Manager extends Employee {
  private int commission;
  
  public Manager() {
    
  }
  
  public Manager(int id, String name, Gender gender, Date birthday, String address, 
      String phone, int coefficient, ImageIcon img, Account account) {
    super(id, name, gender, birthday, address, phone, coefficient, img, account);
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
