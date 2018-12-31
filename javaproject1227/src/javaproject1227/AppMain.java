package javaproject1227;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class AppMain extends JFrame{
	
	public ProductDao dao;
	public JLabel m1;
	public JPanel p1,p2,p3;
	public JComboBox cb;
	public JTextArea ta, prnameta, priceta, manuta;
	public JScrollPane scroll1,scroll2;
	boolean editmode;
	public JButton searchbtn;
	public JButton deletebtn;
	public JButton enrollbtn;
	
	ArrayList<Product> datas;
	Vector<String> items;
	
	public AppMain() {//생성자
		dao = new ProductDao();
		datas = new ArrayList<Product>();
		items = new Vector<String>();
		this.startUI();
	}
	public void startUI() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("관리프로그램");
		this.setSize(800,400);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		m1 = new JLabel();
		scroll1 = new JScrollPane();
		cb = new JComboBox();
		ta = new JTextArea(10,40);
		JScrollPane scroll1 = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		
		this.add(m1, BorderLayout.PAGE_START);
		this.add(p1, BorderLayout.LINE_START);
		this.add(p2, BorderLayout.CENTER);
		this.add(scroll1, BorderLayout.LINE_END);
		this.add(p3, BorderLayout.PAGE_END);
		
		JLabel lb1 = new JLabel("pcode");
		JLabel lb2 = new JLabel("pname");
		JLabel lb3 = new JLabel("price");
		JLabel lb4 = new JLabel("manufacture");
		
		ButtonClick bc = new ButtonClick();
		
		enrollbtn = new JButton("등록");
		searchbtn = new JButton("검색");
		deletebtn = new JButton("삭제");
		enrollbtn.addActionListener(bc);
		deletebtn.addActionListener(bc);
		searchbtn.addActionListener(bc);
		
		prnameta = new JTextArea(5,20);
		priceta = new JTextArea(5,20);
		manuta = new JTextArea(5,20);
		
		p1.add(lb1);
		p1.add(lb2);
		p1.add(lb3);
		p1.add(lb4);
		
		p1.setLayout(new GridLayout(4,1));
		p1.add(cb);
		p1.add(prnameta);
		p1.add(priceta);
		p1.add(manuta);
		
		p2.add(cb);
		p2.add(prnameta);
		p2.add(priceta);
		p2.add(manuta);
		
		cb.setBounds(30, 33, 1000000000, 100000000);
		prnameta.setBounds(100, 200, 120, 40);
		priceta.setBounds(30, 250, 120, 40);
		manuta.setBounds(30, 300, 120, 40);
		
		p3.add(enrollbtn);
		p3.add(searchbtn);
		p3.add(deletebtn);

		
		m1.setText("상품관리프로그램");
		
		
		refreshData();
	}
	
	public void refreshData() {
		ta.setText("");
		clearField();
		editmode = false;
		
		ta.append("관리번호\t상품명\t\t단가\t제조사\n");
		datas = dao.getAll();
		
		cb.setModel(new DefaultComboBoxModel(dao.getItems()));
		
		if(datas != null) {
			for(Product p : datas) {
				StringBuffer sb = new StringBuffer();
				sb.append(p.getPrcode() + "\t");
				sb.append(p.getPrname() + "\t\t");
				sb.append(p.getPrice() + "\t");
				sb.append(p.getManu() + "\n");
				ta.append(sb.toString());
			}
		}
		else {
			ta.append("등록된 상품이 없습니다. \n상품을 등록해 주세요");
		}
	}
	
	public void clearField() {
		prnameta.setText("");
		priceta.setText("");
		manuta.setText("");
	}
	
	public class ButtonClick implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == searchbtn) {
				int checkboxval = Integer.parseInt((String)cb.getSelectedItem());
				Product p = new Product();
				p = dao.getProduct(checkboxval);
				
				if(p != null) {
					prnameta.setText(p.getPrname());
					priceta.setText(String.valueOf(p.getPrice()));
					manuta.setText(p.getManu());
				} else {
					System.out.println("결과 x");
				}
			} //searchbtn if 
			else if(e.getSource() == deletebtn) {
				int checkboxval = Integer.parseInt((String)cb.getSelectedItem());
				boolean flag = false;
				
				flag = dao.delProduct(checkboxval);
				
				if(flag)
					refreshData();
				else 
					System.out.println("?");
			}//deletebtn
			else if(e.getSource() == enrollbtn) {
				Product p = new Product();
				boolean enrollflag = false;
				
				p.setPrname(prnameta.getText());
				p.setPrice(Integer.parseInt(priceta.getText()));
				p.setManu(manuta.getText());
				
				enrollflag = dao.newProduct(p);
				
				if(enrollflag)
					refreshData();
				else
					System.out.print("???");
			}
		}
	}
}
