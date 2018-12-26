package javaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBconnection {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Connection conn = null;
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         
         String url = "jdbc:mysql://localhost:3306/world?characterEncoding=UTF-8&serverTimezone=UTC";  // localhost/db이름
         conn = DriverManager.getConnection(url, "kingjw", "1066223gks!"); // url, username, password
         System.out.println("connect success");
         
         String sql ="select * from city where ID > 4070;";
         Statement stmt = conn.createStatement();
         stmt.executeQuery(sql);
         ResultSet rs = stmt.executeQuery(sql);
         while(rs.next()) {
        	 String id = rs.getString(1);
        	 String code = rs.getString(3);
        	 System.out.println(id + "," + code);
         }
        
      }
      catch(ClassNotFoundException e) {
         System.out.println("driver loading connect failed");
      }
      catch(SQLException e) {
         System.out.println("error: " + e);
      }
      finally {
         try{
            if(conn != null && ! conn.isClosed()) {
               conn.close();
            }
         }
         catch(SQLException e) {
            e.printStackTrace();
         }
      }
   }

}