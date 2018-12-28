package javaDB;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class EventRegist {
	Scanner scanner = new Scanner(System.in);
	
	String jdbcDriver = "com.mysql.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://localhost/java";
	Connection conn;
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	public EventRegist() {
		System.out.println("이벤트 등록을 위해 이름과 이메일을 입력하세요.");
		System.out.print("이름 : ");
		String uname = scanner.next();
		System.out.print("이메일 : ");
		String email = scanner.next();
		
		connectDB();
		registerUser(uname, email);
		printList();
		closeDB();
	}
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	         
	         String url = "jdbc:mysql://localhost:3306/java?characterEncoding=UTF-8&serverTimezone=UTC";  // localhost/db이름
	         conn = DriverManager.getConnection(url, "kingjw", "1066223gks!"); // url, username, password
	         System.out.println("connect success1");
	         
	         
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void closeDB() {
		try {
			pstmt.close();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void registerUser(String uname, String email) {
		String sql = "insert into event value(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, email);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void printList() {
		System.out.println("# 등록자명단");
		String sql = "select * from event";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("uname") + ","+rs.getString(2));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] dargs) {
		System.out.println("1-> insert");
		System.out.println("2-> delete");
		Scanner scanner = new Scanner(System.in);
		int sel = scanner.nextInt();
		
		switch(sel) {
		case 1:
			EventRegist er = new EventRegist();
			break;
		case 2:
			DeleteRegist dr = new DeleteRegist();
			break;
		default :
			System.out.println("error");
		}
			
		
		
	}
}
