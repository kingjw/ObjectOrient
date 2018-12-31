package javaproject1227;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class ProductDao {
	String jdbcDriver = "com.mysql.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://localhost/java";
	Connection conn;
	
	PreparedStatement pstmt;
	ResultSet rs;
	

	Vector<String> items = null;
	String sql ="";
	public ProductDao() {
		connectDB();
		//getProduct(1);
		//closeDB();
	}
	public ArrayList<Product> getAll(){
		sql = "select * from product";
		
		ArrayList<Product> datas = new ArrayList<Product>();
		
		items = new Vector<String>();
		items.add("전체");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setPrcode(rs.getInt("prcode"));
				p.setPrname(rs.getString("prname"));
				p.setPrice(rs.getInt("price"));
				p.setManu(rs.getString("manufacture"));
				datas.add(p);
				items.add(String.valueOf(rs.getInt("prcode")));
			}
		}catch(SQLException e) {
			System.out.print("error arraylist");
		}
		return datas;
	}
	
	protected void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	         
	         String url = "jdbc:mysql://localhost:3306/java?characterEncoding=UTF-8&serverTimezone=UTC";  // localhost/db이름
	         conn = DriverManager.getConnection(url, "kingjw", "1066223gks!"); // url, username, password
	         System.out.println("connect success1");
	         
	         
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void closeDB() {
		try {
			pstmt.close();
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Product getProduct(int prcode) {
		sql = "select * from product where prcode = ?";
		Product p = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prcode);
			rs = pstmt.executeQuery();
			rs.next();
			p = new Product();
			p.setPrcode(rs.getInt("prcode"));
			p.setPrname(rs.getString("prname"));
			p.setPrice(rs.getInt("price"));
			p.setManu(rs.getString("manufacture"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public boolean newProduct(Product product) {
		sql = "insert into product values(?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  product.getPrcode());
			pstmt.setString(2, product.getPrname());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getManu());
			int resultNum = pstmt.executeUpdate();
			
			if(resultNum != 0)
				return true;
			else
				return false;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean delProduct(int prcode) {
		sql = "delete from product where prcode = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prcode);
			int resultNum = pstmt.executeUpdate();
			if(resultNum != 0)
				return true;
			else
				return false;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean updateProduct(Product product) {
		sql = "update from product set prname = ?, price = ?, manufacture = ? where prcode = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPrname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getManu());
			pstmt.setInt(4, product.getPrice());
			int resultNum = pstmt.executeUpdate();
			
			if(resultNum != 0)
				return true;
			else
				return false;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	Vector<String> getItems(){
		return this.items;
	}
}
