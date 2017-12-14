package model.product;

import java.util.ArrayList;
import java.util.Date;


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
  
 

  
}
