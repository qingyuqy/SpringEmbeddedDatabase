package com.qingyu.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qingyu.sample.vo.User;

public class UserDAO {

	Connection conn;
	
	public void setConn(Connection conn){
		this.conn = conn;
	}
	
	public User getUser(String name) {
		String sql = "select * from user where username = ?";
		PreparedStatement ps;
		ResultSet rs;
		User user = null;
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()){
				user = new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
			}
		}catch(SQLException e){
			System.out.println("SQLException" + e.getMessage());
		}catch(Exception e){
			System.out.println("Exception" + e.getMessage());
		}
		
		return user;

	}
}
