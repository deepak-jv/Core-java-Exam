package com.joshi.ph.dao;

import java.sql.SQLException;
import java.util.List;

import com.joshi.ph.model.User;

public interface User_IF {
	
	public int save(User u) throws SQLException;
	public int update(User u) throws SQLException;
	public int delete(User u) throws SQLException;
	public User findById(int id) throws SQLException;
	public User findByName(String name) throws SQLException;
	public User findByNumber(int ph_number) throws SQLException;
	public List<User> getall() throws SQLException;
	

}
