package mdl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.ConnectDatabase;

public class Loader {
  public static ArrayList<Employee> loadEmployee() {
    
    return null;
  }
  
  /**
   * Method loads list of products from database.
   * @return ArrayList that contains all product
   * @throws SQLException thrown when SQLException occurred
   * @throws ParseException thrown when ParseException occurred
   */
  
  public static ArrayList<Product> loadProduct() throws SQLException, ParseException {
    String sql = "select * from goods_tb";
    ConnectDatabase connect = new ConnectDatabase();
    ResultSet result = connect.getStatement().executeQuery(sql);
    ArrayList<Product> productList = new ArrayList<>();
    Product product;
    DateFormat df = new SimpleDateFormat("dd/mm/yyyy");

    while (result.next()) {
      product = new Product();
      product.setIdNumber(result.getInt(1));
      product.setName(result.getString(2));
      product.setPrice(result.getInt(3));
      product.setProducer(result.getString(4));
      product.setProduceTime(df.parse(result.getString(5)));
      product.setExpireTime(df.parse(result.getString(6)));
      productList.add(product);
    }
    return productList;
  }
  
  public static ArrayList<ImportReceipt> loadImportReceipt() {
    return null;
  }
  
  public static ArrayList<ExportReceipt> loadExportReceipt() {
    return null;
  }
  
  /**
   * Method loads list of suppliers of supermarket from database.
   * @return ArrayList that contains all supplier
   * @throws SQLException thrown when exception occurred
   */
  
  public static ArrayList<Supplier> loadSupplier() throws SQLException {
    String sql = "select * from nha_cung_cap_tb";
    ConnectDatabase connect = new ConnectDatabase();
    ResultSet result = connect.getStatement().executeQuery(sql);
    ArrayList<Supplier> supplierList = new ArrayList<>();
    Supplier supplier;
    while (result.next()) {
      supplier = new Supplier();
      supplier.setIdNumber(result.getInt(1));
      supplier.setName(result.getString(2));
      supplier.setAddress(result.getString(3));
      supplier.setEmail(result.getString(4));
      supplier.setPhoneNumber(result.getString(5));
      supplierList.add(supplier);
    }
    return supplierList;
  }
  
  public static ArrayList<WorkHistory> loadWorkHistory(Employee employee) {
    return null;
  }
  
  public static SuperMarket loadSuperMarket() {
    return null;
  }
  
  /**
   * Method loads list of costsIncurred from database.
   * @return ArrayList that contains all costs incurred
   * @throws SQLException thrown when having sqlException
   * @throws ParseException thrown when having parseException
   */
  
  public static ArrayList<CostsIncurred> loadCostsIncurred() throws SQLException, ParseException {
    String sql = "select * from costs_incurred";
    ConnectDatabase connect = new ConnectDatabase();
    ResultSet result = connect.getStatement().executeQuery(sql);
    ArrayList<CostsIncurred> costsList = new ArrayList<>();
    CostsIncurred costs;
    DateFormat df = new SimpleDateFormat("dd/mm/yyyy");

    while (result.next()) {
      costs = new CostsIncurred();
      costs.setIdNumber(result.getInt(1));
      costs.setName(result.getString(2));
      costs.setTotal(result.getInt(3));
      costs.setTime(df.parse(result.getString(4)));  
      costsList.add(costs);
    }
    return costsList;
  }
}
