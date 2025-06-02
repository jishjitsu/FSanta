// javac jdbc1.java
// java -cp "mysql-connector-j-8.0.32.jar;." jdbc1

import java.sql.*;

class jdbc1 {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/22bd1a0528";
    
  static final String USER = "root";
  static final String PASS = " ";
     
  public static void main(String[] args) throws SQLException {  
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try{
      Class.forName(JDBC_DRIVER);
      System.out.println("Connecting to database...");

      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      System.out.println("Creating statement...");

      stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
      String sql;
      sql = "SELECT empno, ename, salary from emp where empno > 7600";
      rs = stmt.executeQuery(sql);

      while(rs.next()){
        int empno  = rs.getInt("EMPNO");
        String name = rs.getString("ENAME");
        int sal=rs.getInt("salary");
        System.out.print(" empno : " +empno);
        System.out.print(" name : " + name);
        System.out.println(" sal : " + sal);
      }

      String update="update emp set salary=salary+500";
      int result = stmt.executeUpdate(update);
      System.out.println("updated rows  " + result);

      sql = "SELECT empno, ename, salary from emp where empno > 7600";
      rs = stmt.executeQuery(sql);

      System.out.println("After update");
      while(rs.next()){
        int empno  = rs.getInt("EMPNO");
        String name = rs.getString("ENAME");
        int sal=rs.getInt("salary");
        System.out.print(" empno : " +empno);
        System.out.print(" name : " + name);
        System.out.println(" sal : " + sal);
      }  
    }  
    catch(Exception e){
      e.printStackTrace();
    }
    finally
    {
      rs.close();
      stmt.close();
      conn.close();
    }
  }
}     
