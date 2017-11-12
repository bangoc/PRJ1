package mdl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class Manager extends Employee {
  private int commission;
  
  public Manager() {
    
  }
  
  
  
  public int getCommission() {
    return commission;
  }



  public void setCommission(int commission) {
    this.commission = commission;
  }



  public int countSalary() {
    return super.countSalary() + this.commission;
  }
  
  /**
   * This method creates a instance of ImportReceipt class.
   * @param supplier instance of Supplier that supplies products
   * @param listItem map contains :
   *      key is a product 
   *      value is Integer[] with amount of product and price of product
   * @return instance of ImportReceipt class
   */
  
  public ImportReceipt makeImportReceipt(Supplier supplier, LinkedHashMap<Product,
      Integer[]> listItem) {
    ImportReceipt receipt = new ImportReceipt();
    
    receipt.setSupplier(supplier);
    receipt.setListItem(listItem);
    receipt.setImporter(this);
    receipt.setTime(new Date());
    return receipt;
    
  }
  
  @Override
  public String[] toArrayString() {
    ResourceBundle b = ResourceBundle.getBundle("view.Label");

    String[] array = super.toArrayString();
    array[7] = b.getString("Manager");
    return array;
  }

}
