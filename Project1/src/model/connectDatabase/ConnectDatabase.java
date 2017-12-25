package model.connectDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDatabase {
  
  public static Connection createConnect() throws IOException, ClassNotFoundException, SQLException {
    // doc du lieu tu file properties
    Properties prop = new Properties();
      FileInputStream input = new FileInputStream("../Project1/src/jdbc.properties");
    prop.load(input);

    String driverClass = prop.getProperty("MYSQLJDBC.driver");
    String url = prop.getProperty("MYSQLJDBC.url");
    String userName = prop.getProperty("MYSQLJDBC.username");
    String password = prop.getProperty("MYSQLJDBC.password");
    
    Class.forName(driverClass);  
    
    // tao ket noi toi co so du lieu
    Connection connect = DriverManager.getConnection(url,userName,password); 

    return connect;
    
  }
 
}
