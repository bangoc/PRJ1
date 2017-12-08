package model.product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import model.employee.Salesman;

public class ExportReceipt {
  private int code;
  private Salesman salesPerson;
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

  public Salesman getSalesPerson() {
    return salesPerson;
  }

  public void setSalesPerson(Salesman salesPerson) {
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
      if (product.getProductId() == pro.getProductId()) {
        check = true;
        break;
      }
    }
    return check;
  }

  public void writeToFile(String urlFolder) throws IOException {
    String urlFile = urlFolder + "/" + this.code + "export.txt";
    FileWriter writer = new FileWriter(urlFile);
    BufferedWriter bwriter = new BufferedWriter(writer);
    writer.write("Receipt ID : " + this.code);
    writer.write(System.lineSeparator());
    writer.write("Employee Name : " + this.getSalesPerson().getName());
    writer.write(System.lineSeparator());
    writer.write("Date : ");
    writer.write(this.time.toString());
    writer.write(System.lineSeparator());
    writer.write("Products : ");
    writer.write(System.lineSeparator());
    Product product;
    for (Map.Entry<Product, Integer[]> pair : this.listItem.entrySet()) {
      product = pair.getKey();
      writer.write("" + product.getProductId());
      writer.write("++++");
      writer.write(product.getName());
      writer.write("++++");
      writer.write("" + pair.getValue()[0]);
      writer.write("++++");
      writer.write("" + pair.getValue()[1]);
      writer.write(System.lineSeparator());
    }
    bwriter.close();
  }
}
