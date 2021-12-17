package com.joshi.ph.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.joshi.ph.db.DB_Utility;
import com.joshi.ph.model.User;

public class UserDaoImpl implements User_IF {
	
	DB_Utility db = new DB_Utility();
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public int save(User u) throws SQLException {
		String sql = "insert into phonebook(name,ph_number) value(?,?)";
		ps = db.Create(sql);
		ps.setString(1,u.getName());
		ps.setInt(2,u.getPh_number());
		
		return db.update(ps);
	}

	@Override
	public int update(User u) throws SQLException {
		String sql = "Update phonebook set name=?,ph_number=? where id=?";
		ps = db.Create(sql);
		ps.setString(1,u.getName());
		ps.setInt(2,u.getPh_number());
		ps.setInt(3,u.getId());
	
		return db.update(ps);
	}

	@Override
	public int delete(User u) throws SQLException {
		String sql = "delete from phonebook where id=?";
		ps = db.Create(sql);
		ps.setInt(1, u.getId());
		
		return db.update(ps);
	}

	@Override
	public User findById(int id) throws SQLException {

		String sql = "select * from phonebook where id=?";
		ps = db.Create(sql);
		ps.setInt(1, id);
		rs = db.query(ps);
		
		User u = new User();
		if(rs.next()) {
		u.setId(rs.getInt("id"));
		u.setName(rs.getString("name"));
		u.setPh_number(rs.getInt("ph_number"));
		
		}
		return  u;
	}

	@Override
	public User findByName(String name) throws SQLException {

		String sql = "select * from phonebook where name=?";
		ps = db.Create(sql);
		ps.setString(1, name);
		rs = db.query(ps);
		
		User u = new User();
		if(rs.next()) {
		u.setId(rs.getInt("id"));
		u.setName(rs.getString("name"));
		u.setPh_number(rs.getInt("ph_number"));
		
		}
		return  u;
		
	}

	@Override
	public User findByNumber(int ph_number) throws SQLException {
		
		String sql = "select * from phonebook where ph_number=?";
		ps = db.Create(sql);
		ps.setInt(1, ph_number);
		rs = db.query(ps);
		
		User u = new User();
		if(rs.next()) {
		u.setId(rs.getInt("id"));
		u.setName(rs.getString("name"));
		u.setPh_number(rs.getInt("ph_number"));
		
		}
		return  u;
	}
	
	@Override
	public List<User> getall() throws SQLException{
		String sql = "select * from phonebook";
		ps = db.Create(sql);
		rs = db.query(ps);
		List<User> usr = new ArrayList();
		while(rs.next()) {
			
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPh_number(rs.getInt("ph_number"));
			usr.add(u);
		}
		
		
		return usr;
	}

}
