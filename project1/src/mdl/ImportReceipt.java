package mdl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ImportReceipt {
  private int code;
  private Manager importer;
  private Supplier supplier;
  private LinkedHashMap<Product, Integer[]> listItem;
  private Date time;
  
  public ImportReceipt() {
    
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public Manager getImporter() {
    return importer;
  }

  public void setImporter(Manager importer) {
    this.importer = importer;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
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
