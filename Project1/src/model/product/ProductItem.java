/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.product;

/**
 *
 * @author leo
 */
public class ProductItem {
    private Product product;
    private int importerId;
    private int supplierId;
    private int importQuantity;
    private int soldQuantity;
    private int importPrice;

    public ProductItem(Product product,  int soldQuantity, int importerId, int supplierId, int importQuantity, int importPrice) {
        this.product = product;
        this.importerId = importerId;
        this.supplierId = supplierId;
        this.importQuantity = importQuantity;
        this.soldQuantity = soldQuantity;
        this.importPrice = importPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getImporterId() {
        return importerId;
    }

    public void setImporterId(int importerId) {
        this.importerId = importerId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getImportQuantity() {
        return importQuantity;
    }

    public void setImportQuantity(int importQuantity) {
        this.importQuantity = importQuantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public int getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(int importPrice) {
        this.importPrice = importPrice;
    }
    
    
}
