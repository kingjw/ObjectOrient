package javaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteRegist {
	Scanner scanner = new Scanner(System.in);
	String jdbcDriver = "com.mysql.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://localhost/java";
	Connection conn;
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DeleteRegist() {
		System.out.print("지워야할 이름을 입력하세요 : ");
		String uname = scanner.next();
		connectDB();
		deleteUser(uname);
		printList();
		closeDB();
	}

	private void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	         
	         String url = "jdbc:mysql://localhost:3306/java?characterEncoding=UTF-8&serverTimezone=UTC";  // localhost/db이름
	         conn = DriverManager.getConnection(url, "kingjw", "1066223gks!"); // url, username, password
	         System.out.println("connect success2");
	         
	         
		}catch(Exception e) {
			System.out.println("error in connectDB");
		}
	}
	public void closeDB() {
		try {
			pstmt.close();
			rs.close();
			conn.close();
		} catch(SQLException e) {
			System.out.println("error in closeDB");
		}
	}
	private void deleteUser(String uname) {
		String sql = "delete from event where uname = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,uname);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("error in deleteuser");
		}
	}
	private void printList() {
		System.out.println("# 등록자명단");
		String sql = "select * from event";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("uname") + ","+rs.getString(2));
			}
		} catch(SQLException e) {
			System.out.println("error in printlist");
		}
	}
	
}
