package model.product;

import model.market.Supplier;

public class ImportItem {
  private Product product;
  private int price;
  private int amount;
  private Supplier supplier;
  
  public ImportItem(Product product, int quantity, int price, Supplier supplier) {
      this.product = product;
      this.price = price;
      this.amount = quantity;
      this.supplier = supplier;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }
  
  
}
