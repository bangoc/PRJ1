package model.employee;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import model.connectDatabase.CostResult;
import model.market.Cost;
import model.market.Result;
import model.market.TypeCost;

public class Manager extends Employee {

  
  public Manager() {
    
  }
  
  public Manager(int id, String name, Gender gender, Date birthday, String address, 
      String phone, int coefficient, ImageIcon img, Account account) {
    super(id, name, gender, birthday, address, phone, coefficient, img, account);
  }
  
  public static Cost createSalaryCost(ArrayList<Employee> employees) {
      int total = 0;
      total = employees.stream().map((employee) -> employee.countSalary()).reduce(total, Integer::sum);
      
      return new Cost(TypeCost.TIENLUONG, new Date(), total);
  }
  
  public static long countProfit(ArrayList<Result> resultsExport, 
          ArrayList<Result> resultImport, ArrayList<CostResult> resultCost) {
      long total = 0;
      for (Result r : resultsExport) {
          total += r.getValue();
      }
      
      for (Result r : resultImport) {
          total -= r.getValue();
      }
      
      for (CostResult sr : resultCost) {
          total -= sr.getTotal();
      }
      
      return total;
  }
}
  
  

