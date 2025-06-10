// javac jdbc8.java
// java -cp "mysql-connector-j-8.0.32.jar;." jdbc8

import java.sql.*;
import java.time.*;

class jdbc8 {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/22bd1a0528";
    
  static final String USER = "root";
  static final String PASS = "wabisbi";
     
  public static void main(String[] args) throws SQLException {  
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try{
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
          ResultSet.CONCUR_READ_ONLY);

      String sql;
      sql = "SELECT eno from emp1";
      rs = stmt.executeQuery(sql);  
      rs.next();
      System.out.println(rs.getInt("empno")); 
    }   
    catch(SQLException e){
      System.out.println("GetMessage "+e.getMessage());
      System.out.println("GetSQLState "+e.getSQLState());
      System.out.println("GetErrorCode "+e.getErrorCode());
    }
    finally
    {
      conn.close();
    }
  }
}     
