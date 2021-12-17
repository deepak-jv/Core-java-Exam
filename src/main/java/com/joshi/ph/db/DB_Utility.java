package com.joshi.ph.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Utility {

	private static Connection cn;
	
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ph_db?user=root&password=root");
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		
	}

	

	
	public boolean testc(){
		
		if (cn != null) 
			return true;
		
		else 
			return false;
		
	}
//object prepared statement	
	
	public PreparedStatement Create(String sql) throws SQLException {
		
		return cn.prepareStatement(sql);
	}
		
//insert/update/delete operations
		
	public int update(PreparedStatement ps) throws SQLException{
		return ps.executeUpdate();
	}
	
// to get data from database	
	public ResultSet query(PreparedStatement ps) throws SQLException{
		return ps.executeQuery();
	}
		
	}

