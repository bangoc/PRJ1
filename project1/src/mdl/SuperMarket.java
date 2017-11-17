package mdl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SuperMarket {
  private String name;
  private ArrayList<Employee> employeeList;
  private ArrayList<Product> productList;
  private ArrayList<ImportReceipt> importReceiptList;
  private ArrayList<ExportReceipt> exportReceiptList;
  private ArrayList<Supplier> supplierList;
  private ArrayList<CostsIncurred> costsIncurredList;

  public SuperMarket() {
    
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<Employee> getEmployeeList() {
    return employeeList;
  }

  public void setEmployeeList(ArrayList<Employee> employeeList) {
    this.employeeList = employeeList;
  }

  public ArrayList<Product> getProductList() {
    return productList;
  }

  public void setProductList(ArrayList<Product> productList) {
    this.productList = productList;
  }

  public ArrayList<ImportReceipt> getImportReceiptList() {
    return importReceiptList;
  }

  public void setImportReceiptList(ArrayList<ImportReceipt> importReceiptList) {
    this.importReceiptList = importReceiptList;
  }

  public ArrayList<ExportReceipt> getExportReceiptList() {
    return exportReceiptList;
  }

  public void setExportReceiptList(ArrayList<ExportReceipt> exportReceiptList) {
    this.exportReceiptList = exportReceiptList;
  }

  public ArrayList<Supplier> getSupplierList() {
    return supplierList;
  }

  public void setSupplierList(ArrayList<Supplier> supplierList) {
    this.supplierList = supplierList;
  }

  public ArrayList<CostsIncurred> getCostsIncurredList() {
    return costsIncurredList;
  }

  public void setCostsIncurredList(ArrayList<CostsIncurred> costsIncurredList) {
    this.costsIncurredList = costsIncurredList;
  }

  
  /**
   * Method's invoked when adding a new employee to EmployeeList.
   * @param nhanVien Employee's object
   */
  
  public void addEmployee(Employee nhanVien) {
    this.employeeList.add(nhanVien);
  }
  
  /**
   * sum summary salary of all employee of supermarket.
   * @return summary salary
   */
  
  public int countSummarySalary() {
    int sum = 0;
    for (Employee employee : this.employeeList) {
      sum += employee.countSalary();
    }
    return sum;
  }
  
  /**
   * add new product to productList.
   * @param product Product's object
   */
  
  public void addProduct(Product product) {
    this.productList.add(product);
  }
  
  /**
   * add new ImportReceipt's object.
   * @param receipt ImportReceipt's object
   */
  public void addImportReceipt(ImportReceipt receipt) {
    this.importReceiptList.add(receipt);
  }
  
  /**
   * add new ExportReceipt's object.
   * @param receipt ExportReceipt's object
   */
  
  public void addExportReceipt(ExportReceipt receipt) {
    this.exportReceiptList.add(receipt);
  }
  
  /**
   * Print payroll.
   * @param url path of file 
   * @throws IOException thrown when having exception
   */
  
  public void printPayRoll(String url) throws IOException {
    FileWriter file = new FileWriter(url);
    BufferedWriter writer = new BufferedWriter(file);
    for (Employee employee : this.employeeList) {
      writer.write(employee.getIdNumber());
      writer.write(employee.getName());
      writer.write(employee.countSalary());
      writer.newLine();
    }
    writer.close();
    
  }
}
