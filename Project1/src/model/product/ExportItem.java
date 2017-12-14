package model.product;

import model.employee.Salesman;

public class ExportItem {
  private Product product;
  private int amount;
  private int price;
  private Salesman salesman;
  
  public ExportItem(Product product, int amount, Salesman salesman) {
    this.product = product;
    this.amount = amount;
    countSaleOffPrice();
    this.salesman = salesman;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Salesman getSalesman() {
    return salesman;
  }

  public void setSalesman(Salesman salesman) {
    this.salesman = salesman;
  }
  
  private void countSaleOffPrice() {
      this.price = this.product.getPrice() * (1 - this.product.getSaleOff() / 100);
      
  }
}
