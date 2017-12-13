package model.product;

import java.util.ArrayList;
import java.util.Date;



public class ImportReceipt {
    private int id;
    private ArrayList<ImportItem> items;
    private long total;
    private Date date;
    
    public ImportReceipt(ArrayList<ImportItem> items, long total) {
        this.items = items;
        this.total = total;
        this.date = new Date();
    }

    public ArrayList<ImportItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<ImportItem> items) {
        this.items = items;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
 
  

  
 
}
