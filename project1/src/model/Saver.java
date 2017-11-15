package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import mdl.CostsIncurred;
import mdl.Employee;
import mdl.ExportReceipt;
import mdl.ImportReceipt;
import mdl.Manager;
import mdl.Product;
import mdl.SalesPerson;
import mdl.SuperMarket;
import mdl.Supplier;
import mdl.WorkHistory;

public class Saver {
  
  /**
   * Method saves data of an instance of Employee into database.
   * @param employee the instance of Employee
   * @throws SQLException  if a database access error occurs, this method is called on 
   *      a closed Statement, the given SQL statement produces a ResultSet object, the method 
   *      is called on a PreparedStatement or CallableStatement
   * @throws ClassNotFoundException 
   * @throws IOException 
   */
  
  public static void saveEmployee(Employee employee, String link) throws SQLException, ClassNotFoundException, IOException {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    ConnectDatabase connect = new ConnectDatabase();

                  
    PreparedStatement ps;
    ps = connect.getConnect().prepareStatement("insert into employee values(null,?,?,?,?,?,?,?)", 
        Statement.RETURN_GENERATED_KEYS);  
   
    ps.setString(1, employee.getName());
    ps.setString(2, employee.getSex());
    ps.setString(3, df.format(employee.getDateOfBirth()));
    ps.setString(4, employee.getAddress());
    ps.setString(5, employee.getPhoneNumber());
    ps.setInt(6, employee.getCoefficientsSalary());
      
    FileInputStream fin=new FileInputStream(link);  
    ps.setBinaryStream(7,fin,fin.available());  
    
    ps.executeUpdate();   
    
    ResultSet rs = ps.getGeneratedKeys();
    rs.next();
    int id = rs.getInt(1);
    employee.setIdNumber(id);
    PreparedStatement ps1;
    if (employee instanceof Manager) {
      
      ps1 = connect.getConnect().prepareStatement("insert into employee_manager values(?, ?)");
      ps1.setInt(1, id);
      ps1.setInt(2, ((Manager) employee).getCommission());
      ps1.executeUpdate();
      
    } else if (employee instanceof SalesPerson) {
      
      PreparedStatement ps2 = connect.getConnect().prepareStatement("insert into employee_salesman values(?, ?)");
      ps2.setInt(1, id);
      ps2.setInt(2, ((SalesPerson) employee).getSubsidy());
      ps2.executeUpdate();
    }
    connect.getConnect().close();
  }
  
  /**
   * Method saves data of an instance of Product into database.
   * @param product the instance of Product
   * @return id of product after saved into database
   * @throws SQLException  if a database access error occurs, this method is called on 
   *      a closed Statement, the given SQL statement produces a ResultSet object, the method 
   *      is called on a PreparedStatement or CallableStatement
   */
  
  private static int saveProduct(Product product) throws SQLException {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String sql = "insert into product (id, name, price, producer, produce_date, expire_date) "
        + "values (null, '" + product.getName() + "', " + product.getPrice() + ", '" 
        + product.getProducer() + "', '" + df.format(product.getProduceTime()) + "', '"
        + df.format(product.getExpireTime()) + "')";
    ConnectDatabase connect = new ConnectDatabase();
    connect.getStatement().executeUpdate(sql);
    int id = 0;
    String sql1 = "select max(id) from product";
    ResultSet result = connect.getStatement().executeQuery(sql1);
    while (result.next()) {
      id = result.getInt(1);
    }
    return id;
  }
  
  /**
   * Method saves data of an instance of Supplier into database.
   * @param supplier the instance of Supplier
   * @throws SQLException  if a database access error occurs, this method is called on 
   *      a closed Statement, the given SQL statement produces a ResultSet object, the method 
   *      is called on a PreparedStatement or CallableStatement
   */
  
  public static void saveSupplier(Supplier supplier) throws SQLException {
    String sql = "insert into supplier (id, name, address, mail, phone_no) values (null, '" 
        + supplier.getName() + "', '" + supplier.getAddress() + "', '" + supplier.getEmail()
        + "', '" + supplier.getPhoneNumber() + "')";
    ConnectDatabase connect = new ConnectDatabase();
    connect.getStatement().executeUpdate(sql);
  }
  
  /**
   * Method save data of an instance of CostsIncurred into database.
   * @param costsIncurred the instance of CostsIncurred
   * @throws SQLException  if a database access error occurs, this method is called on 
   *      a closed Statement, the given SQL statement produces a ResultSet object, the method 
   *      is called on a PreparedStatement or CallableStatement
   */
  
  public static void saveCostsIncurred(CostsIncurred costsIncurred) throws SQLException {
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    String sql = "insert into costs_incurred (id, name, total, paid_date) values (null, '" 
        + costsIncurred.getName() + "', " + costsIncurred.getTotal() + ", '" 
        + df.format(costsIncurred.getTime()) + "')";
    System.out.println(sql);
    new ConnectDatabase().getStatement().executeUpdate(sql);
  }
  
  private static int saveDataIntoReceiptSalesman(int idSalesman, Date date)
      throws SQLException {
    int idReceipt = 0;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String sql = "insert into receipt_salesman (id_receipt, id_salesman, date) "
        + "values (null, " + idSalesman + ", '" + df.format(date) +  "')";
    ConnectDatabase connect = new ConnectDatabase();
    connect.getStatement().executeUpdate(sql);
    
    String sql1 = "select max(id_receipt) from receipt_salesman";
    ResultSet result = connect.getStatement().executeQuery(sql1);
    while (result.next()) {
      idReceipt = result.getInt(1);
    }
    connect.getStatement().close();
    return idReceipt;
  }
  
  private static void saveDataIntoExportReceipt(int idReceipt, int idProduct, int amount, int price)
      throws SQLException {
    String sql = "insert into export_receipt (id_receipt, id_product, amount, price) "
        + "values (" + idReceipt + ", " + idProduct + ", " + amount + ", " + price + ")";
    new ConnectDatabase().getStatement().executeUpdate(sql);
  }
  
  /**
   * Method save data of a instance of ExportReceipt into database.
   * @param receipt the instance of ExportReceipt
   * @throws SQLException if a database access error occurs, this method is called on 
   *      a closed Statement, the given SQL statement produces a ResultSet object, the method 
   *      is called on a PreparedStatement or CallableStatement
   */
  
  public static void saveExportReceipt(ExportReceipt receipt) throws SQLException {
    int idSalesman = receipt.getSalesPerson().getIdNumber();
    int idReceipt = saveDataIntoReceiptSalesman(idSalesman, receipt.getTime());
    LinkedHashMap<Product, Integer[]> map = receipt.getListItem();
    Product product;
    Integer[] i;
    for (Map.Entry<Product, Integer[]> pair : map.entrySet()) {
      product = pair.getKey();
      i = pair.getValue();
      saveDataIntoExportReceipt(idReceipt, product.getIdNumber(), i[0], i[1]);
    }
    receipt.setCode(idReceipt);
  }
  
  private static void saveDataIntoImportReceipt(int idReceipt, int idProduct, int amount, int price)
      throws SQLException {
    String sql = "insert into import_receipt (id_receipt, id_product, amount, price) "
        + "values (" + idReceipt + ", " + idProduct + ", " + amount + ", " + price + ")";
    new ConnectDatabase().getStatement().executeUpdate(sql);
  }
  
  private static int saveDataIntoReceiptManagerSupplier(int idManager, int idSupplier, Date date)
      throws SQLException {
    int idReceipt = 0;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    String sql = "insert into receipt_manager_supplier (id_receipt, id_manager, id_supplier, date) "
        + "values (null, " + idManager + ", " + idSupplier + ", '" + df.format(date) +  "')";
    ConnectDatabase connect = new ConnectDatabase();
    connect.getStatement().executeUpdate(sql);
    
    String sql1 = "select max(id_receipt) from receipt_manager_supplier";
    ResultSet result = connect.getStatement().executeQuery(sql1);
    while (result.next()) {
      idReceipt = result.getInt(1);
    }
    return idReceipt;
  }
  
  /**
   * Method saves data of a instance of ImportReceipt into database.
   * @param receipt the instance of ImportReceipt
   * @throws SQLException if a database access error occurs, this method is called on 
   *      a closed Statement, the given SQL statement produces a ResultSet object, the method 
   *      is called on a PreparedStatement or CallableStatement
   */
  
  public static void saveImportReceipt(ImportReceipt receipt) throws SQLException {
    int idManager = receipt.getImporter().getIdNumber();
    int idSupplier = receipt.getSupplier().getIdNumber();
    int idReceipt = saveDataIntoReceiptManagerSupplier(idManager, idSupplier, receipt.getTime());
    LinkedHashMap<Product, Integer[]> map = receipt.getListItem();
    Product product;
    Integer[] i;
    int idProduct = 0;
    for (Map.Entry<Product, Integer[]> pair : map.entrySet()) {
      product = pair.getKey();
      i = pair.getValue();
      idProduct = saveProduct(product);
      saveDataIntoImportReceipt(idReceipt, idProduct, i[0], i[1]);
    }
    receipt.setCode(idReceipt);
  }
 
  /**
   * Method save data of an instance of WorkHistory of Employee into database.
   * @param employee the instance of Employee
   * @throws SQLException  if a database access error occurs, this method is called on 
   *      a closed Statement, the given SQL statement produces a ResultSet object, the method 
   *      is called on a PreparedStatement or CallableStatement
   */
  
  public static void saveWorkHistory(Employee employee) throws SQLException {
    ArrayList<WorkHistory> list = employee.getWorkHistory();
    WorkHistory workHistory = list.get(list.size());
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    String sql = "insert into work_history (id_employee, paid_date, salary) values (" 
        + employee.getIdNumber() + ", '" + df.format(workHistory.getPaidTime()) 
        + "', " + workHistory.getSalary() + ")";
    new ConnectDatabase().getStatement().executeUpdate(sql);
  }
  
  public static void saveNewObject(SuperMarket market) throws SQLException {
    String sql = "insert into market (name) values ('" + market.getName() + "')";
    new ConnectDatabase().getStatement().executeUpdate(sql);
  }
  
  public static void saveLink(String setting, int id) throws SQLException {
    String sql = "update setting set setting = '" + setting + "' where id = " + id;
    new ConnectDatabase().getStatement().executeUpdate(sql);
  }
}
