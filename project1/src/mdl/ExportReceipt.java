package mdl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExportReceipt {
  private int code;
  private SalesPerson salesPerson;
  private LinkedHashMap<Product, Integer[]> listItem;
  private Date time;
  
  public ExportReceipt() {
    
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public SalesPerson getSalesPerson() {
    return salesPerson;
  }

  public void setSalesPerson(SalesPerson salesPerson) {
    this.salesPerson = salesPerson;
  }

  public LinkedHashMap<Product, Integer[]> getListItem() {
    return listItem;
  }

  public void setListItem(LinkedHashMap<Product, Integer[]> listItem) {
    this.listItem = listItem;
  }


  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
  
  public boolean containsProductId(Product pro) {
    boolean check = false;
    Product product;
    for (Map.Entry<Product, Integer[]> pair : this.listItem.entrySet()) {
      product = pair.getKey();
      if (product.getIdNumber() == pro.getIdNumber()) {
        check = true;
        break;
      }
    }
    return check;
  }

  
}
