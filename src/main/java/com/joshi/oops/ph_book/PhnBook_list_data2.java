package com.joshi.oops.ph_book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.cj.xdevapi.Result;


public class PhnBook_list_data2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ph_db?user=root&password=root");
		System.out.println(cn);
		
		
		
		
		String sql ="select * from phonebook";
		PreparedStatement stm = cn.prepareStatement(sql);
		
		ResultSet rs = stm.executeQuery();
		System.out.println("Id:\t Name:\t Phone Number:");
		while (rs.next()) {
			
			System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t  "+rs.getInt("ph_number"));
		}
		
		cn.close();
		
	}

}
