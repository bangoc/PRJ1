package mdl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

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
    
    int total = 0;
    for (Map.Entry<Product, Integer[]> pair : listItem.entrySet()) {
      total += pair.getValue()[0] * pair.getValue()[1];
    }
    receipt.setTotal(total);
    return receipt;
    
  }
  
  @Override
  public String[] toArrayString() {
    String[] array = super.toArrayString();
    array[array.length - 1] = "Sale Staff";
    return array;
  }
}
