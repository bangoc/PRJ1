package model.product;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
  private int productId;
  private String name;
  private int price;
  private String producer;
  private Date produceTime;
  private Date expireTime;
  
  public Product() {
    
  }

    public Product(String name, int price, String producer, Date produceTime, Date expireTime) {
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.produceTime = produceTime;
        this.expireTime = expireTime;
    }
  
  

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
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
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String[] array = {"" + this.productId, this.name, "" + this.price, this.producer, 
        df.format(this.produceTime), df.format(this.expireTime)};
    return array;
  }
  
}

