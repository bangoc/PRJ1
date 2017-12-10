package model.employee;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;

public class Salesman extends Employee {
  private int subsidy;
  
  
  public Salesman() {
    super();
  }
  
  public Salesman(int id, String name, Gender gender, Date birthday, String address, 
      String phone, int coefficient, ImageIcon img, Account account) {
    super(id, name, gender, birthday, address, phone, coefficient, img, account);
  }
  
  public int getSubsidy() {
    return subsidy;
  }


  public void setSubsidy(int subsidy) {
    this.subsidy = subsidy;
    
  }

  @Override
  public int countSalary() {
    return super.countSalary() + subsidy;
  }
  


//  
//  @Override
//  public String[] toArrayString() {
//    ResourceBundle b = ResourceBundle.getBundle("view.Label");
//
//    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//    String[] array = {"" + this.getEmployeeId(), this.getName(), this.getSex(), 
//        df.format(this.getDateOfBirth()), this.getAddress(), this.getPhoneNumber(),
//        "" + this.getCoefficientsSalary(), b.getString("Salesman")};
//    return array;
//  }
}
