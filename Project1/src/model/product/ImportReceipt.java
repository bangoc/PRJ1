package model.product;

import java.util.ArrayList;
import java.util.Date;
import model.MyUtils.MyDate;



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

    public ImportReceipt() {
        
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
    
    @Override
  public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("Export Receipt Detail");
      sb.append(System.lineSeparator());
      
      sb.append("Date created : ");
      sb.append(MyDate.formatDate(this.date));
      sb.append(System.lineSeparator());
      
      sb.append("Creator : ");
      sb.append(this.items.get(0).getImporter().getName());
      sb.append(System.lineSeparator());
      
      sb.append("ProductItem List : ");
      sb.append(System.lineSeparator());
      
      for (ImportItem it : this.items) {
          sb.append("Product ID : ");
          sb.append("" + it.getProduct().getProductId());
          sb.append("___");
          sb.append("Product Name : ");
          sb.append(it.getProduct().getName());
          sb.append("___");
          sb.append("Quantity : ");
          sb.append("" + it.getQuantity());
          sb.append("___");
          sb.append("Price : ");
          sb.append("" + it.getImportPrice());

          sb.append(System.lineSeparator());
      }
      sb.append("Total : " + this.total);
      return sb.toString();
  }

  

  
 
}
