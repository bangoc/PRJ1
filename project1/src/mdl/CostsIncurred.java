package mdl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CostsIncurred {
  private String name;
  private int total;
  private Date time;
  
  public CostsIncurred() {
    
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int tongTien) {
    this.total = tongTien;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }
  
  /**
   * Method convert attributes of an instance of CostsIncurred Class to String[].
   * @return String[]
   */
  
  public String[] toArrayString() {
    DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
    String[] array = {this.name, "" + this.total, df.format(this.time)};
    return array;
  }
  
  
}
