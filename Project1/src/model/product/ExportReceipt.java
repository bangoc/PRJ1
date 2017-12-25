package model.product;

import java.util.ArrayList;
import java.util.Date;
import model.MyUtils.MyDate;


public class ExportReceipt {
  private int code;
  private ArrayList<ExportItem> items;
  private Date time;
  private int total;
  
  public ExportReceipt() {
    
  }

    public ExportReceipt(ArrayList<ExportItem> items, int total) {
        this.items = items;
        this.time = new Date();
        this.total = total;
    }

  
  
  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public ArrayList<ExportItem> getItems() {
    return items;
  }

  public void setItems(ArrayList<ExportItem> items) {
    this.items = items;
  }

  

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
  
  @Override
  public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("Export Receipt Detail");
      sb.append(System.lineSeparator());
      
      sb.append("Date created : ");
      sb.append(MyDate.formatDate(this.time));
      sb.append(System.lineSeparator());
      
      sb.append("Creator : ");
      sb.append(this.items.get(0).getSalesman().getName());
      sb.append(System.lineSeparator());
      
      sb.append("ProductItem List : ");
      sb.append(System.lineSeparator());
      
      for (ExportItem it : this.items) {
          sb.append("Product ID : ");
          sb.append("" + it.getProduct().getProductId());
          sb.append("___");
          sb.append("Product Name : ");
          sb.append(it.getProduct().getName());
          sb.append("___");
          sb.append("Quantity : ");
          sb.append("" + it.getAmount());
          sb.append("___");
          sb.append("Price : ");
          sb.append("" + it.getPrice());
          sb.append(System.lineSeparator());
      }
      sb.append("Total : " + this.total);
      return sb.toString();
  }

  
}
