package model.employee;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class Salesman extends Employee {
  private int subsidy;
  
  
  public Salesman() {
    super();
  }
  
  
  public int getSubsidy() {
    return subsidy;
  }


  public void setSubsidy(int subsidy) {
    this.subsidy = subsidy;
    
  }

  public int countSalary() {
    return super.countSalary() + subsidy;
  }
  


  
  @Override
  public String[] toArrayString() {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String[] array = {"" + this.getIdNumber(), this.getName(), this.getSex(), 
        df.format(this.getDateOfBirth()), this.getAddress(), this.getPhoneNumber(),
        "" + this.getCoefficientsSalary(), b.getString("Salesman")};
    return array;
  }
}
