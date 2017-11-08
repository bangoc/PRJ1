package mdl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Employee {
  private int idNumber;
  private String name;
  private String sex;
  private Date dateOfBirth;
  private String address;
  private String phoneNumber;
  private int coefficientsSalary;
  private ArrayList<WorkHistory> workHistory;
  private static final int DEFAULT_SALARY = 1000000;
  
  

  public int getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(int idNumber) {
    this.idNumber = idNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public int getCoefficientsSalary() {
    return coefficientsSalary;
  }

  public void setCoefficientsSalary(int coefficientsSalary) {
    this.coefficientsSalary = coefficientsSalary;
  }

  public int getDefaultSalary() {
    return DEFAULT_SALARY;
  }

  public ArrayList<WorkHistory> getWorkHistory() {
    return workHistory;
  }

  public void setWorkHistory(ArrayList<WorkHistory> workHistory) {
    this.workHistory = workHistory;
  }
  
  public int countSalary() {
    return coefficientsSalary * this.getDefaultSalary();
  }
  
  /**
   * Method convert attributes of an instance of Employee Class to String[].
   * @return String[]
   */
  
  public String[] toArrayString() {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String[] array = {"" + this.idNumber, this.name, this.sex, 
        df.format(this.dateOfBirth), this.address, this.phoneNumber, "" + this.coefficientsSalary, 
        "Employee"};
    return array;
  }
  
}
