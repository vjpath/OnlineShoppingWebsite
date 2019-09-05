package com.OnlineShopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.OnlineShopping.config.DBConnect;
import com.OnlineShopping.pojo.User;
public class UserDao {
	Connection con=DBConnect.getConnect();
	public boolean addUser(User u) {
		String sql="insert into user values(?,?,?,?)";
		try {
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getContact());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPass());
			
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("success");
				return true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean updateUser(User u) {
		String sql="update user set name=?,contact=?,pass=? where email=?";
		try {
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getContact());
			ps.setString(3, u.getPass());
			ps.setString(4, u.getEmail());
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("Success");
				return true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public boolean deleteUser(String  email) {
		String sql="delete from user where email=?";
		try {
			
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1, email);
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("success");
				return true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<User> getUserList(){
		String sql="select * from user";
		List<User> al=new ArrayList<>();
		try {
			
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				User u=new User();
				u.setName(rs.getString(1));
				u.setContact(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPass(rs.getString(4));
				al.add(u);
			}
			return al;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public User getUserByEmail(String email){
		String sql="select * from user where email=?";
		User u=new User();
		try {
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				u.setName(rs.getString(1));
				u.setContact(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPass(rs.getString(4));
		
			}
			return u;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
