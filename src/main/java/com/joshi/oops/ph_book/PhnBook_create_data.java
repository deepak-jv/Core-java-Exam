package com.joshi.oops.ph_book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


public class PhnBook_create_data {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ph_db?user=root&password=root");
//		System.out.println(cn);
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name");
		String name = sc.next();
		System.out.println("enter phone number");
		int ph_no = sc.nextInt();
		
		String sql = "insert into phonebook(name,ph_number) values(?,?)";
		PreparedStatement stm = cn.prepareStatement(sql);
		stm.setString(1, name);
		stm.setInt(2, ph_no);
		stm.addBatch();
		stm.setString(1, name);
		stm.setInt(2, ph_no);
		
	    stm.executeBatch();
		
//		int flag = stm.executeUpdate();
		
		
//		if() {
		System.out.println("the name "+name+" with phone number "+ph_no+" successfully added to the phonebook table in ph_db database");
		
		
//		}
		cn.close();
		
		
	}

}
