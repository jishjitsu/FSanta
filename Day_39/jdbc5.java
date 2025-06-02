// javac jdbc5.java
// java -cp "mysql-connector-j-8.0.32.jar;." jdbc5

import java.sql.*;
import java.time.*;

class jdbc5 {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost/22bd1a0528";
    
  static final String USER = "root";
  static final String PASS = " ";
     
  public static void main(String[] args) throws SQLException {  
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try
	{
	  conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		  ResultSet.CONCUR_UPDATABLE);

      String sql;
      sql = "SELECT empno from emp";
      rs = stmt.executeQuery(sql);  
      while(rs.next())
		{
	  System.out.println(rs.getInt(1));
	  }
      System.out.println(rs.previous());
      System.out.println(rs.getInt(1)); 
      System.out.println(rs.previous());
      System.out.println(rs.getInt(1));
      System.out.println(rs.last()); 
      System.out.println(rs.getInt(1)); 
      System.out.println(rs.first()); 
      System.out.println(rs.getInt(1)); 
      //rs.beforeFirst();
      System.out.println(rs.getInt(1));             
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
