package model.market;

public class Supplier {
  private int supplierId;
  private String name;
  private String address;
  private String email;
  private String phone;
  
  public Supplier(String name, String address, String email, String phone) {
    this.name = name;
    this.address = address;
    this.email = email;
    this.phone = phone;
  }
  
  public Supplier() {
    
  }
  
  public int getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(int supplierId) {
    this.supplierId = supplierId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phone;
  }

  public void setPhoneNumber(String phone) {
    this.phone = phone;
  }
  


 
}
