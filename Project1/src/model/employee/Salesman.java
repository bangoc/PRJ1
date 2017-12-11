package model.employee;

import java.util.Date;
import javax.swing.ImageIcon;

public class Salesman extends Employee {
  
  
  public Salesman() {
    super();
  }
  
  public Salesman(int id, String name, Gender gender, Date birthday, String address, 
      String phone, int coefficient, ImageIcon img, Account account) {
    super(id, name, gender, birthday, address, phone, coefficient, img, account);
  }

}
