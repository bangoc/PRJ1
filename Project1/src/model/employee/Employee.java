package model.employee;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import model.MyUtils.MyDate;

public class Employee {
  private int employeeId;
  private String name;
  private Gender gender;
  private MyDate dateOfBirth;
  private String address;
  private String phoneNumber;
  private int coefficientsSalary;
  private ArrayList<WorkHistory> workHistory;
  private static final int DEFAULT_SALARY = 1000000;
  private ImageIcon image;
  

  public ImageIcon getImage() {
    return image;
  }

  public void setImage(ImageIcon image) {
    this.image = image;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public MyDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(MyDate dateOfBirth) {
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
//  
//  public String[] toArrayString() {
//    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//    ResourceBundle b = ResourceBundle.getBundle("view.Label");
//
//    String[] array = {"" + this.employeeId, this.name, this.sex, 
//        df.format(this.dateOfBirth), this.address, this.phoneNumber, "" + this.coefficientsSalary, 
//        b.getString("Employee")};
//    return array;
//  }
  
}
