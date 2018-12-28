package javaproject1227;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
//java는 구조체가 없으므로 class로 구조체를 만듬
public class Product {
	private int prcode;
	private String prname;
	private int price;
	private String manufacture;
	
	public int getPrcode() {
		return prcode;
	}
	public void setPrcode(int prcode) {
		this.prcode = prcode;
	}
	
	public String getPrname() {
		return prname;
	}
	public void setPrname(String prname) {
		this.prname = prname;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getManu() {
		return manufacture;
	}
	public void setManu(String manufacture) {
		this.manufacture = manufacture;
	}
	
	
	
}
