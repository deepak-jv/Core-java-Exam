package com.joshi.oops.ph_book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


public class PhnBook_update_data2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ph_db?user=root&password=root");
//		System.out.println(cn);
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the id which you want to update");
		int id = sc.nextInt();
		System.out.println("enter new name");
		String name = sc.next();
		System.out.println("enter the updated phone number");
		int ph_no = sc.nextInt();
	
		
		String sql = "update phonebook set name=? , ph_number=? where id=?";
		PreparedStatement stm = cn.prepareStatement(sql);
		stm.setString(1, name);
		stm.setInt(2, ph_no);
		stm.setInt(3, id);
		int flag = stm.executeUpdate();
		
		
		if(flag>0) {
		System.out.println("the name "+name+" with phone number "+ph_no+" successfully updated at ID = "+id+" to the phonebook table in ph_db database");
		}
		else {
			System.out.println("error");
		}
		
		cn.close();
		
	}

}
