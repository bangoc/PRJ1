package model.product;

import model.employee.Importer;
import model.market.Supplier;

public class ImportItem {
  private Product product;
  private int importPrice;
  private int quantity;
  private Supplier supplier;
  private Importer importer;
  
  public ImportItem(Product product, int quantity, int price, Supplier supplier, Importer importer) {
      this.product = product;
      this.importPrice = price;
      this.quantity = quantity;
      this.supplier = supplier;
      this.importer = importer;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getImportPrice() {
    return importPrice;
  }

  public void setImportPrice(int importPrice) {
    this.importPrice = importPrice;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }
  
  
}
