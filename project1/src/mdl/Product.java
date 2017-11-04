package mdl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
  private int idNumber;
  private String name;
  private int price;
  private String producer;
  private Date produceTime;
  private Date expireTime;
  
  public Product() {
    
  }

  public int getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(int idNumber) {
    this.idNumber = idNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  public Date getProduceTime() {
    return produceTime;
  }

  public void setProduceTime(Date produceTime) {
    this.produceTime = produceTime;
  }

  public Date getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(Date expireTime) {
    this.expireTime = expireTime;
  }
  
  /**
   * Method convert attributes of an instance of Product Class to String[].
   * @return String[]
   */
  
  public String[] toArrayString() {
    DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
    String[] array = {"" + this.idNumber, this.name, "" + this.price, this.producer, 
        df.format(this.produceTime), df.format(this.expireTime)};
    return array;
  }
  
}

