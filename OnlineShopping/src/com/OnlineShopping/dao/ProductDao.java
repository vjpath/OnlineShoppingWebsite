package com.OnlineShopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import com.OnlineShopping.config.DBConnect;
import com.OnlineShopping.pojo.Product;
import com.OnlineShopping.pojo.User;

public class ProductDao {
	Connection con=DBConnect.getConnect();
	public boolean addProduct(Product p) {
	String sql="insert into products(PRODUCT_NAME, CATEGORY, QUANTITY, PRICE, DESCRIPTION) values(?,?,?,?,?)";
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, p.getPname());
		ps.setString(2, p.getCategory());
		ps.setInt(3, p.getQuantity());
		ps.setFloat(4, p.getPrice());
		
		ps.setString(5, p.getDescription());
		int i=ps.executeUpdate();
		if(i>0)
		{
			return true;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return false;
}
	public List<Product> getProductList(){
		String sql="select * from products";
		List<Product> lp= new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setCategory(rs.getString(3));
				p.setQuantity(rs.getInt(4));
				p.setPrice(rs.getInt(5));
				p.setDescription(rs.getString(6));
				
				lp.add(p);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lp;
	}
	
	public boolean deleteProduct(int pid) {
		String sql="delete from products where PRODUCT_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			int i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public Product getProductById(int pid){
		String sql="select * from products where PRODUCT_id=?";
		Product p=new Product();
		try {
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setCategory(rs.getString(3));
				p.setQuantity(rs.getInt(4));
				p.setPrice(rs.getFloat(5));
				p.setDescription(rs.getString(6));
				
			}
			return p;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
