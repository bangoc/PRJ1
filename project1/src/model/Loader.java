package model;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.swing.ImageIcon;

import mdl.CostsIncurred;
import mdl.Employee;
import mdl.ExportReceipt;
import mdl.ImportReceipt;
import mdl.Manager;
import mdl.Product;
import mdl.SalesPerson;
import mdl.Supplier;
import mdl.WorkHistory;
import model.ConnectDatabase;

public class Loader {
  
  /**
   * Method loads Employee's object by id.
   * @param idNumber employee's id
   * @return Employee
   * @throws SQLException SQLException
   * @throws ParseException ParseException
   */
  
  public static Employee loadEmployeeById(int idNumber) throws SQLException, ParseException {
   
    ConnectDatabase connect = new ConnectDatabase();
    PreparedStatement ps = connect.getConnect().prepareStatement("select * from employee where id = ?");
    ps.setInt(1, idNumber);
    ResultSet result = ps.executeQuery();
    Employee employee = new Employee();
    
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    while (result.next()) {
      employee.setIdNumber(result.getInt(1));
      employee.setName(result.getString(2));
      employee.setSex(result.getString(3));
      employee.setDateOfBirth(df.parse(result.getString(4)));
      employee.setAddress(result.getString(5));
      employee.setPhoneNumber(result.getString(6));
      employee.setCoefficientsSalary(result.getInt(7));
      Blob b=result.getBlob(8);
      byte barr[]=b.getBytes(1,(int)b.length());
      employee.setImage(new ImageIcon(barr));
    }
    ArrayList<WorkHistory> workHistoryList = loadWorkHistory(employee);
    employee.setWorkHistory(workHistoryList);
    return employee;
  }
    
  /**
   * Method loads list of employee from database.
   * @return ArrayList
   * @throws SQLException SQLException
   * @throws ParseException ParseException
   */
  
  public static ArrayList<Employee> loadEmployee() throws SQLException, ParseException {
  
    String sql = "select id from employee where id not in (select em.id "
        + "from employee as em, employee_manager as ma where em.id = ma.id_manager) "
        + "and id not in (select id from employee as em, employee_salesman as ma "
        + "where em.id = ma.id_salesman)";
    ResultSet result = new ConnectDatabase().getConnect().prepareStatement(sql).executeQuery();
    ArrayList<Employee> employeeList = new ArrayList<>();
    Employee employee;
    while (result.next()) {
      employee = loadEmployeeById(result.getInt(1));
      employeeList.add(employee);
    }
    return employeeList;
  }
  
  /**
   * Method loads Manager's object by id.
   * @param idManager manager's id
   * @return Manager
   * @throws SQLException SQLException
   * @throws ParseException ParseException
   */
  
  public static Manager loadManagerById(int idManager) throws SQLException, ParseException {
    String sql = "select em.*, ma.commission from employee as em, employee_manager"
        + " as ma where em.id = ma.id_manager and ma.id_manager = ?";
    ConnectDatabase connect = new ConnectDatabase();
    PreparedStatement ps = connect.getConnect().prepareStatement(sql);
    ps.setInt(1, idManager);
    ResultSet result = ps.executeQuery();
  
    Manager manager = new Manager();
 ;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    while (result.next()) {
      manager.setIdNumber(result.getInt(1));
      manager.setName(result.getString(2));
      manager.setSex(result.getString(3));
      manager.setDateOfBirth(df.parse(result.getString(4)));
      manager.setAddress(result.getString(5));
      manager.setPhoneNumber(result.getString(6));
      manager.setCoefficientsSalary(result.getInt(7));
      Blob b=result.getBlob(8);
      byte barr[]=b.getBytes(1,(int)b.length());
      manager.setImage(new ImageIcon(barr));
      manager.setCommission(result.getInt(9));
      
    }
    ArrayList<WorkHistory> workHistoryList = loadWorkHistory(manager);
    manager.setWorkHistory(workHistoryList);
    return manager;
  }
  
  /**
   * Method loads list of manager from database.
   * @return ArrayList
   * @throws SQLException SQLException
   * @throws ParseException ParseException
   */
  
  public static ArrayList<Manager> loadManager() throws SQLException, ParseException {
    String sql = "select em.*, ma.commission from employee as em, employee_manager"
        + " as ma where em.id = ma.id_manager";
    ConnectDatabase connect = new ConnectDatabase();
    ResultSet result = connect.getStatement().executeQuery(sql);
    ArrayList<Manager> managerList = new ArrayList<>();
    Manager manager;
    while (result.next()) {
      manager = loadManagerById(result.getInt(1));
      managerList.add(manager);
    }
    return managerList;
  
  }
  
  /**
   * Method loads SalesMan's object by id.
   * @param idNumber salesman's id
   * @return SalesPerson
   * @throws SQLException SQLException
   * @throws ParseException ParseException
   */
  
  public static SalesPerson loadSalesPersonById(int idNumber) throws SQLException, ParseException {
    String sql = "select em.*, sale.subsidy from employee as em, employee_salesman "
        + "as sale where em.id = sale.id_salesman and sale.id_salesman = ?";
    ConnectDatabase connect = new ConnectDatabase();
    PreparedStatement ps = connect.getConnect().prepareStatement(sql);
    ps.setInt(1, idNumber);
    ResultSet result = ps.executeQuery();
    SalesPerson salesman = new SalesPerson();
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    while (result.next()) {
      salesman.setIdNumber(result.getInt(1));
      salesman.setName(result.getString(2));
      salesman.setSex(result.getString(3));
      salesman.setDateOfBirth(df.parse(result.getString(4)));
      salesman.setAddress(result.getString(5));
      salesman.setPhoneNumber(result.getString(6));
      salesman.setCoefficientsSalary(result.getInt(7));
      Blob b=result.getBlob(8);
      byte barr[]=b.getBytes(1,(int)b.length());
      salesman.setImage(new ImageIcon(barr));
      salesman.setSubsidy(result.getInt(9));
      
    }
    ArrayList<WorkHistory> workHistoryList = loadWorkHistory(salesman);
    salesman.setWorkHistory(workHistoryList);
    return salesman;

  }
  
  /**
   * Method loads list of salesman from database.
   * @return ArrayList
   * @throws SQLException SQLException
   * @throws ParseException ParseException
   */
  
  public static ArrayList<SalesPerson> loadSalesPerson() throws SQLException, ParseException {
    String sql = "select em.id from employee as em, employee_salesman "
        + "as sale where em.id = sale.id_salesman";
    ConnectDatabase connect = new ConnectDatabase();
    ResultSet result = connect.getStatement().executeQuery(sql);
    ArrayList<SalesPerson> salesManList = new ArrayList<>();
    SalesPerson salesman;    
    while (result.next()) {
      salesman = loadSalesPersonById(result.getInt(1));
      salesManList.add(salesman);
      
    }
    return salesManList;

  }
  
  /**
   * Method loads Product's object by id.
   * @param idNumber product's id
   * @return Product
   * @throws SQLException SQLException
   * @throws ParseException ParseException
   */
  
  public static Product loadProductById(int idNumber) throws SQLException, ParseException {
    String sql = "select * from product where id = " + idNumber;
    ConnectDatabase connect = new ConnectDatabase();
    ResultSet result = connect.getStatement().executeQuery(sql);
    Product product = new Product();
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    while (result.next()) {
      product.setIdNumber(result.getInt(1));
      product.setName(result.getString(2));
      product.setPrice(result.getInt(3));
      product.setProducer(result.getString(4));
      product.setProduceTime(df.parse(result.getString(5)));
      product.setExpireTime(df.parse(result.getString(6)));
    }
    return product ;
  }
  
  /**
   * Method loads list of products from database.
   * @return ArrayList that contains all product
   * @throws SQLException thrown when SQLException occurred
   * @throws ParseException thrown when ParseException occurred
   */
  
  public static ArrayList<Product> loadProduct() throws SQLException, ParseException {
    String sql = "select id from product";
    ConnectDatabase connect = new ConnectDatabase();
    ResultSet result = connect.getStatement().executeQuery(sql);
    ArrayList<Product> productList = new ArrayList<>();
    Product product;
    while (result.next()) {
      product = loadProductById(result.getInt(1));
      productList.add(product);
    }
    return productList;
  }
  
  /**
   * Method loads Supplier's object by id.
   * @param idNumber supplier's id
   * @return Supplier
   * @throws SQLException SQLException
   * @throws ParseException ParseException
   */
 
  public static Supplier loadSupplierById(int idNumber) throws SQLException {
    String sql = "select * from supplier where id = " + idNumber;
    ConnectDatabase connect = new ConnectDatabase();
    ResultSet result = connect.getStatement().executeQuery(sql);
    Supplier supplier = new Supplier();
    while (result.next()) {
      supplier.setIdNumber(result.getInt(1));
      supplier.setName(result.getString(2));
      supplier.setAddress(result.getString(3));
      supplier.setEmail(result.getString(4));
      supplier.setPhoneNumber(result.getString(5));
    }
    return supplier;
  }
  
  /**
   * Method loads list of suppliers of supermarket from database.
   * @return ArrayList that contains all supplier
   * @throws SQLException thrown when exception occurred
   */
  
  public static ArrayList<Supplier> loadSupplier() throws SQLException {
    String sql = "select id from supplier";
    ConnectDatabase connect = new ConnectDatabase();
    ResultSet result = connect.getStatement().executeQuery(sql);
    ArrayList<Supplier> supplierList = new ArrayList<>();
    Supplier supplier;
    while (result.next()) {
      supplier = loadSupplierById(result.getInt(1));
      supplierList.add(supplier);
    }
    return supplierList;
  }
  
  /**
   * Method loads list of work history of employee from database.
   * @param employee employee
   * @return ArrayList WorkHistory
   * @throws SQLException SQLException
   * @throws ParseException ParseEXception
   */
  
  private static ArrayList<WorkHistory> loadWorkHistory(Employee employee)
      throws SQLException, ParseException {
    String sql = "select * from work_history where id_employee = " + employee.getIdNumber();
    ConnectDatabase connect = new ConnectDatabase();
    ResultSet result = connect.getStatement().executeQuery(sql);
    ArrayList<WorkHistory> workHistoryList = new ArrayList<>();
    WorkHistory workHistory;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    while (result.next()) {
      workHistory = new WorkHistory();
      workHistory.setPaidTime(df.parse(result.getString(1)));
      workHistory.setSalary(result.getInt(2));
      workHistoryList.add(workHistory);
    }
    return workHistoryList;
  }
  
  /**
   * Method loads SuperMarket's name from database.
   * @return String
   * @throws SQLException SQLException
   */
  
  public static String loadNameSuperMarket() throws SQLException {
    String sql = "select * from market";
    ConnectDatabase connect = new ConnectDatabase();
    ResultSet result = connect.getStatement().executeQuery(sql);
    String name = null;
    while (result.next()) {
      name = result.getString(1);
      
    }
    return name;
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
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

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
  
  /**
   * Method loads ImportReceipt's object by id.
   * @param idNumber receipt's id
   * @return ImportReceipt
   * @throws SQLException SQLException
   * @throws ParseException ParseException
   */
  
  public static ImportReceipt loadImportReceiptById(int idNumber)
      throws SQLException, ParseException {
    int idManager = 0;
    int idSupplier = 0;
    String strDate = "";
    String sql = "select id_manager, id_supplier, date from receipt_manager_supplier "
        + "where id_receipt = " + idNumber;
    ConnectDatabase connect = new ConnectDatabase();
    ResultSet result = connect.getStatement().executeQuery(sql);
    while (result.next()) {
      idManager = result.getInt(1);
      idSupplier = result.getInt(2);
      strDate = result.getString(3);
    }
    Manager manager = loadManagerById(idManager);
    String sql1 = "select id_product, amount, price from import_receipt where id = " + idNumber;
    ResultSet result1 = connect.getStatement().executeQuery(sql1);
    LinkedHashMap<Product, Integer[]> listItem = new LinkedHashMap<>();
    Product product;
    while (result1.next()) {
      product = loadProductById(result1.getInt(1));
      Integer[] array = {result1.getInt(1), result1.getInt(2)};
      listItem.put(product, array);
    }
    ImportReceipt receipt = new ImportReceipt();
    receipt.setCode(idNumber);
    receipt.setImporter(manager);
    Supplier supplier = loadSupplierById(idSupplier);
    receipt.setSupplier(supplier);
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date date = df.parse(strDate);
    receipt.setTime(date);
    receipt.setListItem(listItem);
    return receipt;
  }
  
  /**
   * Method loads list of ImportReceipt's object.
   * @return list of ImportReceipt's object
   * @throws SQLException SQLException
   * @throws ParseException ParseException
   */
  
  public static ArrayList<ImportReceipt> loadImportReceipt() throws SQLException, ParseException {
    String sql = "select id_receipt from receipt_manager_supplier";
    ConnectDatabase connect = new ConnectDatabase();
    ResultSet result = connect.getStatement().executeQuery(sql);
    ArrayList<ImportReceipt> receiptList = new ArrayList<>();
    ImportReceipt receipt;
    while (result.next()) {
      receipt = loadImportReceiptById(result.getInt(1));
      receiptList.add(receipt);
    }
    return receiptList;
  }
  
  /**
   * Method loads ExportReceipt's object by id.
   * @param idNumber receipt's id
   * @return ExportReceipt
   * @throws SQLException SQLException
   * @throws ParseException ParseException
   */
  
  public static ExportReceipt loadExportReceiptById(int idNumber)
      throws SQLException, ParseException {
    int idSalesman = 0;
    String strDate = "";
    String sql = "select id_salesman, date from receipt_salesman "
        + "where id_receipt = " + idNumber;
    ConnectDatabase connect = new ConnectDatabase();
    ResultSet result = connect.getStatement().executeQuery(sql);
    while (result.next()) {
      idSalesman = result.getInt(1);
      strDate = result.getString(2);
    }
    SalesPerson salesman = loadSalesPersonById(idSalesman);
    String sql1 = "select id_product, amount, price from export_receipt where id = " + idNumber;
    ResultSet result1 = connect.getStatement().executeQuery(sql1);
    LinkedHashMap<Product, Integer[]> listItem = new LinkedHashMap<>();
    Product product;
    while (result1.next()) {
      product = loadProductById(result1.getInt(1));
      Integer[] array = {result1.getInt(1), result1.getInt(2)};
      listItem.put(product, array);
    }
    ExportReceipt receipt = new ExportReceipt();
    receipt.setCode(idNumber);
    receipt.setSalesPerson(salesman);
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date date = df.parse(strDate);
    receipt.setTime(date);
    receipt.setListItem(listItem);
    return receipt;
  }
  
  /**
   * Method loads list of ExportReceipt's object.
   * @return list of ExportReceipt's object
   * @throws SQLException SQLException
   * @throws ParseException ParseException
   */
  
  public static ArrayList<ExportReceipt> loadExportReceipt() throws SQLException, ParseException {
    String sql = "select id_receipt from receipt_salesman";
    ConnectDatabase connect = new ConnectDatabase();
    ResultSet result = connect.getStatement().executeQuery(sql);
    ArrayList<ExportReceipt> receiptList = new ArrayList<>();
    ExportReceipt receipt;
    while (result.next()) {
      receipt = loadExportReceiptById(result.getInt(1));
      receiptList.add(receipt);
    }
    return receiptList;
  }
  
  public static String loadLinkPathImportReceipt() throws SQLException {
    String sql = "select path from import_path where id = 1";
    ResultSet result = new ConnectDatabase().getStatement().executeQuery(sql);
    String path = "";
    while (result.next()) {
      path = result.getString(1);
    }
    return path;
  }
  
}
