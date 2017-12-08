package model.market;

import java.util.Date;

public class Cost {

  private TypeCost costName;
  private int total;
  private Date date;
  
  public Cost(TypeCost costName, Date date, int total) {
    this.costName = costName;
    this.date = date;
    this.total = total;
  }
  
  public TypeCost getCostName() {
    return this.costName;
  }
  
  public void setCostName() {
    
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int tongTien) {
    this.total = tongTien;
  }

  public Date getDate() {
    return date;
  }

  public void setTime(Date date) {
    this.date = date;
  }
  
}
