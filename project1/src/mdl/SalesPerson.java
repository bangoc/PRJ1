package mdl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

public class SalesPerson extends Employee {
  private int subsidy;
  
  
  public SalesPerson() {
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
  
  
  /**
   * This method creates a instance of ExportReceipt class.
   * @param listItem map contains :
   *      key is a product 
   *      value is Integer[] with amount of product and price of product
   * @return instance of ExportReceipt class
   */
  
  public ExportReceipt makeExportReceipt(LinkedHashMap<Product, Integer[]> listItem) {
    ExportReceipt receipt = new ExportReceipt();
    receipt.setListItem(listItem);
    receipt.setSalesPerson(this);
    receipt.setTime(new Date());
    
    return receipt;
    
  }
  
  @Override
  public String[] toArrayString() {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String[] array = {"" + this.getIdNumber(), this.getName(), this.getSex(), 
        df.format(this.getDateOfBirth()), this.getAddress(), this.getPhoneNumber(),
        "" + this.getCoefficientsSalary(), "Salesman"};
    return array;
  }
}
